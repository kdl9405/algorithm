package reetcode;

import java.util.*;

public class reet219 {

    public static void main(String[] args) {

        int[] nums = {1, 4, 2, 3, 1, 2};
        int k = 3;

        System.out.println(containsNearbyDuplicate(nums, k));
    }

    public static boolean containsNearbyDuplicate(int[] nums, int k) {

        Set<Integer> numberInRangeK = new HashSet<>();

        for (int i = 1; i <= k && i < nums.length; i++) {
            numberInRangeK.add(nums[i]);
        }
        System.out.println(numberInRangeK);


        int lastIndex = Math.max(k, nums.length - k);
        for (int i = 0; i < lastIndex; i++) {
            if (numberInRangeK.contains(nums[i]))
                return true;

            if (i + 1 < lastIndex)
                numberInRangeK.remove(nums[i + 1]);

            if (i + 1 + k <= lastIndex)
                numberInRangeK.add(nums[i + 1 + k]);

            System.out.println(numberInRangeK);
        }
        return false;
    }
}
