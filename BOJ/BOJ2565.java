package boj;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ2565 {

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[][] line = new int[n][2];
        int[] dp = new int[n];

        StringTokenizer st;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            line[i][0] = Integer.parseInt(st.nextToken());
            line[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(line, (l1, l2) -> {
            return l1[0] - l2[0];
        });


        for (int i = 0; i < n; i++) {

            dp[i] = 1;

            for (int j = 0; j < i; j++) {
                if (line[i][1] > line[j][1]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }

        }

        int max = 0;
        for (int d : dp) {
            max = Math.max(max, d);
        }

        System.out.println(n - max);

    }
}
