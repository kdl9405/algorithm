package boj;

import java.io.*;
import java.util.*;

/*
 * 진우의 달 여행 (Large)
 */

public class BOJ17485 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        arr = new int[n][m];
        for (int i = 0; i < n; i++) {

            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dp = new int[n + 1][m][4]; // i줄 j칸에 x방향으로 도착했을 때 최소비용

        int cost = Integer.MAX_VALUE;
        for (int i = 0; i < m; i++) {
            cost = Math.min(cost, findDP(0, i, 3));
        }

        System.out.println(cost);

    }

    static int[][][] dp;
    static int[][] arr;

    static int findDP(int i, int j, int d) {

        if (i == arr.length) {
            return 0;
        }

        if (dp[i][j][d] != 0) {
            return dp[i][j][d];
        }

        dp[i][j][d] = 200000;

        if (d != 0 && j - 1 >= 0) {
            dp[i][j][d] = Math.min(dp[i][j][d], findDP(i + 1, j - 1, 0) + arr[i][j]);
        }
        if (d != 1) {
            dp[i][j][d] = Math.min(dp[i][j][d], findDP(i + 1, j, 1) + arr[i][j]);
        }
        if (d != 2 && j + 1 < arr[0].length) {
            dp[i][j][d] = Math.min(dp[i][j][d], findDP(i + 1, j + 1, 2) + arr[i][j]);
        }

        return dp[i][j][d];
    }

}
