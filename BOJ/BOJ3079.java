package boj;

/*
 * 입국심사
 */

import java.io.*;
import java.util.*;

public class BOJ3079 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] times = new int[N];
        int minCost = Integer.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            times[i] = Integer.parseInt(br.readLine());
            minCost = Math.min(minCost, times[i]);

        }

        long max = minCost * M;
        long min = 0L;

        long answer = max;

        while (min <= max) {
            long mid = (max + min) / 2;

            int pass = 0;
            for (int time : times) {
                pass += mid / time;
                if (pass >= M) {
                    break;
                }
            }

            if (pass >= M) {
                answer = mid;
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }

        System.out.println(answer);

    }
}
