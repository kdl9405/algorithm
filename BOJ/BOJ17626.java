package BJ;

import java.io.*;
import java.util.*;

/* 
    Four Squares
*/

public class BJ17626 {

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        dp = new int[n + 1];
        dp[1] = 1;

        int min = 0;

        for (int i = 2; i <= n; i++) {
            min = Integer.MAX_VALUE;

            for (int j = 1; j * j <= i; j++) {
                int x = i - (j * j);
                min = Math.min(min, dp[x]);
            }

            dp[i] = min + 1;
        }

        System.out.println(dp[n]);

    }

    static int[] dp;
}
