package boj;

/*
 * 가장 긴 감소하는 부분 수열
 * 
 * 메모라이즈
 */

import java.io.*;
import java.util.*;

public class BOJ11722_copy {

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] A = new int[N + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[N + 1];

        int max = 0;
        for (int i = 1; i <= N; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (dp[j] < dp[i]) {
                    continue;
                }
                if (A[j] > A[i]) {
                    dp[i] = dp[j] + 1;
                }
            }

            max = Math.max(max, dp[i]);
        }

        System.out.println(max);

    }
}
