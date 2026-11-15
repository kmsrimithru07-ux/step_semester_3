package main.java.week_11.assignment_problem;
public class IsTheQueueInOrder {

    public static int firstBreak(int[] tokens) {
        if (tokens == null || tokens.length <= 1) {
            return -1;
        }

        for (int i = 1; i < tokens.length; i++) {
            if (tokens[i] < tokens[i - 1]) {
                return i;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] sample1 = {3, 5, 5, 8, 6, 9};
        System.out.println("Sample 1: " + firstBreak(sample1));

        int[] sample2 = {1, 2, 2, 7};
        System.out.println("Sample 2: " + firstBreak(sample2));

        int[] customSingle = {42};
        System.out.println("Custom 1 (Single student): " + firstBreak(customSingle));

        int[] customBreakAtStart = {10, 4, 12, 15};
        System.out.println("Custom 2 (Break at index 1): " + firstBreak(customBreakAtStart));
    }
}