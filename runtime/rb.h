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

#ifndef RB_H
#define RB_H 1

#include <stddef.h>

#ifndef RB_MAX_HEIGHT
#define RB_MAX_HEIGHT 48
#endif

struct rb_table
  {
    struct rb_node *rb_root;
    size_t rb_count;
    unsigned long rb_generation;
    short use_strcmp;
};

enum rb_color
  {
    RB_BLACK,
    RB_RED
  };

union rb_key
  {
    int i;
    const char *cp;
  };

union rb_value
  {
    int i;
    long ln;
    float f;
    double d;
    void *vp;
  };

struct rb_node
  {
    struct rb_node *rb_link[2];
    union rb_key rb_key;
    union rb_value rb_value;
    unsigned char rb_color;
  };


struct rb_table *rb_create (short);
int rb_find(const struct rb_table *, union rb_key, union rb_value *);
int rb_put(struct rb_table *, union rb_key, union rb_value, union rb_value *);
int rb_delete(struct rb_table *, union rb_key, union rb_value *);
#define rb_count(table) ((size_t) (table)->rb_count)

struct rb_traverser
  {
    struct rb_table *rb_table;
    struct rb_node *rb_node;
    struct rb_node *rb_stack[RB_MAX_HEIGHT];
    size_t rb_height;
    unsigned long rb_generation;
  };

void rb_t_init (struct rb_traverser *trav, struct rb_table *tree);
int rb_t_next (struct rb_traverser *trav, union rb_key *kp, union rb_value *vp);

#endif /* rb.h */
