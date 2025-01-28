package boj;

import java.io.*;
import java.util.*;

/*
 * RGB거리 2
 * 
 */
public class BOJ17404 {

    static int[][] color;
    static int[][] dp;

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        color = new int[N + 1][3];

        StringTokenizer st;

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());

            int r = Integer.parseInt(st.nextToken());
            int g = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            color[i][0] = r;
            color[i][1] = g;
            color[i][2] = b;
        }

        dp = new int[N + 1][3];

        int min = Integer.MAX_VALUE;

        for (int i = 0; i < 3; i++) {

            for (int j = 0; j < 3; j++) {
                if (i == j) {
                    dp[1][j] = color[1][j];
                } else {
                    dp[1][j] = 1000001;
                }
            }

            for (int j = 2; j <= N; j++) {
                dp[j][0] = Math.min(dp[j - 1][1], dp[j - 1][2]) + color[j][0];
                dp[j][1] = Math.min(dp[j - 1][0], dp[j - 1][2]) + color[j][1];
                dp[j][2] = Math.min(dp[j - 1][0], dp[j - 1][1]) + color[j][2];

                if (j == N) {
                    if (i == 0) {
                        min = Math.min(min, Math.min(dp[j][1], dp[j][2]));
                    }

                    else if (i == 1) {
                        min = Math.min(min, Math.min(dp[j][0], dp[j][2]));
                    }

                    else if (i == 2) {
                        min = Math.min(min, Math.min(dp[j][0], dp[j][1]));
                    }
                }
            }
        }

        System.out.println(min);

    }

}
