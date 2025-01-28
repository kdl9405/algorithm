package boj;

/*
 * 자상의 경로
 */

import java.io.*;
import java.util.*;

public class BOJ10164 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        dp = new int[N + 1][M + 1];
        dp[1][1] = 1;

        if (K == 0) {

            System.out.println(findDP(N, M));

        } else {
            int r1 = (K - 1) / M + 1;
            int c1 = K - (M * (r1 - 1));
            int r2 = N + 1 - r1;
            int c2 = M + 1 - c1;

            int before = findDP(r1, c1);
            int after = findDP(r2, c2);

            System.out.println(before * after);

        }

    }

    static int[][] dp;

    static int findDP(int n, int m) {

        if (n <= 0 || m <= 0) {
            return 0;
        }

        if (dp[n][m] != 0) {
            return dp[n][m];
        }

        return dp[n][m] = findDP(n - 1, m) + findDP(n, m - 1);
    }

}
