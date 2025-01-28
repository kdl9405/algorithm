package boj;

import java.io.*;
import java.util.*;

/*
 * 구간 나누기
 */

public class BOJ2228 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        arr = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        sum = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            sum[i] = sum[i - 1] + arr[i];
        }

        dp = new int[n + 1][n + 1];
        for (int[] d : dp) {
            Arrays.fill(d, -4000000);
        }

        visit = new boolean[n + 1][n + 1];


        System.out.println(findDP(n, m));

    }

    static int[] arr;
    static int[] sum;
    static int[][] dp;
    static boolean[][] visit;

    static int findDP(int n, int m) {

        if (m == 0) {
            return 0;
        }

        if (n < 0) {
            return -4000000;
        }
        if (visit[n][m]) {
            return dp[n][m];
        }

        visit[n][m] = true;
        dp[n][m] = findDP(n - 1, m);

        for (int i = n; i > 0; i--) {

            dp[n][m] = Math.max(dp[n][m], findDP(i - 2, m - 1) + (sum[n] - sum[i - 1]));
        }

        return dp[n][m];
    }
}
