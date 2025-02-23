package reetcode;

import java.util.*;

public class reet169 {

    public static void main(String[] args) {


    }

    public int majorityElement(int[] nums) {

        int m = nums.length / 2;
        if (nums.length % 2 != 0)
            m++;

        int x = 0;

        Map<Integer, Integer> elementMap = new HashMap<>();

        for (int num : nums) {
            elementMap.put(num, elementMap.getOrDefault(num, 0) + 1);
        }

        for (int i : elementMap.keySet()) {
            if (elementMap.get(i) >= m) {
                x = i;
            }
        }

        return x;
    }

}
