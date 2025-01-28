package boj;

/*
 * 수열
 */

import java.io.*;
import java.util.*;

public class BOJ2559 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] num = new int[N];
        for (int i = 0; i < N; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }

        int[] sum = new int[N];
        sum[0] = num[0];
        for (int i = 1; i < K; i++) {
            sum[i] = sum[i - 1] + num[i];
        }

        int max = sum[K - 1];

        for (int i = K; i < N; i++) {
            sum[i] = sum[i - 1] - num[i - K] + num[i];
            max = Math.max(max, sum[i]);
        }

        System.out.println(max);
    }
}
