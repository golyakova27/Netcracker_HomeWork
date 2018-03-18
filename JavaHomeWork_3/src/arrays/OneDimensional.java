package arrays;

// Задачи на одномерные массивы

public class OneDimensional {

    //Создать массив нечётных чисел от 1 до 99 и вывести их в порядке возрастания и убывания
    private static void oddArray() {

        int[] odd = new int[50];

        for (int i = 1, j = 0; i <= 99; i++) {

            if ((i % 2) != 0) {

                odd[j] = i;
                System.out.print(odd[j] + " ");
                j++;
            }
        }

        System.out.println();

        for (int i = 99, j = 0; i >= 1; i--) {

            if ((i % 2) != 0) {

                odd[j] = i;
                System.out.print(odd[j] + " ");
                j++;
            }
        }

        System.out.println();
    }

    // Создать массив из 20 случайных чисел лежащих в отрезке [0;10]. Вывести массив на экран. Подсчитать и вывести на экран количество чётных и нечётных элементов в массиве.
    private static void brandomArray() {

        int[] arr = new int[20];
        int odd_count = 0;
        int even_count = 0;

        for (int i = 0; i < arr.length; i++) {

            arr[i] = (int)(Math.random() * 11);
            System.out.print(arr[i] + " ");

            if ((arr[i] % 2) == 0) {

                even_count++;
            }
            else {

                odd_count++;
            }

        }

        System.out.println("\n Количество чётных элементов массива = " + even_count +
                            "\n Количество нечётных элементов массива = " + odd_count);
    }

    // Создайте массив из 10 случайных целых чисел на  отрезке [1;100]. Выведите массив на экран в строку. Замените каждый элемент с нечётным индексом на ноль. Выведите новый результат на экран.
    private static void crandomArray() {

        int[] arr = new int[10];

        for (int i = 0; i < arr.length; i++) {

            arr[i] = (int)(Math.random() * 100) + 1;
            System.out.print(arr[i] + " ");
        }

        System.out.println();

        for (int i = 0; i < arr.length; i++) {

            if ((i % 2) != 0) {

                arr[i] = 0;
            }

            System.out.print(arr[i] + " ");
        }

        System.out.println();
    }

    // Создайте массив из 15 случайных целых чисел из отрезка [-50;50]. Найдите максимальный и минимальный элемент массива. Выведите их значения на экран и также индекс последнего вхождения элемента в массив.
    private static void drandomArray() {

        int[] arr = new int[15];
        int max = Integer.MIN_VALUE;
        int max_index = 0;
        int min = Integer.MAX_VALUE;
        int min_index = 0;

        for (int i = 0; i < arr.length; i++) {

            arr[i] = (int)(Math.random() * 101)- 50;
            System.out.print(arr[i] + " ");

            if (arr[i] >= max) {

                max = arr[i];
                max_index = i;
            }

            if (arr[i] <= min) {

                min = arr[i];
                min_index = i;
            }
        }

        System.out.println("\n Минимальный элемент массива = " + min + " Индекс последнего вхождения = " + min_index +
                            "\n Максимальный элемент массива = " + max + " Индекс последнего вхождения = " + max_index);
    }

    // Создайте два  массива из 10 случайных целых чисел в отрезке [0;10]. выведите массивы. Вычислите среднее арифметическое элементов каждого массива и сообщите, для какого из массивов это значение оказалось больше (либо сообщите, что они равны).
    private static void erandomArrays() {

        int[] arr1 = new int[10];
        double mean1 = 0;

        for (int i = 0; i < arr1.length; i++) {

            arr1[i] = (int)(Math.random() * 11);
            mean1 += arr1[i];
            System.out.print(arr1[i] + " ");
        }

        mean1 /= arr1.length;
        System.out.println("\n Среднее арифметическое = " + mean1);

        int[] arr2 = new int[10];
        double mean2 = 0;

        for (int i = 0; i < arr2.length; i++) {

            arr2[i] = (int)(Math.random() * 11);
            mean2 += arr2[i];
            System.out.print(arr2[i] + " ");
        }

        mean2 /= arr2.length;
        System.out.println("\n Среднее арифметическое = " + mean2);

        if (mean1 > mean2) {

            System.out.println("Среднее арифметическое 1-го масиива больше");
        }

        if (mean1 == mean2) {

            System.out.println("Значения среднего арифметического 1-го и 2-го массива равны");
        }

        if (mean1 < mean2) {

            System.out.println("Среднее арифметическое 2-го масиива больше");
        }
    }

    // Создайте массив из 20 случайных целых чисел в отрезке [-1;1] Определите какой элемент встречается в массиве чаще всего и выведите его на экран. Также если несколько элементов встречаются одинаковое количество раз, необходимо их вывести на экран.
    private static void frandomArray() {

        int[] arr = new int[20];
        int[] frequency = {0, 0, 0, 0};

        for (int i = 0; i < arr.length; i++) {

            arr[i] = (int)(Math.random() * 3) - 1;
            System.out.print(arr[i] + " ");

            switch (arr[i]) {
                case -1:
                {
                    frequency[0]++;
                    if (frequency[0] > frequency[3]) {
                        frequency[3] = frequency[0];
                    }
                }

                break;

                case 0:
                {
                    frequency[1]++;
                    if (frequency[1] > frequency[3]) {
                        frequency[3] = frequency[1];
                    }
                }

                break;

                case 1:
                {
                    frequency[2]++;
                    if (frequency[2] > frequency[3]) {
                        frequency[3] = frequency[2];
                    }
                }

                break;
            }

        }

        for (int j = 0; j < frequency.length - 1; j++) {

            if (frequency[j] == frequency[3]) {
                System.out.println("\n Чаще всего встречается элемент со значением " + (j - 1) + " (" + frequency[3] + " раз)");
            }
        }
    }

    public static void main(String[] args) {


        oddArray();

        brandomArray();

        crandomArray();

        drandomArray();

        erandomArrays();

        frandomArray();
    }
}
