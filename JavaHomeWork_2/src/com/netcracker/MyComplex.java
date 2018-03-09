package com.netcracker;

public class MyComplex {
    private double re = 0.0;
    private double im = 0.0;

    public MyComplex() {}

    public MyComplex(double re, double im) {
        this.re = re;
        this.im = im;
    }

    public double getRe() {
        return this.re;
    }

    public void setRe(double re) {
        this.re = re;
    }

    public double getIm() {
        return this.im;
    }

    public void setIm(double im) {
        this.im = im;
    }

    public void setValue(double re, double im) {
        this.setRe(re);
        this.setIm(im);
    }

    @Override
    public String toString() {
        return "(" + this.getRe() + " + " + this.getIm() + "i)";
    }

    public boolean isReal() {
        return this.re != 0.0;
    }

    public boolean isImaginary() {
        return this.im != 0.0;
    }

    @Override
    public int hashCode() {
        int result = 15;
        result = 31 * result + (int) this.getRe();
        result = 31 * result + (int) this.getIm();
        return result;
    }

    public boolean equals(double re, double im) {
        return this.re == re && this.im == im;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof MyComplex)) {
            return false;
        }

        MyComplex mycomplex = (MyComplex) obj;
        return this.equals(mycomplex.getRe(), mycomplex.getIm());
    }

    public double magnitude() {
        return Math.sqrt(Math.pow(this.getRe(), 2.0) + Math.pow(this.getIm(), 2.0));
    }

    public double argument() {
        return Math.acos(this.getRe() / this.magnitude());
    }

    public MyComplex add(MyComplex obj) {
        this.setValue(this.getRe() + obj.getRe(), this.getIm() + obj.getIm());

        return this;
    }

    public MyComplex addNew(MyComplex obj) {
        return new MyComplex(this.getRe() + obj.getRe(), this.getIm() + obj.getIm());

    }

    public MyComplex subtract(MyComplex obj) {
        this.setValue(this.getRe() - obj.getRe(), this.getIm() - obj.getIm());

        return this;
    }

    public MyComplex subtractNew(MyComplex obj) {
        return new MyComplex(this.getRe() - obj.getRe(), this.getIm() - obj.getIm());
    }

    public MyComplex multiply (MyComplex obj) {
        this.setValue(this.getRe() * obj.getRe() - this.getIm() * obj.getIm(),
                this.getIm() * obj.getRe() + this.getRe() * obj.getIm());

        return this;
    }

    public MyComplex divide(MyComplex obj) {
        if (!(obj.getRe() == 0.0 && obj.getIm() == 0.0)) {
            this.setValue((this.getRe() * obj.getRe() + this.getIm() * obj.getIm()) / (Math.pow(obj.getRe(), 2.0) + Math.pow(obj.getIm(), 2.0)),
                    (this.getRe() * obj.getIm() - this.getIm() * obj.getRe()) / (Math.pow(obj.getRe(), 2.0) + Math.pow(obj.getIm(), 2.0)));
        }
        else {
            System.out.println("Division by zero.");
        }
        return this;
    }

    public MyComplex conjugate() {
        this.setIm(0 - this.getIm());

        return this;
    }
}
