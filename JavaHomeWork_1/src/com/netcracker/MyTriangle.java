package com.netcracker;

public class MyTriangle {
    private MyPoint v1;
    private MyPoint v2;
    private MyPoint v3;

    public MyTriangle(int x1, int y1, int x2, int y2, int x3, int y3) {
        MyPoint _v1 = new MyPoint(x1, y1);
        MyPoint _v2 = new MyPoint(x2, y2);
        MyPoint _v3 = new MyPoint(x3, y3);

        if (_v1.distance(_v2) < _v2.distance(_v3) + _v3.distance(_v1) &&
                _v2.distance(_v3) < _v1.distance(_v2) + _v3.distance(_v1) &&
                _v3.distance(_v1) < _v1.distance(_v2) + _v2.distance(_v3)) {
            this.v1 = _v1;
            this.v2 = _v2;
            this.v3 = _v3;
        }
        else {
            System.out.println("It is impossible to construct a triangle at given points.");
        }
    }

    public MyTriangle(MyPoint _v1, MyPoint _v2, MyPoint _v3) {
        if (_v1.distance(_v2) < _v2.distance(_v3) + _v3.distance(_v1) &&
                _v2.distance(_v3) < _v1.distance(_v2) + _v3.distance(_v1) &&
                _v3.distance(_v1) < _v1.distance(_v2) + _v2.distance(_v3)) {
            this.v1 = _v1;
            this.v2 = _v2;
            this.v3 = _v3;
        }
        else {
            System.out.println("It is impossible to construct a triangle at given points.");
        }
    }

    @Override
    public String toString() {
        return "MyTriangle[v1 = " + this.v1.toString() + ", v2 = " + this.v2.toString() + ", v3 = " + this.v3.toString() + "]";
    }

    public double getPerimetr() {
        return v1.distance(v2) + v2.distance(v3) + v3.distance(v1);
    }

    public String getType() {
        double edge1 = this.v1.distance(this.v2);
        double edge2 = this.v2.distance(this.v3);
        double edge3 = this.v3.distance(this.v1);

        if (edge1 == edge2 || edge2 == edge3 || edge3 == edge1){
            if (edge1 == edge2 && edge2 == edge3) {
                return "Triangle is equilateral.";
            }
            else {
                return "Triangle is isosceles.";
            }
        }
        else {
            return "Triangle is scalene.";
        }
    }
}
