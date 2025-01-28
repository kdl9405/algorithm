package boj;

import java.util.*;
import java.io.*;

public class BOJ2805 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        long m = Long.parseLong(st.nextToken());

        long[] trees = new long[n];

        long max = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            trees[i] = Long.parseLong(st.nextToken());
            max = Math.max(max, trees[i]);
        }

        long min = 0;
        long mid;
        long sum;

        while (min <= max) {
            mid = (min + max) / 2;
            sum = 0;

            for (int i = 0; i < n; i++) {
                if (trees[i] > mid) {
                    sum += trees[i] - mid;
                }
            }

            if (sum >= m) {
                min = mid + 1;
            } else {
                max = mid - 1;
            }

        }

        System.out.println(max);

    }
}
