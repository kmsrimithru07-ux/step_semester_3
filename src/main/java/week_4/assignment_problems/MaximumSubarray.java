package main.java.week_4.assignment_problems;
public class MaximumSubarray {

    int maxSubArray(int[] nums) {

        int currentSum = nums[0];
        int maxSum = nums[0];

        for (int i = 1; i < nums.length; i++) {

            currentSum = Math.max(nums[i], currentSum + nums[i]);

            maxSum = Math.max(maxSum, currentSum);
        }

        return maxSum;
    }

    public static void main(String[] args) {

        MaximumSubarray obj = new MaximumSubarray();

        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};

        System.out.println(obj.maxSubArray(nums));
    }
}