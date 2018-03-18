package arrays;

// Задачи на многомерные массивы

public class TwoDimensional {

    // Создать двумерный массив размером 8 на 8. Заполнить его случайными числами в диапазоне [1;99] Вычислить и вывести на экран сумму и произведение элементов главной и побочной диагонали
    private static void aArray() {

        int[][] arr = new int[8][8];
        int sum_main = 0;
        long mult_main = 1;
        int sum_col = 0;
        long mult_col = 1;

        for (int i = 0; i < 8; i++ ) {

            for (int j = 0; j < 8; j++) {

                arr[i][j] = (int)(Math.random() * 99) + 1;

                if (i == j) {

                    sum_main += arr[i][j];
                    mult_main *= arr[i][j];
                }

                if ((i + j) == (8 - 1)) {

                    sum_col += arr[i][j];
                    mult_col *= arr[i][j];
                }

                if (arr[i][j] < 10) {

                    System.out.print(arr[i][j] + "  ");
                }
                else {

                    System.out.print(arr[i][j] + " ");
                }
            }

            System.out.println();
        }

        System.out.println("Сумма элементов главной диагонали: " + sum_main);
        System.out.println("Сумма элементов побочной диагонали: " + sum_col);
        System.out.println("Произведение элементов главной диагонали: " + mult_main);
        System.out.println("Произведение элементов побочной диагонали: " + mult_col);
    }

    // Создать двумерный массив из 8 строк и 5 столбцов. Заполнить его случайными числами в отрезке [-99;99]. Вывести массив на экран.  Вывести на экран значение и индексы максимального (по всем строкам и столбцам) элемента в массиве.
    private static void bArray() {

        int[][] arr = new int[8][5];

        for (int i = 0; i < 8; i++) {

            for (int j = 0; j < 5; j++) {

                arr[i][j] = (int)(Math.random() * 199) - 99;

                if (arr[i][j] < 10) {

                    if (arr[i][j] >= 0) {

                        System.out.print(" " + arr[i][j] + "  ");
                    }
                    else if (arr[i][j] > -10){
                        System.out.print(arr[i][j] + "  ");
                    }
                    else {
                        System.out.print(arr[i][j] + " ");
                    }
                }
                else {

                    System.out.print(" " + arr[i][j] + " ");
                }
            }

            System.out.println();
        }

        // поиск максимального элемента в строке

        for (int i = 0; i < 8; i++) {

            int max_elem = Integer.MIN_VALUE;
            int index_elem = 0;

            for (int j = 0; j < 5; j++) {

                if (arr[i][j] > max_elem) {

                    max_elem = arr[i][j];
                    index_elem = j;
                }
            }

            System.out.println("Максимальный элемент в " + (i + 1) + " строке: " + max_elem + " на " + (index_elem + 1) + " позиции");
        }

        System.out.println();

        // поиск максимального элемента в столбце

        for (int j = 0; j < 5; j++) {

            int max_elem = Integer.MIN_VALUE;
            int index_elem = 0;

            for (int i = 0; i < 8; i++) {

                if (arr[i][j] > max_elem) {

                    max_elem = arr[i][j];
                    index_elem = i;
                }
            }

            System.out.println("Максимальный элемент в " + (j + 1) + " столбце: " + max_elem + " на " + (index_elem + 1) + " позиции");
        }
    }

    // Cоздать двумерный массив из 8 строк и 5 столбцов из случайных целых чисел в отрезке [-10;10]. Вывести массив на экран. Определить и вывести  на экран индекс строки с наибольшим по модулю произведением элементов.
    private static void cArray() {

        int[][] arr = new int[8][5];

        for (int i = 0; i < 8; i++) {

            for (int j = 0; j < 5; j++) {

                arr[i][j] = (int)(Math.random() * 21) - 10;

                if (arr[i][j] < 10) {

                    if (arr[i][j] >= 0) {

                        System.out.print(" " + arr[i][j] + "  ");
                    }
                    else if (arr[i][j] > -10){
                        System.out.print(arr[i][j] + "  ");
                    }
                    else {
                        System.out.print(arr[i][j] + " ");
                    }
                }
                else {

                    System.out.print(" " + arr[i][j] + " ");
                }
            }

            System.out.println();
        }

        int index = 0;
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < 8; i++) {

            int mult = 1;

            for (int j = 0; j < 5; j++) {

                mult *= arr[i][j];
            }

            if (max < Math.abs(mult)) {

                max = Math.abs(mult);
                index = i;
            }
        }

        System.out.println((index + 1) + " строка имеет наибольшее по модулю произведение элементов");
    }


    // Создать двумерный массив из 10 строк и 7 столбцов из целых чисел в отрезке [0;100]. Вывести массив на экран. Отсортировать каждую строку в порядке убывания. Вывести преобразованный массив на экран.
    private static void dArray() {

        int[][] arr = new int[10][7];

        for (int i = 0; i < 10; i++) {

            for (int j = 0; j < 7; j++) {

                arr[i][j] = (int)(Math.random() * 101);

            }

        }

        printDArray(arr);

        System.out.println("Отсортированный массив:");

        sortDArray(arr, 10, 7);
    }

    // метод сортировки пузырьком для сортировки строк двумерного массива
    private static void sortDArray(int[][] arr, int m, int n) {

        for (int k = 0; k < m; k++) {

            for (int i = 0; i < n - 1; i++) {

                for (int j = 0; j < n - 1; j++) {

                    if (arr[k][j] < arr[k][j + 1]) {

                        int safe = 0;
                        safe = arr[k][j];
                        arr[k][j] = arr[k][j + 1];
                        arr[k][j + 1] = safe;
                    }
                }
            }
        }

        printDArray(arr);
    }

    // метод реализующий ровненький вывод двумерного массива для dArray
    private static void printDArray(int[][] arr) {

        for (int i = 0; i < 10; i++) {

            for (int j = 0; j < 7; j++) {

                if (arr[i][j] < 10) {

                    System.out.print(" " + arr[i][j] + "  ");
                }
                else if (arr[i][j] < 100) {

                    System.out.print(arr[i][j] + "  ");
                }
                else {

                    System.out.print(arr[i][j] + " ");
                }
            }

            System.out.println();
        }

        System.out.println();
    }

    public static void main(String[] args) {
        aArray();
        bArray();
        cArray();
        dArray();
    }
}
