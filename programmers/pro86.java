package programmers;

import java.util.Arrays;

/**
 * 보행자 천국
 * 
 */
public class pro86 {

    public static void main(String[] args) {

        int[][] cityMap = { { 0, 2, 0, 0, 0, 2 }, { 0, 0, 2, 0, 1, 0 }, { 1, 0, 0, 2, 2, 0 } };
        int m = 3;
        int n = 6;

        System.out.println(solution(m, n, cityMap));

    }

    static int MOD = 20170805;

    static int[][][] dp;

    static int solution(int m, int n, int[][] cityMap) {
        int answer = 0;

        dp = new int[m + 1][n + 1][2];
        dp[1][1][0] = 1; // 오른쪽
        dp[1][1][1] = 1; // 아래쪽

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (cityMap[i - 1][j - 1] == 1) {
                    dp[i][j][0] = 0;
                    dp[i][j][1] = 0;
                } else if (cityMap[i - 1][j - 1] == 2) {
                    dp[i][j][0] = dp[i][j - 1][0];
                    dp[i][j][1] = dp[i - 1][j][1];
                } else {
                    dp[i][j][0] += (dp[i][j - 1][0] + dp[i - 1][j][1]) % MOD;
                    dp[i][j][1] = dp[i][j][0];
                }
            }
        }

        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                System.out.print(dp[i][j][0] + " ");
            }
            System.out.println("");
        }
        System.out.println("");

        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                System.out.print(dp[i][j][1] + " ");
            }
            System.out.println("");
        }

        answer = dp[m][n][0];

        return answer;
    }

}