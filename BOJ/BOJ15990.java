package boj;

import java.io.*;

/*
 * 1, 2, 3 더하기 5
 */
public class BOJ15990 {

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        dp = new int[100001][4];
        dp[1][1] = 1; // 1
        dp[2][2] = 1; // 2
        dp[3][1] = 1; // 2 1
        dp[3][2] = 1; // 1 2
        dp[3][3] = 1; // 3

        StringBuilder answer = new StringBuilder();
        while (T-- > 0) {

            int n = Integer.parseInt(br.readLine());

            int cnt = findDP(n, 0);

            answer.append(cnt).append("\n");
        }

        System.out.println(answer.toString().trim());

    }

    static int[][] dp;

    static int findDP(int n, int last) {

        if (n <= 0) {
            return 0;
        }

        if (dp[n][last] > 0) {
            return dp[n][last];
        }

        if (last == 1) {
            dp[n][last] = (findDP(n - 1, 2) + findDP(n - 1, 3)) % 1000000009;
        } else if (last == 2) {
            dp[n][last] = (findDP(n - 2, 1) + findDP(n - 2, 3)) % 1000000009;
        } else if (last == 3) {
            dp[n][last] = (findDP(n - 3, 1) + findDP(n - 3, 2)) % 1000000009;
        } else {
            dp[n][last] =
                    (((findDP(n, 1) + findDP(n, 2)) % 1000000009) + findDP(n, 3)) % 1000000009;
        }

        return dp[n][last];
    }

}
