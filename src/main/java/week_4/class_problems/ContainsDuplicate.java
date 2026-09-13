package main.java.week_4.class_problems;
public class ContainsDuplicate {

    boolean containsDuplicate(int[] nums) {

        for (int i = 0; i < nums.length; i++) {

            for (int j = i + 1; j < nums.length; j++) {

                if (nums[i] == nums[j]) {
                    return true;
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {

        ContainsDuplicate obj = new ContainsDuplicate();

        int[] nums = {1, 2, 3, 1};

        System.out.println(obj.containsDuplicate(nums));
    }
}