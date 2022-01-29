package BOJ;

/**
 * 1, 2, 3 더하기 3
 */

import java.io.*;

public class BOJ15988_copy {

    public static void main(String[] args) throws NumberFormatException, IOException {
        new BOJ15988_copy().solution();
    }

    void solution() throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder answer = new StringBuilder();

        long[] dp = new long[1000001];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;

        for (int i = 4; i <= 1000000; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2] + dp[i - 3]) % 1000000009;
        }

        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {

            int n = Integer.parseInt(br.readLine());
            answer.append(dp[n]).append("\n");
        }

        System.out.println(answer.toString().trim());
    }

}