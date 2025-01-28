package boj;

import java.util.Scanner;

/*
 * 타일 채우기
 */

public class BOJ2133_copy {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());

        dp = new int[31];
        dp[0] = 1;
        // dp[2] = 3;

        System.out.println(findDP(n));

    }

    static int[] dp;

    static int findDP(int n) {

        System.out.println(n);

        if (n < 0) {
            return 0;
        }

        if (dp[n] != 0) {
            return dp[n];
        }

        dp[n] = (findDP(n - 2) * 3);

        for (int j = n - 4; j >= 0; j -= 2) {
            dp[n] += (dp[j] * 2);
        }

        return dp[n];
    }

}
