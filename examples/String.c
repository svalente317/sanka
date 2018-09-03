struct String {
    struct array data;
};

void String__init(struct String *this, struct array data) {
    this->data = data;
}

char String__charAt(struct String *this, int idx) {
    BOUNDCHECK(this->data, idx);
    // Do not NULLCHECK(this);
    char tmp1 = this->data.data[idx];
    return tmp1;
}

int String__length(struct String *this) {
    return this->data.length;
}

int String__compareTo(struct String *this, struct String *that) {
    int idx = 0;
    while (1) {
        // Do not "if (!true) break;"
        int tmp1 = (idx == this->data.length);
        if (tmp1) {
            NULLCHECK(that);
            tmp1 = (idx == that->data.length);
        }
        if (tmp1) {
            break;
        }
        // ... rest of function ...
        // add copy of incrementor with each "continue"?
        idx++;
    }
    return 0;
}

}

            
