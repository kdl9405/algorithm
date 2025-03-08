package leetcode;

import java.util.*;

public class leet27 {

    public static void main(String[] args) {

        int[] nums = {3, 2, 2, 3};
        int val = 3;

        int result = removeElement(nums, val);

        System.out.println(Arrays.toString(nums));
        System.err.println(result);

    }

    public static int removeElement(int[] nums, int val) {

        int k = 0;
        int count = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[k] = nums[i];
                k++;
                count++;
            }
        }

        return count;
    }
}
