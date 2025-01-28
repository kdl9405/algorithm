package boj;

import java.io.*;
import java.util.StringTokenizer;

// 시간초과

public class BOJ1912_copy {

    public static void main(final String[] args) throws NumberFormatException, IOException {

        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        final int n = Integer.parseInt(br.readLine());
        final int[] arr = new int[n];
        final int[] dp = new int[n];
        final StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }


        for (int i = 0; i < n; i++) {
            dp[i] = arr[i];
            int max = Integer.MIN_VALUE;

            for (int j = i; j < n; j++) {
                dp[i] += arr[j];
                max = Math.max(max, dp[i]);
            }

            dp[i] = max - arr[i];
        }

        int max = Integer.MIN_VALUE;
        for (final int d : dp) {
            max = Math.max(max, d);
        }

        System.out.println(max);

    }
}
