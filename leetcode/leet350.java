package leetcode;

import java.util.*;

public class leet350 {

    public static void main(String[] args) {

    }

    public static int[] intersect(int[] nums1, int[] nums2) {

        Map<Integer, Integer> numsMap = new HashMap<>();

        for (int num : nums1) {
            numsMap.put(num, numsMap.getOrDefault(num, 0) + 1);
        }

        List<Integer> intersectList = new ArrayList();

        for (int num : nums2) {
            if (numsMap.containsKey(num) && numsMap.get(num) > 0) {
                intersectList.add(num);

                numsMap.put(num, numsMap.get(num) - 1);
            }
        }

        return intersectList.stream().mapToInt(Integer::intValue).toArray();
    }
}
