package BJ;

import java.util.*;
import java.io.*;

/* 
    동전
*/
public class BJ9084 {

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());

            int[] coins = new int[n];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                coins[i] = Integer.parseInt(st.nextToken());
            }

            int m = Integer.parseInt(br.readLine());

            int[] dp = new int[m + 1];
            dp[0] = 1;

            for (int coin : coins) {
                for (int i = coin; i <= m; i++) {
                    dp[i] += dp[i - coin];
                }
            }

            sb.append(dp[m]).append("\n");
        }

        System.out.println(sb.toString().trim());
    }
}
