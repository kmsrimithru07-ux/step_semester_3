package main.java.week_11.practice_problem;
import java.util.*;

public class PairWithTargetSum {
    // Approach 1: HashSet (Optimal Time)
    public static boolean hasPairWithSum(int[] nums, int target) {
        Set<Integer> seen = new HashSet<>();
        for (int num : nums) {
            int complement = target - num;
            if (seen.contains(complement)) {
                return true;
            }
            seen.add(num);
        }
        return false;
    }

    // Approach 2: Sorting + Two Pointers (Lower Extra Space)
    public static boolean hasPairWithSumTwoPointers(int[] nums, int target) {
        int[] copy = Arrays.copyOf(nums, nums.length);
        Arrays.sort(copy);
        int left = 0, right = copy.length - 1;

        while (left < right) {
            int sum = copy[left] + copy[right];
            if (sum == target) return true;
            if (sum < target) left++;
            else right--;
        }
        return false;
    }
}