package programmers;

import java.util.Arrays;

/* 
    합승 택시 요금

*/

public class pro132 {
    public static void main(String[] args) {

        int n = 6;
        int s = 4;
        int a = 6;
        int b = 2;

        int[][] fares = { { 4, 1, 10 }, { 3, 5, 24 }, { 5, 6, 2 }, { 3, 1, 41 }, { 5, 1, 24 }, { 4, 6, 50 },
                { 2, 4, 66 }, { 2, 3, 22 }, { 1, 6, 25 } };

        System.out.println(solution(n, s, a, b, fares));
    }

    static int[][] dp;

    public static int solution(int n, int s, int a, int b, int[][] fares) {
        int answer = Integer.MAX_VALUE;

        dp = new int[n + 1][n + 1];

        for (int[] d : dp) {
            Arrays.fill(d, 20000000);
        }

        for (int[] f : fares) {
            dp[f[0]][f[1]] = f[2];
            dp[f[1]][f[0]] = f[2];
        }

        for (int m = 1; m <= n; m++) {
            for (int f = 1; f <= n; f++) {
                for (int t = 1; t <= n; t++) {
                    if (f == t) {
                        dp[f][t] = 0;
                    } else {
                        dp[f][t] = Math.min(dp[f][t], dp[f][m] + dp[m][t]);
                    }
                }
            }
        }

        for (int m = 1; m <= n; m++) {
            answer = Math.min(answer, dp[s][m] + dp[m][a] + dp[m][b]);
        }

        return answer;
    }

}
