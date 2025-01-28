package boj;

import java.io.*;
import java.util.*;

/*
 * 구간 합 구하기
 * 
 * // 시간초과
 */
public class BOJ2042_copy {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        long[] arr = new long[n + 1];
        long[] sum = new long[n + 1];

        for (int i = 1; i <= n; i++) {
            arr[i] = Long.parseLong(br.readLine());
            sum[i] = sum[i - 1] + arr[i];
        }

        for (int i = 0; i < m + k; i++) {
            st = new StringTokenizer(br.readLine());

            if (st.nextToken().equals("1")) {
                int b = Integer.parseInt(st.nextToken());
                long c = Long.parseLong(st.nextToken());
                long d = c - arr[b];

                for (int j = b; j <= n; j++) {
                    sum[j] += d;
                }

                arr[b] = c;

            } else {

                int b = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());

                sb.append(sum[c] - sum[b - 1]).append("\n");

            }
        }

        System.out.println(sb.toString());

    }
}
