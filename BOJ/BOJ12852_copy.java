package boj;

import java.util.Scanner;

/*
 * 1로 만들기 2
 * 
 * 시간초과
 */
public class BOJ12852 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        dp = new int[n + 1];

        System.out.println(findDP(n));

    }

    static int[] dp;

    static int findDP(int n) {

        System.out.println("!!!!!!!!" + n);
        if (n == 1) {
            return 0;
        }

        if (dp[n] != 0) {
            return dp[n];
        }

        dp[n] = findDP(n - 1);

        if (n % 2 == 0) {
            dp[n] = Math.min(dp[n], findDP(n / 2));
        }

        if (n % 3 == 0) {
            dp[n] = Math.min(dp[n], findDP(n / 3));
        }

        dp[n] += 1;

        return dp[n];
    }
}
