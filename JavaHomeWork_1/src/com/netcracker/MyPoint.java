package com.netcracker;

public class MyPoint {
    private int x = 0;
    private int y = 0;

    public MyPoint() {}

    public MyPoint(int _x, int _y) {
        this.x = _x;
        this.y = _y;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public void setX(int _x) {
        this.x = _x;
    }

    public void setY(int _y) {
        this.y = _y;
    }

    public int[] getXY() {
        int[] arr = new int[2];
        arr[0] = this.getX();
        arr[1] = this.getY();
        return arr;
    }

    public void setXY(int _x, int _y) {
        this.setX(_x);
        this.setY(_y);
    }

    @Override
    public int hashCode() {
        int result = 15;
        result = 31 * result + x;
        result = 31 * result + y;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof MyPoint)) {
            return false;
        }

        MyPoint point = (MyPoint) obj;
        return point.x == this.x && point.y == this.y;
    }

    @Override
    public String toString() {
        return "(" + this.getX() + ", " + this.getY() + ")";
    }

    public double distance(int _x, int _y) {
        return Math.sqrt(Math.pow((this.getX() - _x), 2.0) + Math.pow((this.getY() - _y), 2.0));
    }

    public double distance(MyPoint point) {
        return this.distance(point.getX(), point.getY());
    }

    public double distance () {
        return this.distance(0, 0);
    }
}
