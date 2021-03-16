package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
    369
*/
public class BJ17614 {
    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        dp = new int[N + 1];

        int count = 0;

        while (N > 2) {

            count += findDP(N);
            N--;
        }

        System.out.println(count);
    }

    static int[] dp;

    static int findDP(int n) {

        if (n < 3) {
            return 0;
        }

        if (dp[n] != 0) {
            return dp[n];
        }

        int count = 0;

        int num = n % 10;
        if (num == 3 || num == 6 || num == 9) {
            count++;
        }
        n /= 10;
        count += findDP(n);

        return dp[n] = count;
    }
}
