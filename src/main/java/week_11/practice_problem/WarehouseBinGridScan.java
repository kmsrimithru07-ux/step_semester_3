package main.java.week_11.practice_problem;
public class WarehouseBinGridScan {
    static class Summary {
        int total;
        int[] maxCoordinate;

        Summary(int total, int r, int c) {
            this.total = total;
            this.maxCoordinate = new int[]{r, c};
        }
    }

    public static Summary warehouseSummary(int[][] grid) {
        int total = 0;
        int maxVal = -1;
        int maxRow = 0, maxCol = 0;

        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[r].length; c++) {
                total += grid[r][c];
                if (grid[r][c] > maxVal) {
                    maxVal = grid[r][c];
                    maxRow = r;
                    maxCol = c;
                }
            }
        }
        return new Summary(total, maxRow, maxCol);
    }
}