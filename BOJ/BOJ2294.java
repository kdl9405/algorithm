package BOJ;

import java.io.*;
import java.util.*;

/*  
    동전 2
*/

public class BOJ2294 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] dp = new int[k + 1];
        Arrays.fill(dp, k + 2);
        dp[0] = 0;

        while (n-- > 0) {
            int c = Integer.parseInt(br.readLine());

            for (int i = c; i <= k; i++) {
                dp[i] = Math.min(dp[i], dp[i - c] + 1);
            }
        }

        if (dp[k] == k + 2) {
            System.out.println(-1);
        } else {
            System.out.println(dp[k]);
        }
    }
}
