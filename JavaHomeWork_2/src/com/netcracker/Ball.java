package com.netcracker;

public class Ball {
    private float x;
    private float y;
    private int radius;
    private float xDelta;
    private float yDelta;

    public Ball(float x, float y, int radius, int speed, int direction) {
        if (direction > -180 && direction < 180) {
            this.xDelta = (float)Math.cos(direction * (float)Math.PI / 180.f) * speed;
            this.yDelta = -1.0f * (float)Math.sin(direction * (float)Math.PI / 180.f) * speed;
        }
        else {
            System.out.println("The direction must be in [-180, 180].");
        }

        if (radius > 0) {
            this.radius = radius;
        }
        else {
            System.out.println("The radius must be > 0.");
        }
        this.x = x;
        this.y = y;

    }

    public float getX() {
        return this.x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return this.y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public int getRadius() {
        return this.radius;
    }

    public void setRadius(int radius) {
        if (radius > 0) {
            this.radius = radius;
        }
        else {
            System.out.println("The radius must be > 0.");
        }
    }

    public float getxDelta() {
        return this.xDelta;
    }

    public void setxDelta(float xDelta) {
        this.xDelta = xDelta;
    }

    public float getyDelta() {
        return this.yDelta;
    }

    public void setyDelta(float yDelta) {
        this.yDelta = yDelta;
    }

    public void move() {
        this.x += this.xDelta;
        this.y += this.yDelta;
    }

    public void reflectHorizontal() {
        this.xDelta = 0 - this.xDelta;
    }

    public void reflectVertical() {
        this.yDelta = 0 - this.yDelta;
    }

    @Override
    public String toString() {
        return "Ball[(" + this.x + ", " + this.y + "), speed = (" + this.xDelta + ", " + this.yDelta + ")]";
    }
}
