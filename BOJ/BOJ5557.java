package BOJ;

import java.util.*;
import java.io.*;

/* 
    1학년 
*/

public class BOJ5557 {
    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] num = new int[n-1];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n - 1; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }

        int result = Integer.parseInt(st.nextToken());

        long[][] dp = new long[n][21];  // i번 계산 후, j가 나올 경우의 수
        dp[0][num[0]] = 1;

        for(int i = 1; i<n-1; i++){
            for(int j = 0; j<=20; j++){
                if (dp[i-1][j] != 0) {
                    if (j+num[i]<=20) {
                        dp[i][j+num[i]] += dp[i-1][j];
                    }
                    if (j - num[i] >= 0) {
                        dp[i][j-num[i]] += dp[i-1][j];
                    }
                }
            }
        }

        System.out.println(dp[n-2][result]);
    }

}
