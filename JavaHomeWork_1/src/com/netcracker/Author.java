package com.netcracker;

import javax.management.openmbean.ArrayType;

public class Author {
    private String name;
    private String email;
    private char gender;

    public Author() {}

    public Author(String _name, String _email, char _gender) {
        this.name = _name;
        this.email = _email;
        this.gender = _gender;
    }

    public String getName() {
        return this.name;
    }

    public String getEmail() {
        return this.email;
    }

    public char getGender() {
        return this.gender;
    }

    @Override
    public String toString() {
        return "Author[name = " + this.getName() + ", email = " + this.getEmail() + ", gender = " + this.getGender() + "]";
    }
}
