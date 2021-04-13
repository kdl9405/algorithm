package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * BOJ9461
 */

// 파도반 수열
public class BOJ9461 {

    static Long[] dp = new Long[101];

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());

        dp[0] = 0L;
        dp[1] = 1L;
        dp[2] = 1L;
        dp[3] = 1L;

        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());

            sb.append(padovan(n) + "\n");
        }

        System.out.println(sb);
    }

    static long padovan(int n) {
        if (dp[n] == null) {
            dp[n] = padovan(n - 2) + padovan(n - 3);
        }

        return dp[n];
    }
}