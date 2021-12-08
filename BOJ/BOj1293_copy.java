package BOJ;

/* 
    이친수
*/

import java.io.*;

public class BOj1293_copy {

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        if (N <= 2) {
            System.out.println(1);
        } else {

            long[] dp = new long[N + 1];

            dp[1] = 1;
            dp[2] = 1;

            for (int i = 3; i <= N; i++) {
                dp[i] = dp[i - 2] + dp[i - 1];
            }

            System.out.println(dp[N]);
        }

    }

}
