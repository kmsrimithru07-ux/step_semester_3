package main.java.week_11.assignment_problem;
public class TheDiceThrowTally {

    public static int[] diceSort(int[] rolls) {
        int[] count = new int[7];

        for (int roll : rolls) {
            count[roll]++;
        }

        System.out.print("Counts:");
        for (int v = 1; v <= 6; v++) {
            System.out.print(" " + v + ":" + count[v]);
        }
        System.out.println();

        int[] sorted = new int[rolls.length];
        int index = 0;
        for (int v = 1; v <= 6; v++) {
            for (int c = 0; c < count[v]; c++) {
                sorted[index++] = v;
            }
        }

        return sorted;
    }

    private static void printSorted(int[] arr) {
        System.out.print("Sorted: [");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i < arr.length - 1) System.out.print(", ");
        }
        System.out.println("]");
    }

    public static void main(String[] args) {
        System.out.println("Sample Input:");
        int[] sampleSorted = diceSort(new int[]{4, 1, 6, 4, 2, 1, 4});
        printSorted(sampleSorted);

        System.out.println("\nCustom Input:");
        int[] customSorted = diceSort(new int[]{6, 5, 6, 3, 1, 5, 2, 3});
        printSorted(customSorted);
    }
}
