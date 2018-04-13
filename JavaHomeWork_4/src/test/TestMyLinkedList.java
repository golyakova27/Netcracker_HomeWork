package test;

import linkedList.MyLinkedList;

public class TestMyLinkedList {

    public static void main(String[] args) {

        /*
         *       Тестирование методов класса MyLinkedList
         */

        MyLinkedList<Integer> intList = new MyLinkedList<>();

        MyLinkedList<String> stringList = new MyLinkedList<>();

        // add()
        stringList.add("Alyona");
        stringList.add("Julia");
        stringList.add("Anton");
        stringList.add("Sonya");

        // remove()
        stringList.remove(3);

        // toString()
        System.out.println(stringList);

        // get()
        System.out.println(stringList.get(0));
        System.out.println(stringList.get(1));
        System.out.println(stringList.get(2));

        // size()
        System.out.println(stringList.size());

        // indexOf()
        System.out.println(stringList.indexOf("Alyona"));

        // clear()
        stringList.clear();

        System.out.println(stringList);

        // add()
        intList.add(32);
        intList.add(33);
        intList.add(34);
        intList.add(35);
        intList.add(36);

        // toArray()
        Object[] array;

        array = intList.toArray();

        for (Object i : array) {

            System.out.print(i + " ");
        }

        System.out.println("\n" + intList);
    }
}
