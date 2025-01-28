package boj;

/*
 * 자두나무
 */

import java.io.*;
import java.util.*;

public class BOJ2240 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int T = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());

        int[][] dp = new int[T + 1][W + 1];

        for (int i = 1; i <= T; i++) {
            int tree = Integer.parseInt(br.readLine());

            if (tree == 1) {
                dp[i][0] = dp[i - 1][0] + 1;
            } else {
                dp[i][0] = dp[i - 1][0];
            }

            for (int j = 1; j <= W; j++) {
                if (j % 2 == 0) {
                    if (tree == 1) {
                        dp[i][j] = Math.max(dp[i - 1][j - 1], dp[i - 1][j] + 1);
                    } else {
                        dp[i][j] = Math.max(dp[i - 1][j - 1] + 1, dp[i - 1][j]);
                    }
                } else {
                    if (tree == 1) {
                        dp[i][j] = Math.max(dp[i - 1][j - 1] + 1, dp[i - 1][j]);
                    } else {
                        dp[i][j] = Math.max(dp[i - 1][j - 1], dp[i - 1][j] + 1);
                    }
                }
            }
        }

        int max = 0;
        for (int i = 0; i <= W; i++) {
            max = Math.max(max, dp[T][i]);
        }

        System.out.println(max);

    }
}
