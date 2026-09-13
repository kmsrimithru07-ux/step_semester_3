package main.java.week_4.assignment_problems;
import java.util.HashMap;

public class SubarraySumK {

    int subarraySum(int[] nums, int k) {

        HashMap<Integer, Integer> map = new HashMap<>();

        map.put(0, 1);

        int sum = 0;
        int count = 0;

        for (int num : nums) {

            sum = sum + num;

            if (map.containsKey(sum - k)) {
                count = count + map.get(sum - k);
            }

            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }

        return count;
    }

    public static void main(String[] args) {

        SubarraySumK obj = new SubarraySumK();

        int[] nums = {1, 1, 1};
        int k = 2;

        System.out.println(obj.subarraySum(nums, k));
    }
}