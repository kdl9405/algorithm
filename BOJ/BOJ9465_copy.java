package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 스티커
 * 
 * 시간 초과
 */

public class BOJ9465_copy {
    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine());

            stickers = new int[2][n + 1];

            for (int i = 0; i < 2; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 1; j <= n; j++) {
                    stickers[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            dp = new int[n + 1][2];

            int max = Math.max(findMax(n, 0), findMax(n, 1));

            sb.append(max).append("\n");
        }

        System.out.println(sb.toString());
    }

    static int[][] stickers;
    static int[][] dp;

    static int findMax(int n, int c) {

        if (dp[n][c] != 0) {
            return dp[n][c];
        }

        if (n == 1) {
            dp[n][c] = stickers[c][n];
            return dp[n][c];
        }

        if (n == 2) {
            if (c == 0) {
                dp[n][c] = findMax(1, 1) + stickers[c][n];
            } else {
                dp[n][c] = findMax(1, 0) + stickers[c][n];
            }
            return dp[n][c];
        }

        if (c == 0) {
            dp[n][c] = stickers[c][n] + Math.max(findMax(n - 1, 1), findMax(n - 2, 1));
        } else {
            dp[n][c] = stickers[c][n] + Math.max(findMax(n - 1, 0), findMax(n - 2, 0));
        }

        return dp[n][c];
    }

}
