package main.java.week_4.class_problems;
import java.util.Arrays;

public class RotateArray {

    int[] rotateArray(int[] nums, int k) {

        k = k % nums.length;

        int[] newArray = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {

            newArray[(i + k) % nums.length] = nums[i];
        }

        return newArray;
    }

    public static void main(String[] args) {

        RotateArray obj = new RotateArray();

        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        int k = 3;

        int[] result = obj.rotateArray(nums, k);

        System.out.println(Arrays.toString(result));
    }
}