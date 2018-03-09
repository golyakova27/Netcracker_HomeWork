package com.netcracker;

public class Main {
    public static void main(String[] args) {
        //MyComplex test

        MyComplex com1 = new MyComplex();
        MyComplex com2 = new MyComplex(2, 4);
        MyComplex com3 = new MyComplex(0,-1);

        System.out.println(com3.isReal());
        System.out.println(com2.isReal());
        System.out.println(com2);
        System.out.println(com1);
        System.out.println(com2.addNew(com3));
        com2.subtract(com3);
        System.out.println(com2);
        com2.multiply(com3);
        System.out.println(com2);
        com2.divide(com1);
        com3.divide(com2);
        System.out.println(com3);
        com2.conjugate();
        System.out.println(com3);


        //MyPolynomial test

        double[] arr1 = {5, 4, 3};
        double[] arr2 = {-6, 0, 1, 2};

        MyPolynomial pol1 = new MyPolynomial(arr1);
        MyPolynomial pol2 = new MyPolynomial(arr2);

        System.out.println(pol1.add(pol2));
        System.out.println(pol1.multiply(pol2));

      // Ball and Container test

        Ball ball = new Ball(3, 6, 2, 5, 40);
        ball.setX(4);

        System.out.println(ball);

        ball.move();

        System.out.println(ball);

        Container container1 = new Container(-7, 0, 20,40);
        Container container2 = new Container(4, 6, 10, 15);
        System.out.println(container1);
        System.out.println(container1.collides(ball));
        System.out.println(container2);
        System.out.println(container2.collides(ball));
    }
}
