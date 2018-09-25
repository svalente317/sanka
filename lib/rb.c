/* libavl - library for manipulation of binary trees.
   Copyright (C) 1998-2002, 2004 Free Software Foundation, Inc.

   This program is free software; you can redistribute it and/or
   modify it under the terms of the GNU General Public License as
   published by the Free Software Foundation; either version 2 of the
   License, or (at your option) any later version.

   This program is distributed in the hope that it will be useful, but
   WITHOUT ANY WARRANTY; without even the implied warranty of
   MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
   See the GNU General Public License for more details.

   You should have received a copy of the GNU General Public License
   along with this program; if not, write to the Free Software
   Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA
   02111-1307, USA.

   The author may be contacted at <blp@gnu.org> on the Internet, or
   write to Ben Pfaff, Stanford University, Computer Science Dept., 353
   Serra Mall, Stanford CA 94305, USA.
*/

#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include "rb.h"

extern void PANIC(const char *);

struct rb_table *
rb_create (short use_strcmp)
{
  struct rb_table *tree;

  tree = malloc (sizeof *tree);
  if (tree == NULL)
    PANIC("out of memory error");

  tree->rb_root = NULL;
  tree->rb_count = 0;
  tree->rb_generation = 0;
  tree->use_strcmp = use_strcmp;

  return tree;
}

static inline int
rb_compare(const struct rb_table *tree, union rb_key lhs, union rb_key rhs)
{
  if (!tree->use_strcmp)
    {
      return lhs.i < rhs.i ? -1 : (lhs.i > rhs.i ? +1 : 0);
    }
  return strcmp (lhs.cp, rhs.cp);
}

int
rb_find (const struct rb_table *tree, union rb_key key,
         union rb_value *pvp)
{
  const struct rb_node *p;

  for (p = tree->rb_root; p != NULL; )
    {
      int cmp = rb_compare(tree, key, p->rb_key);
      if (cmp < 0)
        p = p->rb_link[0];
      else if (cmp > 0)
        p = p->rb_link[1];
      else /* |cmp == 0| */
        {
          *pvp = p->rb_value;
          return 1;
        }
    }

  return 0;
}

int
rb_put (struct rb_table *tree, union rb_key key, union rb_value value,
        union rb_value *pvp)
{
  struct rb_node *pa[RB_MAX_HEIGHT]; /* Nodes on stack. */
  unsigned char da[RB_MAX_HEIGHT];   /* Directions moved from stack nodes. */
  int k;                             /* Stack height. */

  struct rb_node *p; /* Traverses tree looking for insertion point. */
  struct rb_node *n; /* Newly inserted node. */

  pa[0] = (struct rb_node *) &tree->rb_root;
  da[0] = 0;
  k = 1;
  for (p = tree->rb_root; p != NULL; p = p->rb_link[da[k - 1]])
    {
      int cmp = rb_compare(tree, key, p->rb_key);
      if (cmp == 0)
        {
          if (pvp)
            *pvp = p->rb_value;
          p->rb_value = value;
          return 1;
        }
      pa[k] = p;
      da[k++] = cmp > 0;
    }

  n = pa[k - 1]->rb_link[da[k - 1]] = malloc (sizeof *n);
  if (n == NULL)
    PANIC("out of memory error");

  n->rb_key = key;
  n->rb_value = value;
  n->rb_link[0] = n->rb_link[1] = NULL;
  n->rb_color = RB_RED;
  tree->rb_count++;
  tree->rb_generation++;

  while (k >= 3 && pa[k - 1]->rb_color == RB_RED)
    {
      if (da[k - 2] == 0)
        {
          struct rb_node *y = pa[k - 2]->rb_link[1];
          if (y != NULL && y->rb_color == RB_RED)
            {
              pa[k - 1]->rb_color = y->rb_color = RB_BLACK;
              pa[k - 2]->rb_color = RB_RED;
              k -= 2;
            }
          else
            {
              struct rb_node *x;

              if (da[k - 1] == 0)
                y = pa[k - 1];
              else
                {
                  x = pa[k - 1];
                  y = x->rb_link[1];
                  x->rb_link[1] = y->rb_link[0];
                  y->rb_link[0] = x;
                  pa[k - 2]->rb_link[0] = y;
                }

              x = pa[k - 2];
              x->rb_color = RB_RED;
              y->rb_color = RB_BLACK;

              x->rb_link[0] = y->rb_link[1];
              y->rb_link[1] = x;
              pa[k - 3]->rb_link[da[k - 3]] = y;
              break;
            }
        }
      else
        {
          struct rb_node *y = pa[k - 2]->rb_link[0];
          if (y != NULL && y->rb_color == RB_RED)
            {
              pa[k - 1]->rb_color = y->rb_color = RB_BLACK;
              pa[k - 2]->rb_color = RB_RED;
              k -= 2;
            }
          else
            {
              struct rb_node *x;

              if (da[k - 1] == 1)
                y = pa[k - 1];
              else
                {
                  x = pa[k - 1];
                  y = x->rb_link[0];
                  x->rb_link[0] = y->rb_link[1];
                  y->rb_link[1] = x;
                  pa[k - 2]->rb_link[1] = y;
                }

              x = pa[k - 2];
              x->rb_color = RB_RED;
              y->rb_color = RB_BLACK;

              x->rb_link[1] = y->rb_link[0];
              y->rb_link[0] = x;
              pa[k - 3]->rb_link[da[k - 3]] = y;
              break;
            }
        }
    }
  tree->rb_root->rb_color = RB_BLACK;

  return 0;
}

int
rb_delete (struct rb_table *tree, union rb_key key,
           union rb_value *pvp)
{
  struct rb_node *pa[RB_MAX_HEIGHT]; /* Nodes on stack. */
  unsigned char da[RB_MAX_HEIGHT];   /* Directions moved from stack nodes. */
  int k;                             /* Stack height. */

  struct rb_node *p;    /* The node to delete, or a node part way to it. */
  int cmp;              /* Result of comparison between |key| and |p|. */

  k = 0;
  p = (struct rb_node *) &tree->rb_root;
  for (cmp = -1; cmp != 0;
       cmp = rb_compare(tree, key, p->rb_key))
    {
      int dir = cmp > 0;

      pa[k] = p;
      da[k++] = dir;

      p = p->rb_link[dir];
      if (p == NULL)
        return 0;
    }
  *pvp = p->rb_value;

  if (p->rb_link[1] == NULL)
    pa[k - 1]->rb_link[da[k - 1]] = p->rb_link[0];
  else
    {
      enum rb_color t;
      struct rb_node *r = p->rb_link[1];

      if (r->rb_link[0] == NULL)
        {
          r->rb_link[0] = p->rb_link[0];
          t = r->rb_color;
          r->rb_color = p->rb_color;
          p->rb_color = t;
          pa[k - 1]->rb_link[da[k - 1]] = r;
          da[k] = 1;
          pa[k++] = r;
        }
      else
        {
          struct rb_node *s;
          int j = k++;

          for (;;)
            {
              da[k] = 0;
              pa[k++] = r;
              s = r->rb_link[0];
              if (s->rb_link[0] == NULL)
                break;

              r = s;
            }

          da[j] = 1;
          pa[j] = s;
          pa[j - 1]->rb_link[da[j - 1]] = s;

          s->rb_link[0] = p->rb_link[0];
          r->rb_link[0] = s->rb_link[1];
          s->rb_link[1] = p->rb_link[1];

          t = s->rb_color;
          s->rb_color = p->rb_color;
          p->rb_color = t;
        }
    }

  if (p->rb_color == RB_BLACK)
    {
      for (;;)
        {
          struct rb_node *x = pa[k - 1]->rb_link[da[k - 1]];
          if (x != NULL && x->rb_color == RB_RED)
            {
              x->rb_color = RB_BLACK;
              break;
            }
          if (k < 2)
            break;

          if (da[k - 1] == 0)
            {
              struct rb_node *w = pa[k - 1]->rb_link[1];

              if (w->rb_color == RB_RED)
                {
                  w->rb_color = RB_BLACK;
                  pa[k - 1]->rb_color = RB_RED;

                  pa[k - 1]->rb_link[1] = w->rb_link[0];
                  w->rb_link[0] = pa[k - 1];
                  pa[k - 2]->rb_link[da[k - 2]] = w;

                  pa[k] = pa[k - 1];
                  da[k] = 0;
                  pa[k - 1] = w;
                  k++;

                  w = pa[k - 1]->rb_link[1];
                }

              if ((w->rb_link[0] == NULL
                   || w->rb_link[0]->rb_color == RB_BLACK)
                  && (w->rb_link[1] == NULL
                      || w->rb_link[1]->rb_color == RB_BLACK))
                w->rb_color = RB_RED;
              else
                {
                  if (w->rb_link[1] == NULL
                      || w->rb_link[1]->rb_color == RB_BLACK)
                    {
                      struct rb_node *y = w->rb_link[0];
                      y->rb_color = RB_BLACK;
                      w->rb_color = RB_RED;
                      w->rb_link[0] = y->rb_link[1];
                      y->rb_link[1] = w;
                      w = pa[k - 1]->rb_link[1] = y;
                    }

                  w->rb_color = pa[k - 1]->rb_color;
                  pa[k - 1]->rb_color = RB_BLACK;
                  w->rb_link[1]->rb_color = RB_BLACK;

                  pa[k - 1]->rb_link[1] = w->rb_link[0];
                  w->rb_link[0] = pa[k - 1];
                  pa[k - 2]->rb_link[da[k - 2]] = w;
                  break;
                }
            }
          else
            {
              struct rb_node *w = pa[k - 1]->rb_link[0];

              if (w->rb_color == RB_RED)
                {
                  w->rb_color = RB_BLACK;
                  pa[k - 1]->rb_color = RB_RED;

                  pa[k - 1]->rb_link[0] = w->rb_link[1];
                  w->rb_link[1] = pa[k - 1];
                  pa[k - 2]->rb_link[da[k - 2]] = w;

                  pa[k] = pa[k - 1];
                  da[k] = 1;
                  pa[k - 1] = w;
                  k++;

                  w = pa[k - 1]->rb_link[0];
                }

              if ((w->rb_link[0] == NULL
                   || w->rb_link[0]->rb_color == RB_BLACK)
                  && (w->rb_link[1] == NULL
                      || w->rb_link[1]->rb_color == RB_BLACK))
                w->rb_color = RB_RED;
              else
                {
                  if (w->rb_link[0] == NULL
                      || w->rb_link[0]->rb_color == RB_BLACK)
                    {
                      struct rb_node *y = w->rb_link[1];
                      y->rb_color = RB_BLACK;
                      w->rb_color = RB_RED;
                      w->rb_link[1] = y->rb_link[0];
                      y->rb_link[0] = w;
                      w = pa[k - 1]->rb_link[0] = y;
                    }

                  w->rb_color = pa[k - 1]->rb_color;
                  pa[k - 1]->rb_color = RB_BLACK;
                  w->rb_link[0]->rb_color = RB_BLACK;

                  pa[k - 1]->rb_link[0] = w->rb_link[1];
                  w->rb_link[1] = pa[k - 1];
                  pa[k - 2]->rb_link[da[k - 2]] = w;
                  break;
                }
            }

          k--;
        }

    }

  free (p);
  tree->rb_count--;
  tree->rb_generation++;
  return 1;
}
