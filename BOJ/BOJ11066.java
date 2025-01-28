package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ11066 {

    static int cost[];
    static int dp[][];
    static int sum[];

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {

            int k = Integer.parseInt(br.readLine());

            cost = new int[k + 1];
            st = new StringTokenizer(br.readLine());
            sum = new int[k + 1];

            for (int i = 1; i <= k; i++) {
                cost[i] = Integer.parseInt(st.nextToken());
                sum[i] = sum[i - 1] + cost[i];
            }

            dp = new int[k + 1][k + 1];

            for (int[] d : dp) {
                Arrays.fill(d, Integer.MAX_VALUE);
            }

            sb.append(sumDP(1, k) + "\n");

        }

        System.out.println(sb);
    }

    static int sumDP(int x, int y) {
        if (x >= y) {
            return 0;
        }
        if (dp[x][y] != Integer.MAX_VALUE) {
            return dp[x][y];
        }

        if (y - x == 1) {
            return cost[x] + cost[y];
        }

        for (int i = x; i <= y; i++) {
            int temp = sumDP(x, i) + sumDP(i + 1, y) + sum[y] - sum[x - 1];
            dp[x][y] = Math.min(temp, dp[x][y]);
        }

        return dp[x][y];
    }


}
