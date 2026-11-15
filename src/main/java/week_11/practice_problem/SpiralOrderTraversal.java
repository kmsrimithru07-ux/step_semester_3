package main.java.week_11.practice_problem;
import java.util.*;

public class SpiralOrderTraversal {
    public static List<Integer> spiralOrder(int[][] grid) {
        List<Integer> result = new ArrayList<>();
        if (grid == null || grid.length == 0) return result;

        int top = 0, bottom = grid.length - 1;
        int left = 0, right = grid[0].length - 1;

        while (top <= bottom && left <= right) {
            for (int c = left; c <= right; c++) result.add(grid[top][c]);
            top++;

            for (int r = top; r <= bottom; r++) result.add(grid[r][right]);
            right--;

            if (top <= bottom) {
                for (int c = right; c >= left; c--) result.add(grid[bottom][c]);
                bottom--;
            }

            if (left <= right) {
                for (int r = bottom; r >= top; r--) result.add(grid[r][left]);
                left++;
            }
        }
        return result;
    }
}