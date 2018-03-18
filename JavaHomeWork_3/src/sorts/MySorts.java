package sorts;

public class MySorts {

    // метод сортировки пузырьком
    public static void bubble (int[] arr) {

        for (int i = 0; i < arr.length - 1; i++) {

            for (int j = 0; j < arr.length - 1; j++) {

                if (arr[j] > arr[j + 1]) {

                    int safe = 0;
                    safe = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = safe;
                }
            }
        }
    }

    // метод сортировки выбором
    public static void selection (int[] arr) {

        for (int i = 0; i < arr.length - 1; i++) {

            int min_index = i;

            for (int j = min_index + 1; j < arr.length; j++) {

                if (arr[j] < arr[min_index]) {

                    min_index = j;
                }
            }

            int safe = arr[i];
            arr[i] = arr[min_index];
            arr[min_index] = safe;
        }
    }

    // метод оценивающий лучшее время
    public static void resultTime (long[] arr, String[] arrS, int size) {

        if (arr.length == arrS.length) {

            for (int i = 0; i < arr.length - 1; i++) {

                int min_index = i;

                for (int j = min_index + 1; j < arr.length; j++) {

                    if (arr[j] < arr[min_index]) {

                        min_index = j;
                    }
                }


                long safe = arr[i];
                arr[i] = arr[min_index];
                arr[min_index] = safe;

                String safeS = arrS[i];
                arrS[i] = arrS[min_index];
                arrS[min_index] = safeS;
            }

            System.out.println("The results for array with " + size + " elements:");
            for (int i = 0; i < arr.length; i++) {

                System.out.println((i + 1) + ") " + arrS[i] + " - " + arr[i] + "ns");
            }
        }
    }
}
