package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ2156 {

    static Integer[] dp;

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] wine = new int[n + 1];
        for (int i = 1; i < n + 1; i++) {
            wine[i] = Integer.parseInt(br.readLine());
        }

        dp = new Integer[n + 1];

        dp[0] = 0;
        dp[1] = wine[1];

        if (n > 1) {
            dp[2] = wine[1] + wine[2];
        }

        System.out.println(dp(n, wine));

    }

    static int dp(int n, int[] wine) {

        if (dp[n] == null) {
            dp[n] = Math.max((Math.max(dp(n - 2, wine), dp(n - 3, wine) + wine[n - 1]) + wine[n]),
                    dp(n - 1, wine));
        }

        return dp[n];

    }
}
