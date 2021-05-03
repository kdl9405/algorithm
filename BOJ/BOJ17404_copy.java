package BOJ;

import java.io.*;
import java.util.*;

/* 
    RGB거리 2

    java 8 : 96ms
    java 11 : 228ms
*/
public class BOJ17404_copy {

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
            dp[0][i] = 1000001;
            min = Math.min(fidnDP(N, i), min);

            for (int j = 0; j <= N; j++) {
                Arrays.fill(dp[j], 0);
            }
        }

        System.out.println(min);

    }

    static int fidnDP(int h, int c) {

        if (h == 1) {
            return dp[0][c] + color[1][c];
        }

        if (dp[h][c] != 0) {
            return dp[h][c];
        }

        int cost = 0;

        if (c == 0) {
            cost = Math.min(fidnDP(h - 1, 1), fidnDP(h - 1, 2));
        } else if (c == 1) {
            cost = Math.min(fidnDP(h - 1, 0), fidnDP(h - 1, 2));
        } else {
            cost = Math.min(fidnDP(h - 1, 0), fidnDP(h - 1, 1));
        }

        dp[h][c] = color[h][c] + cost;
        return dp[h][c];
    }
}
