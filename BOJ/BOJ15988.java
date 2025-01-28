package boj;

/**
 * 1, 2, 3 더하기 3
 */

import java.io.*;

public class BOJ15988 {

    public static void main(String[] args) throws NumberFormatException, IOException {
        new BOJ15988().solution();
    }

    void solution() throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder answer = new StringBuilder();

        dp = new long[1000001];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;

        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {

            int n = Integer.parseInt(br.readLine());
            answer.append(findDP(n)).append("\n");
        }

        System.out.println(answer.toString().trim());
    }

    long[] dp;

    long findDP(int n) {

        if (dp[n] != 0) {
            return dp[n];
        }

        return dp[n] = (findDP(n - 1) + findDP(n - 2) + findDP(n - 3)) % 1000000009;
    }

}
