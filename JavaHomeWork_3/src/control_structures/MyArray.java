package control_structures;

// Аналогичные измерения необходимо проделать для массива, состоящего из 50 элементов, заполненного целыми числами в диапазоне [0;10] Т.е. для каждого из возможного значений сделать свою отдельную ветку. Также необходимо подсчитать сколько раз каждый элемент попал в ту или иную ветку.

public class MyArray {

    private static void countSwitch(int[] arr) {

        int[] counter = new int[11];

        for (int c = 0; c < counter.length; c++) {

            counter[c] = 0;
        }

        for (int i : arr) {

            switch (i) {

                case 0:
                    counter[0]++;
                    break;

                case 1:
                    counter[1]++;
                    break;

                case 2:
                    counter[2]++;
                    break;

                case 3:
                    counter[3]++;
                    break;

                case 4:
                    counter[4]++;
                    break;

                case 5:
                    counter[5]++;
                    break;

                case 6:
                    counter[6]++;
                    break;

                case 7:
                    counter[7]++;
                    break;

                case 8:
                    counter[8]++;
                    break;

                case 9:
                    counter[9]++;
                    break;

                case 10:
                    counter[10]++;
                    break;
            }
        }
    }

    private static void countIF(int[] arr) {

        int[] counter = new int[11];

        for (int c = 0; c < counter.length; c++) {

            counter[c] = 0;
        }

        for (int i : arr) {

            if (i == 0) {
                counter[1]++;
            }

            else if (i == 1) {
                counter[1]++;
            }

            else if (i == 2) {
                counter[2]++;
            }

            else if (i == 3) {
                counter[3]++;
            }

            else if (i == 4) {
                counter[4]++;
            }

            else if (i == 5) {
                counter[5]++;
            }

            else if (i == 6) {
                counter[6]++;
            }

            else if (i == 7) {
                counter[7]++;
            }

            else if (i == 8) {
                counter[8]++;
            }

            else if (i == 9) {
                counter[9]++;
            }

            else {
                counter[10]++;
            }
        }
    }

    public static void main(String[] args) {

        int[] arr = new int[50];

        for (int i = 0; i < arr.length; i++) {

            arr[i] = (int)(Math.random() * 11);
        }

        long startTimeSC = System.nanoTime();
        countSwitch(arr);
        long estimatedTimeSC = System.nanoTime() - startTimeSC;

        long startTimeIF = System.nanoTime();
        countIF(arr);
        long estimatedTimeIF = System.nanoTime() - startTimeIF;

        System.out.println(estimatedTimeSC); // время работы конструкции Switch Case
        System.out.println(estimatedTimeIF); // время работы If Else

        if (estimatedTimeIF > estimatedTimeSC) {
            System.out.println("Конструкция switch case работает быстрее " + estimatedTimeSC + " чем if else " + estimatedTimeIF);
        }
        else {
            System.out.println("Конструкция if else работает быстрее " + estimatedTimeIF + " чем switch case " + estimatedTimeSC);
        }
    }
}
