package reetcode;

import java.util.*;

public class reet219 {

    public static void main(String[] args) {

        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9, 9};
        int k = 3;

        System.out.println(containsNearbyDuplicate(nums, k));
    }

    public static boolean containsNearbyDuplicate(int[] nums, int k) {

        if (k == 0)
            return false;

        Map<Integer, Integer> numberInRangeK = new HashMap<Integer, Integer>();

        for (int i = 1; i <= k && i < nums.length; i++) {
            numberInRangeK.put(nums[i], numberInRangeK.getOrDefault(nums[i], 0) + 1);
        }
        System.out.println(numberInRangeK);


        for (int i = 0; i < nums.length; i++) {
            if (numberInRangeK.containsKey(nums[i]))
                return true;

            if (i + 1 < nums.length) {
                numberInRangeK.put(nums[i + 1], numberInRangeK.getOrDefault(nums[i + 1], 0) - 1);
                if (numberInRangeK.get(nums[i + 1]) == 0) {
                    numberInRangeK.remove(nums[i + 1]);
                }
            }

            if (i + 1 + k < nums.length)
                numberInRangeK.put(nums[i + 1 + k],
                        numberInRangeK.getOrDefault(nums[i + 1 + k], 0) + 1);

            System.out.println(numberInRangeK);
        }
        return false;
    }
}
