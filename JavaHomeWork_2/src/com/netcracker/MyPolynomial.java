package com.netcracker;

public class MyPolynomial {
    private double coeffs[];

    public MyPolynomial(double[] coeffs) {
        this.coeffs = coeffs.clone();
    }

    public int getDegree() {
        return this.coeffs.length - 1;
    }

    @Override
    public String toString() {
        String result = "";
        for (int i = this.coeffs.length - 1; i > 1; i--) {
            result += this.coeffs[i] + "x^" + i + " + ";
        }
        result = result + this.coeffs[1] + "x + " + this.coeffs[0];

        return result;
    }

    public double evaluate(double x) {
        double result = this.coeffs[0];
        for (int i = 1; i < this.coeffs.length; i++) {
            result += this.coeffs[i] * Math.pow(x, i);
        }

        return result;
    }

    public MyPolynomial add(MyPolynomial obj) {
        MyPolynomial result;
        if (this.coeffs.length > obj.coeffs.length) {
            result = new MyPolynomial(this.coeffs);

            for (int i = 0; i < obj.coeffs.length; i++) {
                result.coeffs[i] += obj.coeffs[i];
            }
        }
        else {
            result = new MyPolynomial(obj.coeffs);

            for (int i = 0; i < this.coeffs.length; i++) {
                result.coeffs[i] += this.coeffs[i];
            }
        }

        return result;
    }

    public MyPolynomial multiply(MyPolynomial obj) {
        int size = this.getDegree() + obj.getDegree() + 1;
        double[] arr = new double[size];
        MyPolynomial result = new MyPolynomial(arr);

        for (int i = 0; i < this.coeffs.length; i++) {
            for (int j = 0; j < obj.coeffs.length; j++) {
                result.coeffs[i + j] += this.coeffs[i] * obj.coeffs[j];
            }
        }

        return result;
    }
}
