package BOJ;

/* 
    암호코드
*/

import java.io.*;

public class BOJ2011 {

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String N = br.readLine();

        int[] num = new int[N.length() + 1];
        for (int i = 0; i < N.length(); i++) {
            num[i + 1] = N.charAt(i) - '0';
        }

        int[] dp = new int[N.length() + 1];
        dp[0] = 1;

        for (int i = 1; i <= N.length(); i++) {

            if (num[i] != 0) {
                dp[i] = dp[i-1];
            }

            int x = num[i] + num[i - 1] * 10;

            if (x >= 10 && x <= 26) {
                dp[i] = (dp[i - 2] + dp[i]) % 1000000;
            }

        }
        System.out.println(dp[N.length()]);
    }

}
