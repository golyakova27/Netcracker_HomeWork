package com.netcracker;

public class Main {
    public static void main(String[] args) {
        // circle test

//        Circle mycircle1 = new Circle(-1, "black");
//        Circle mycircle2 = new Circle(5, "yellow");
//        Circle mycircle3 = new Circle();
//        Circle mycircle4 = new Circle(7);
//
//        System.out.println(mycircle1.toString());
//        System.out.println(mycircle2.toString());
//        System.out.println(mycircle3.toString());
//        System.out.println(mycircle4.toString());
//
//        mycircle2.setRadius(-4);
//
//        System.out.println(mycircle1.getArea());
//        System.out.println(mycircle2.getArea());
//        System.out.println(mycircle3.getArea());
//        System.out.println(mycircle4.getArea());
//
//        System.out.println(mycircle1.toString());
//        System.out.println(mycircle2.toString());
//        System.out.println(mycircle3.toString());
//        System.out.println(mycircle4.toString());

        //rectangle test

//        Rectangle myrec1 = new Rectangle();
//        Rectangle myrec2 = new Rectangle(-3, 8);
//
//        System.out.println(myrec1.toString());
//        System.out.println(myrec2.toString());
//
//        myrec1.setLength(-2);
//        myrec1.setWidth(4);
//        myrec2.setLength(6);
//
//        System.out.println(myrec1.getPerimeter());
//        System.out.println(myrec2.getPerimeter());
//
//        System.out.println(myrec1.getArea());
//        System.out.println(myrec2.getArea());
//
//        System.out.println(myrec1.toString());
//        System.out.println(myrec2.toString());

        //employee test

//        Employee employee1 = new Employee(1, "Alyona", "Golyakova", -15000);
//
//        System.out.println(employee1.toString());
//
//        System.out.println(employee1.raiseSalary(15));
//
//        System.out.println(employee1.getID());
//
//        System.out.println(employee1.getSalary());
//
//        System.out.println(employee1.getName());
//
//        employee1.setSalary(15000);
//
//        System.out.println(employee1.getAnnualSalary());
//
//        System.out.println(employee1.raiseSalary(10));
//
//        System.out.println(employee1.toString());

        //book test

//        Author[] authors1 = new Author[1];
//        Author[] authors2 = new Author[2];
//
//        authors1[0] = new Author("Herbert Shield","Shield@mail.us",'m');
//        authors2[0] = new Author("Herbert Shield","Shield@mail.us",'m');
//        authors2[1] = new Author("Cay Horstmann","Horstmann@mail.us",'m');
//
//        System.out.println(authors1[0].toString());
//
//        Book book1 = new Book("Java", authors1, 200, 5);
//        Book book2 = new Book("Java learning", authors2, 230);
//
//        book1.setPrice(-300);
//
//        System.out.println(book1.getAuthorNames());
//        System.out.println(book2.getAuthorNames());
//
//        System.out.println(book1.toString());
//        System.out.println(book2.toString());

        //mytriangle test

        MyPoint v1 = new MyPoint(1, 2);
        MyPoint v2 = new MyPoint(4, 8);
        MyPoint v3 = new MyPoint(9, 7);

        MyTriangle t2 = new MyTriangle(v1, v2, v3);
        MyTriangle t1 = new MyTriangle(1, 2, 4, 8, 9, 7);

        System.out.println(t2.toString());
        System.out.println(t2.getType());
        System.out.println(t2.getPerimetr());
    }
}
