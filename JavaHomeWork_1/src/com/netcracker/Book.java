package com.netcracker;

public class Book {
    private String name;
    private Author[] authors;
    private double price;
    private int qty = 0;

    public Book(String _name, Author[] _authors, double _price) {
        if (_price >= 0) {
            this.price = _price;
        }
        else {
            System.out.println("Incorrect data entry.");
        }
        this.name = _name;
        this.authors = _authors;
    }

    public Book(String _name, Author[] _authors, double _price, int _qty) {
        this.name = _name;
        this.authors = _authors;
        this.price = _price;
        this.qty = _qty;
    }

    public String getName() {
        return this.name;
    }

    public double getPrice() {
        return this.price;
    }

    public int getQty() {
        return this.qty;
    }

    public Author[] getAuthors() {
        return this.authors;
    }

    public void setPrice(double _price) {
        if (_price >= 0) {
            this.price = price;
        }
        else {
            System.out.println("Incorrect data entry.");
        }
    }

    public void setQty(int _qty) {
        this.qty = _qty;
    }

    @Override
    public String toString() {
        String conclusion = null;
        conclusion = "Book[name = " + this.getName() + ", authors = {";

        for (int i = 0; i < this.authors.length - 1; i++) {
            conclusion += this.authors[i].toString() + ", ";
        }

        conclusion = conclusion + this.authors[this.authors.length - 1].toString() + "}, price = " + this.getPrice() + ", qty = " + this.getQty() + "]";
        return conclusion;
    }

    public String getAuthorNames() {
        String conclusion = "";

        for (int i = 0; i < this.authors.length - 1; i++) {
            conclusion += this.authors[i].getName() + ", ";
        }

        conclusion = conclusion + this.authors[this.authors.length - 1].getName();
        return conclusion;
    }
}
