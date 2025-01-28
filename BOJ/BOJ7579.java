package boj;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ7579 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        long m = Long.parseLong(st.nextToken());

        long[][] app = new long[n][2];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            app[i][0] = Integer.parseInt(st.nextToken());
        }

        int cost = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            app[i][1] = Integer.parseInt(st.nextToken());
            cost += app[i][1];
        }

        Arrays.sort(app, (a1, a2) -> {
            if (a1[1] == a2[1]) {
                return (int) (a2[0] - a1[0]);
            }
            return (int) (a1[1] - a2[1]);
        });

        long[] dp = new long[cost + 1];
        for (int i = 0; i < n; i++) {
            for (int j = cost; j >= app[i][1]; j--) {
                dp[j] = Math.max(dp[j], dp[j - (int) app[i][1]] + app[i][0]);
            }
            for (int j = 0; j <= cost; j++) {
                System.out.print(dp[j] + " ");
            }
            System.out.println("");
        }

        for (int i = 0; i <= cost; i++) {
            if (dp[i] >= m) {
                System.out.println(i);
                break;
            }
        }
    }
}
