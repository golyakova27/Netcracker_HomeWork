package sorts;

import java.util.Arrays;

// Сортировка массивов методом пузырька, выбором и с помощью метода Arrays.sort

public class Main {

    private static void arrayFilling(int[] arr) {

        for (int i = 0; i < arr.length; i++) {

            arr[i] = (int)(Math.random() * 100);
        }
    }

    private static void arrayPrint(int[] arr) {

        for (int i: arr) {

            System.out.print(i + " ");
        }

        System.out.println();
    }

    public static void main(String[] args) {

        int n = 10000; // размер массива

        int[] arr1 = new int[n];
        int[] arr2 = new int[n];
        int[] arr3 = new int[n];

        arrayFilling(arr1);
        arrayFilling(arr2);
        arrayFilling(arr3);

        long startTimeBubble = System.nanoTime();
        MySorts.bubble(arr1);
        long estimatedTimeBubble = System.nanoTime() - startTimeBubble;

        long startTimeSelection = System.nanoTime();
        MySorts.selection(arr2);
        long estimatedTimeSelection = System.nanoTime() - startTimeSelection;

        long startTimeMath = System.nanoTime();
        Arrays.sort(arr3);
        long estimatedTimeMath = System.nanoTime() - startTimeMath;

        long[] timeResults = {estimatedTimeBubble, estimatedTimeSelection, estimatedTimeMath};
        String[] sortResults = {"Bubble sort", "Selection sort", "Standard math sort"};

        MySorts.resultTime(timeResults, sortResults, n);
    }
}
