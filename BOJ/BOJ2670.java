package BOJ;
/* 
    연속부분최대곱
*/

import java.io.*;

public class BOJ2670 {

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        double[] num = new double[N + 1];
        double[] dp = new double[N + 1];

        dp[0] = 1;
        double max = 0;

        for (int i = 1; i <= N; i++) {
            num[i] = Double.parseDouble(br.readLine());
            dp[i] = Math.max(num[i], dp[i - 1] * num[i]);
            max = Math.max(max, dp[i]);
        }

        System.out.println(String.format("%.3f", max));

    }
}
