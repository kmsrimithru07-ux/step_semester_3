package main.java.week_11.assignment_problem;
public class ThePrizeTable {

    public static int prizeTable(int[] marks) {
        int n = marks.length;
        int swaps = 0;

        for (int i = 0; i < n - 1; i++) {
            int maxIndex = i;

            for (int j = i + 1; j < n; j++) {
                if (marks[j] > marks[maxIndex]) {
                    maxIndex = j;
                }
            }

            if (maxIndex != i) {
                int temp = marks[i];
                marks[i] = marks[maxIndex];
                marks[maxIndex] = temp;
                swaps++;
            }
        }

        return swaps;
    }

    private static void printResult(int[] marks, int swaps) {
        System.out.print("[");
        for (int i = 0; i < marks.length; i++) {
            System.out.print(marks[i]);
            if (i < marks.length - 1) System.out.print(", ");
        }
        System.out.println("] swaps = " + swaps);
    }

    public static void main(String[] args) {
        int[] sample1 = {45, 90, 60, 75};
        int swaps1 = prizeTable(sample1);
        printResult(sample1, swaps1);

        int[] sample2 = {80, 70, 60};
        int swaps2 = prizeTable(sample2);
        printResult(sample2, swaps2);

        int[] custom = {65, 92, 78, 99, 84};
        int swaps3 = prizeTable(custom);
        printResult(custom, swaps3);
    }
}