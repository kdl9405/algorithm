package BOJ;

import java.io.*;
import java.util.*;

/* 
    퇴사 2
*/

public class BOJ15486 {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        int[][] arr = new int[n + 2][2];

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[n + 2];
        int sum = 0;

        for (int i = 1; i <= n+1; i++) {
            dp[i] = Math.max(dp[i], sum);

            if (arr[i][0] + i <= n+1) {
                dp[arr[i][0] + i] = Math.max(dp[arr[i][0] + i], arr[i][1] + dp[i]);
            }

            sum = Math.max(sum, dp[i]);
        }

        System.out.println(sum);
    }

}
