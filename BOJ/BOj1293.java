package BOJ;

/* 
    이친수
*/

import java.io.*;

public class BOj1293 {

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        dp = new long[N+1];

        System.out.println(pinaryNum(N));

    }

    static long[] dp;

    static long pinaryNum(int n) {
        if (n <= 2) {
            return 1;
        }

        if (dp[n] != 0) {
            return dp[n];
        }

        return dp[n] = pinaryNum(n - 2) + pinaryNum(n - 1);
    }
}

// 1

// 10

// 100
// 101

// 1000
// 1001
// 1010

// 10000
// 10001
// 10010
// 10100
// 10101

// 100000
// 100001
// 100010
// 100100
// 100101
// 101000
// 101001
// 101010
