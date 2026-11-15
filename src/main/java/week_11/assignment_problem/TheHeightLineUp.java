package main.java.week_11.assignment_problem;
import java.util.Arrays;

public class TheHeightLineUp {

    public static void lineUp(int[] heights) {
        int n = heights.length;

        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false;

            for (int j = 0; j < n - 1 - i; j++) {
                if (heights[j] > heights[j + 1]) {
                    int temp = heights[j];
                    heights[j] = heights[j + 1];
                    heights[j + 1] = temp;
                    swapped = true;
                }
            }

            System.out.println("Pass " + (i + 1) + ": " + Arrays.toString(heights));

            if (!swapped) {
                break;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("Sample Input 1:");
        lineUp(new int[]{4, 2, 5, 1});

        System.out.println("\nSample Input 2:");
        lineUp(new int[]{1, 3, 2, 4});

        System.out.println("\nCustom Input (Already sorted):");
        lineUp(new int[]{10, 20, 30, 40});
    }
}