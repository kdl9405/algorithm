package BJ;

import java.io.*;
import java.util.*;

/* 
    점프

*/

public class BJ1890 {
    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        int[][] arr = new int[n + 1][n + 1];
        long[][] dp = new long[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dp[1][1] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {

                if (dp[i][j] == 0) {
                    continue;
                }

                if (i == n && j == n) {
                    continue;
                }
                int d = arr[i][j];

                if (d + j <= n) {
                    dp[i][d + j] += dp[i][j];
                }

                if (d + i <= n) {
                    dp[i + d][j] += dp[i][j];
                }
            }
        }

        System.out.println(dp[n][n]);

    }
}
