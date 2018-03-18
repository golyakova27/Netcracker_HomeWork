package factorial;

// Вычисление n! факториала с помощью цикла и рекурсией

public class MyFactorials {

    private static long recursive(int n) {

        if (n == 1 || n == 0) return 1;
        return recursive(n - 1) * n;
    }

    private static long cyclical(int n) {

        long result = 1;

        if (n == 0) return result;
        else {
            for (int i = 1; i <= n; i++) {
                result *= i;
            }
        }

        return result;
    }

    public static void main(String[] args) {

        int n = 190;

        long startTimeCyclical = System.nanoTime();
        cyclical(n);
        long estimatedTimeCyclical = System.nanoTime() - startTimeCyclical;

        long startTimeRecursive = System.nanoTime();
        recursive(n);
        long estimatedTimeRecursive = System.nanoTime() - startTimeRecursive;

        if (estimatedTimeCyclical > estimatedTimeRecursive) {
            System.out.println("Recursive solution has a better result (" + estimatedTimeRecursive + "ns) than a cyclic solution (" + estimatedTimeCyclical + "ns).");
        }
        else
        {
            System.out.println("Cyclic solution has a better result (" + estimatedTimeCyclical + "ns) than a recursive solution (" + estimatedTimeRecursive + "ns).");
        }
    }
}
