package test;

import java.util.*;

public class TestJavaCollections {

    public static void main(String[] args) {

        /*
         *       Сравнение ArrayList и LinkedList (добавление, вставка, удаление)
         */


        System.out.println("ArrayList vs LinkedList:");

        // добавление
        ArrayList<Integer> intArray = new ArrayList<>();

        long startTimeAddArray = System.nanoTime();
        for (int i = 0; i < 100000; i++) {
            intArray.add((int) (Math.random() * 100));
        }
        long timeAddArray = System.nanoTime() - startTimeAddArray;


        LinkedList<Integer> intLinked = new LinkedList<>();

        long startTimeAddLinked = System.nanoTime();
        for (int i = 0; i < 100000; i++) {
            intLinked.add((int) (Math.random() * 100));
        }
        long timeAddLinked = System.nanoTime() - startTimeAddLinked;

        System.out.println("1) добавление");
        System.out.println(timeAddArray + " - AL");
        System.out.println(timeAddLinked + " - LL");

        // вставка
        long startTimeInArray = System.nanoTime();
        intArray.set(50004, 56);
        long timeInArray = System.nanoTime() - startTimeInArray;

        long startTimeInLinked = System.nanoTime();
        intLinked.set(50004, 56);
        long timeInLinked = System.nanoTime() - startTimeInLinked;

        System.out.println("2) вставка");
        System.out.println(timeInArray + " - AL");
        System.out.println(timeInLinked + " - LL");

        // удаление

        long startTimeReArray = System.nanoTime();
        intArray.remove(10000);
        long timeReArray = System.nanoTime() - startTimeReArray;

        long startTimeReLinked = System.nanoTime();
        intLinked.remove(10000);
        long timeReLinked = System.nanoTime() - startTimeReLinked;

        System.out.println("3) удаление");
        System.out.println(timeReArray + " - AL");
        System.out.println(timeReLinked + " - LL");

        // очистка

        long startTimeClArray = System.nanoTime();
        intArray.clear();
        long timeClArray = System.nanoTime() - startTimeClArray;

        long startTimeClLinked = System.nanoTime();
        intLinked.clear();
        long timeClLinked = System.nanoTime() - startTimeClLinked;

        System.out.println("4) очистка");
        System.out.println(timeClArray + " - AL");
        System.out.println(timeClLinked + " - LL");


        /*
         *       HashSet, LinkedHashSet и TreeSet
         */

        HashSet<Integer> intHashSet = new HashSet<>();

        LinkedHashSet<Integer> intLinkedHashSet = new LinkedHashSet<>();

        TreeSet<Integer> intTreeSet = new TreeSet<>();

        System.out.println("\n\nHashSet vs LinkedHashSet vs TreeSet");


        // добавление
        long startTimeAddH = System.nanoTime();
        for (int i = 0; i < 100000; i++) {
            intHashSet.add((int) (Math.random() * 100));
        }
        long timeAddH = System.nanoTime() - startTimeAddH;

        long startTimeAddL = System.nanoTime();
        for (int i = 0; i < 100000; i++) {
            intLinkedHashSet.add((int) (Math.random() * 100));
        }
        long timeAddL = System.nanoTime() - startTimeAddL;

        long startTimeAddT = System.nanoTime();
        for (int i = 0; i < 100000; i++) {
            intTreeSet.add((int) (Math.random() * 100));
        }
        long timeAddT = System.nanoTime() - startTimeAddT;

        System.out.println("1) добавление");
        System.out.println(timeAddH + " - HS");
        System.out.println(timeAddL + " - LHS");
        System.out.println(timeAddT + " - TS");


        // удаление
        long startTimeReH = System.nanoTime();
        intHashSet.remove(45);
        long timeReH = System.nanoTime() - startTimeReH;

        long startTimeReL = System.nanoTime();
        intLinkedHashSet.remove(45);
        long timeReL = System.nanoTime() - startTimeReL;

        long startTimeReT = System.nanoTime();
        intTreeSet.remove(45);
        long timeReT = System.nanoTime() - startTimeReT;

        System.out.println("2) удаление");
        System.out.println(timeReH + " - HS");
        System.out.println(timeReL + " - LHS");
        System.out.println(timeReT + " - TS");

        // очистка
        long startTimeClH = System.nanoTime();
        intHashSet.clear();
        long timeClH = System.nanoTime() - startTimeClH;

        long startTimeClL = System.nanoTime();
        intLinkedHashSet.clear();
        long timeClL = System.nanoTime() - startTimeClL;

        long startTimeClT = System.nanoTime();
        intTreeSet.clear();
        long timeClT = System.nanoTime() - startTimeClT;

        System.out.println("3) очистка");
        System.out.println(timeClH + " - HS");
        System.out.println(timeClL + " - LHS");
        System.out.println(timeClT + " - TS");


        /*
         *       HashMap, LinkedHashMap, TreeMap
         */


        HashMap<Integer, String> hashMap = new HashMap<>();

        LinkedHashMap<Integer, String> linkedHashMap = new LinkedHashMap<>();

        TreeMap<Integer, String> treeMap = new TreeMap<>();


        System.out.println("\n\nHashMap vs LinkedHashMap vs TreeMap");

        // добавление
        long startTimeAddHM = System.nanoTime();
        for (int i = 0; i < 100000; i++) {

            String str = "";

            for (int j = 0; j < 5; j++)
            {
                str += (int) (Math.random() * 25 + 97);
            }

            hashMap.put((int) (Math.random() * 100), str);
        }
        long timeAddHM = System.nanoTime() - startTimeAddHM;


        long startTimeAddLHM = System.nanoTime();
        for (int i = 0; i < 100000; i++) {

            String str = "";

            for (int j = 0; j < 5; j++)
            {
                str += (int) (Math.random() * 25 + 97);
            }

            linkedHashMap.put((int) (Math.random() * 100), str);
        }
        long timeAddLHM = System.nanoTime() - startTimeAddLHM;


        long startTimeAddTM = System.nanoTime();
        for (int i = 0; i < 100000; i++) {

            String str = "";

            for (int j = 0; j < 5; j++)
            {
                str += (int) (Math.random() * 25 + 97);
            }

            treeMap.put((int) (Math.random() * 100), str);
        }
        long timeAddTM = System.nanoTime() - startTimeAddTM;

        System.out.println("1) добавление");
        System.out.println(timeAddHM + " - HM");
        System.out.println(timeAddLHM + " - LHM");
        System.out.println(timeAddTM + " - TM");

        // удаление
        long startTimeReHM = System.nanoTime();
        hashMap.remove(56);
        long timeReHM = System.nanoTime() - startTimeReHM;

        long startTimeReLHM = System.nanoTime();
        linkedHashMap.remove(56);
        long timeReLHM = System.nanoTime() - startTimeReLHM;

        long startTimeReTM = System.nanoTime();
        treeMap.remove(56);
        long timeReTM = System.nanoTime() - startTimeReTM;

        System.out.println("2) удаление");
        System.out.println(timeReHM + " - HM");
        System.out.println(timeReLHM + " - LHM");
        System.out.println(timeReTM + " - TM");

        // очистка
        long startTimeClHM = System.nanoTime();
        hashMap.clear();
        long timeClHM = System.nanoTime() - startTimeClHM;

        long startTimeClLHM = System.nanoTime();
        linkedHashMap.clear();
        long timeClLHM = System.nanoTime() - startTimeClLHM;

        long startTimeClTM = System.nanoTime();
        treeMap.clear();
        long timeClTM = System.nanoTime() - startTimeClTM;

        System.out.println("3) очистка");
        System.out.println(timeClHM + " - HM");
        System.out.println(timeClLHM + " - LHM");
        System.out.println(timeClTM + " - TM");
    }
}
