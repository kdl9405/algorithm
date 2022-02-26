package BOJ;

/* 
    Generations of Tribbles
*/

import java.io.*;

public class BOJ9507 {

    public static void main(String[] args) throws NumberFormatException, IOException {

        init();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        StringBuilder ansewr = new StringBuilder();
        while (t-- > 0) {
            ansewr.append(findDp(Integer.parseInt(br.readLine()))).append("\n");
        }
        System.out.println(ansewr.toString().trim());
    }

    static long[] dp;

    static void init() {
        dp = new long[68];

        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;
    }

    static long findDp(int n) {

        if (dp[n] != 0) {
            return dp[n];
        }

        return dp[n] = findDp(n - 1) + findDp(n - 2) + findDp(n - 3) + findDp(n - 4);
    }
}
