package main.java.week_11.practice_problem;
public class PairSumSortedArray {
    public static String pairSumSorted(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int sum = nums[left] + nums[right];
            if (sum == target) {
                return "(" + nums[left] + ", " + nums[right] + ")";
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }
        return "Not Found";
    }
}
