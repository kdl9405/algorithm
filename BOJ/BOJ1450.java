package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
 * 냅색문제
 */
public class BOJ1450 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        long C = Long.parseLong(st.nextToken());

        num = new long[N];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            num[i] = Long.parseLong(st.nextToken());
        }

        aPart = new ArrayList<>();
        bPart = new ArrayList<>();

        aPart.add(0L);
        bPart.add(0L);

        findA(0, 0L, N / 2);
        findB(N / 2, 0L, N);

        int count = 0;

        Collections.sort(bPart);

        for (long a : aPart) {

            int left = 0;
            int right = bPart.size() - 1;
            while (left <= right) {

                int mid = (left + right) / 2;

                if (a + bPart.get(mid) <= C) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }

            count += (left);

        }

        System.out.println(count);

    }

    static long[] num;
    static List<Long> aPart;
    static List<Long> bPart;

    static void findA(int index, long sum, int n) {

        if (index == n) {
            return;
        }

        findA(index + 1, sum, n);

        sum += num[index];
        aPart.add(sum);

        findA(index + 1, sum, n);

        return;
    }

    static void findB(int index, long sum, int n) {

        if (index == n) {
            return;
        }

        findB(index + 1, sum, n);

        sum += num[index];
        bPart.add(sum);

        findB(index + 1, sum, n);

        return;
    }

}
