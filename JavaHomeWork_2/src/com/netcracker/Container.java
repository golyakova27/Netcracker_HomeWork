package com.netcracker;

public class Container {
    private int x1;
    private int y1;
    private int x2;
    private int y2;

    public Container(int x1, int y1, int width, int height) {
        if (width > 0 && height >0) {
            this.x1 = x1;
            this.y1 = y1;
            this.x2 = x1 + width;
            this.y2 = y1 + height;
        }
        else {
            System.out.println("The width and height must be > 0.");
        }
    }

    public int getX() {
        return this.x1;
    }

    public int getY() {
        return this.y1;
    }

    public int getWidth() {
        return this.x2 - this.x1;
    }

    public int getHeight() {
        return this.y2 - this.y1;
    }

    public boolean collides(Ball ball) {
        return  (this.x1 < ball.getX() - ball.getRadius() && this.y1 < ball.getY() - ball.getRadius()
                && this.x2 > ball.getX() + ball.getRadius() && this.y2 > ball.getY() + ball.getRadius());
    }

    @Override
    public String toString() {
        return "Container[(" + this.x1 + ", " + this.y1 + "), (" + this.x2 + ", " + this.y2 + ")]";
    }
}
