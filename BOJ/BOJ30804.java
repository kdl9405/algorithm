package boj;

import java.io.*;
import java.util.*;

public class BOJ30804 {

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        tanghulu = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();


        System.out.println(findMaxCount(N));
    }

    static int[] tanghulu;

    static int findMaxCountWithBitMasking(int N) {

        int maxCount = 0;
        int left = 0;
        int mask = 0;

        int[] fruitCount = new int[10];

        for (int right = 0; right < N; right++) {

            int fruit = tanghulu[right];

            fruitCount[fruit]++;

            mask |= (1 << fruit);

            while (Integer.bitCount(mask) > 2) {
                int leftFruit = tanghulu[left];
                fruitCount[leftFruit]--;

                if (fruitCount[leftFruit] == 0) {
                    mask &= ~(1 << leftFruit);
                }

                left++;
            }

            maxCount = Math.max(maxCount, right - left + 1);
        }

        return maxCount;
    }


    static int findMaxCount(int N) {

        int maxCount = 0;
        int left = 0;

        Map<Integer, Integer> fruitCount = new HashMap<>();

        for (int right = 0; right < N; right++) {

            fruitCount.put(tanghulu[right], fruitCount.getOrDefault(tanghulu[right], 0) + 1);

            while (fruitCount.size() > 2) {
                int leftFruit = tanghulu[left];

                if (fruitCount.get(leftFruit) == 1) {
                    fruitCount.remove(leftFruit);
                } else {
                    fruitCount.put(leftFruit, fruitCount.get(leftFruit) - 1);
                }

                left++;
            }

            maxCount = Math.max(maxCount, right - left + 1);
        }

        return maxCount;
    }


    // 아래는 시간초과
    static void makeTanghulu(int start, int end) {

        if (end - start + 1 <= maxCount) {
            return;
        }

        if (checkTanghulu(start, end)) {
            maxCount = end - start + 1;
            return;
        }

        makeTanghulu(start + 1, end);
        makeTanghulu(start, end - 1);

    }

    static boolean checkTanghulu(int start, int end) {

        if (start > end)
            return false;

        boolean[] fruit = new boolean[10];

        int fruitCount = 0;
        for (int i = start; i <= end; i++) {
            if (!fruit[tanghulu[i]]) {
                fruitCount++;
                fruit[tanghulu[i]] = true;
            }

            if (fruitCount > 2) {
                return false;
            }
        }
        return true;
    }
}
