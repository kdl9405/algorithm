package BJ;

import java.io.*;
import java.util.*;

/* 
    로또
*/

public class BJ2758 {

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());

        StringTokenizer st;
        while (t-- > 0) {
            st = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            long[][] dp = new long[n + 1][m + 1]; // n번째에 m이하를 고르는 경우의 수
            Arrays.fill(dp[0], 1);
            for (int i = 1; i <= n; i++) {
                int min = (int)Math.pow(2, (i-1));
                dp[i][min] = 1;
                for (int j = min+1; j <= m; j++) {
                    dp[i][j] = dp[i][j-1] + dp[i-1][j/2];
                }

                // for (int j = 1; j <= m; j++) {
                //     System.out.print(dp[i][j] + " ");
                // }
                // System.out.println();
            }

            sb.append(dp[n][m]).append("\n");
        }

        System.out.println(sb.toString().trim());

    }

}
