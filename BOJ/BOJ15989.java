package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 1, 2, 3 더하기 4
 */

public class BOJ15989 {

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        dp = new int[10001][4];

        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine());

            sb.append(findN(n, 0)).append("\n");


        }

        System.out.println(sb.toString().trim());

    }

    static int[][] dp;

    static int findN(int n, int x) {

        if (n < 0) {
            return 0;
        }

        if (n == x) {
            return 1;
        }

        if (dp[n][x] != 0) {
            return dp[n][x];
        }

        if (x == 3) {
            if (n % 3 == 0 && n / 3 > 0) {
                return 1;
            } else {
                return 0;
            }
        }

        if (x == 2) {

            return dp[n][x] = findN(n - 2, 2) + findN(n - 2, 3);
        }

        if (x == 1) {
            return dp[n][x] = findN(n - 1, 1) + findN(n - 1, 2) + findN(n - 1, 3);
        }

        return dp[n][0] = findN(n, 1) + findN(n, 2) + findN(n, 3);

    }
}
