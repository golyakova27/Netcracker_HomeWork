package com.netcracker;

public class Circle {
    private double radius = 1.0;
    private String color = "red";

    public Circle() {
    }

    public Circle(double _radius) {
        if (_radius > 0) {
            this.radius = _radius;
        }
        else {
            System.out.println(_radius + " - incorrect data entry.");
        }
    }

    public Circle(double _radius, String _color) {
        if (_radius > 0) {
            this.radius = _radius;
        }
        else {
            System.out.println(_radius + " - incorrect data entry.");
        }
        this.color = _color;
    }

    public double getRadius() {
        return this.radius;
    }

    public String getColor() {
        return this.color;
    }

    public void setRadius(double _radius) {
        if (_radius > 0) {
            this.radius = _radius;
        }
        else {
            System.out.println(_radius + " - incorrect data entry.");
        }
    }

    public void setColor(String _color) {
        this.color = _color;
    }

    @Override
    public String toString() {
        return "Circle[radius = " + this.getRadius() + ", color = " + this.getColor() + "]";
    }

    public double getArea() {
        return Math.PI * Math.pow(this.getRadius(), 2.0);
    }
}
