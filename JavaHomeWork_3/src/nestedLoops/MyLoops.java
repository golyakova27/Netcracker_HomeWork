package nestedLoops;

// Задачи на использование вложенных циклов

public class MyLoops {

    private static void rectangle(int size, char symbol) {

        for (int row = 0; row < size; row++) {

            for (int column = 0; column < size; column++) {

                System.out.print(symbol);
            }
            System.out.println();
        }

        System.out.println();
    }

    private static void lowerLeft(int size, char symbol) {

        for (int row = 0; row < size; row++) {

            for (int column = 0; column < row + 1; column++) {

                System.out.print(symbol);
            }
            System.out.println();
        }

        System.out.println();
    }

    private static void upperLeft(int size, char symbol) {

        for (int row = 0; row < size; row++) {

            for (int column = size - row; column > 0; column--) {

                System.out.print(symbol);
            }
            System.out.println();
        }

        System.out.println();
    }

    private static void lowerRight(int size, char symbol) {

        for (int row = 0; row < size; row++) {

            int column1 = size;

            for (column1 = 0; column1 < (size - row - 1); column1++) {

                System.out.print(' ');
            }

            for (int column2 = column1; column2 < size; column2++) {

                System.out.print(symbol);
            }

            System.out.println();
        }

        System.out.println();
    }

    private static void upperRight(int size, char symbol) {

        for (int row = 0; row < size; row++) {

            int column1 = size;

            for (column1 = size; column1 > size - row; column1--) {

                System.out.print(' ');
            }

            for (int column2 = column1; column2 > 0; column2--) {

                System.out.print(symbol);
            }

            System.out.println();
        }

        System.out.println();
    }

    public static void main(String[] args) {

        char symbol = '*';
        int size = 10; // количество столбцов
        rectangle(size, symbol);
        lowerLeft(size, symbol);
        upperLeft(size, symbol);
        lowerRight(size, symbol);
        upperRight(size, symbol);

    }
}
