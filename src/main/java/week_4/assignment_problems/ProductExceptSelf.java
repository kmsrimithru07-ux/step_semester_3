package main.java.week_4.assignment_problems;
import java.util.Arrays;

public class ProductExceptSelf {

    int[] productExceptSelf(int[] nums) {

        int[] answer = new int[nums.length];

        int product = 1;

        // Left products
        for (int i = 0; i < nums.length; i++) {
            answer[i] = product;
            product = product * nums[i];
        }

        // Right products
        product = 1;

        for (int i = nums.length - 1; i >= 0; i--) {
            answer[i] = answer[i] * product;
            product = product * nums[i];
        }

        return answer;
    }

    public static void main(String[] args) {

        ProductExceptSelf obj = new ProductExceptSelf();

        int[] nums = {1, 2, 3, 4};

        System.out.println(
                Arrays.toString(obj.productExceptSelf(nums))
        );
    }
}