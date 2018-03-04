package com.netcracker;

public class Rectangle {
    private float length = 1.0f;
    private float width = 1.0f;

    public Rectangle() {
    }

    public Rectangle(float _length, float _width) {
        if (_length > 0) {
            this.length = _length;
        }
        else {
            System.out.println(_length + " - incorrect data entry.");
        }

        if (_width > 0) {
            this.width = _width;
        }
        else {
            System.out.println(_width + " - incorrect data entry.");
        }
    }

    public float getLength() {
        return this.length;
    }

    public void setLength(float _length) {
        if (_length > 0) {
            this.length = _length;
        }
        else {
            System.out.println(_length + " - incorrect data entry.");
        }
    }

    public float getWidth() {
        return this.width;
    }

    public void setWidth(float _width) {
        if (_width > 0) {
            this.width = _width;
        }
        else {
            System.out.println(_width + " - incorrect data entry.");
        }
    }

    public double getArea() {
        return this.getLength() * this.getWidth();
    }

    public double getPerimeter() {
        return 2.0 * (this.getWidth() + this.getLength());
    }

    @Override
    public String toString() {
        return "Rectangle[length = " + this.getLength() + ", width = " + this.getWidth() + "]";
    }
}
