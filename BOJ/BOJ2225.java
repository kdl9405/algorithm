package boj;

import java.io.*;
import java.util.*;

/*
 * 합분해
 */

public class BOJ2225 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        long[][] dp = new long[k + 1][n + 1]; // dp[i][j] i번 더해서 j가 되는 경우

        for (int i = 1; i <= k; i++) {
            for (int j = 0; j <= n; j++) {
                if (j == 0) {
                    dp[i][j] = 1;
                } else {
                    dp[i][j] = (dp[i - 1][j] + dp[i][j - 1]) % 1000000000;
                }
            }
        }

        System.out.println(dp[k][n]);

    }
}
