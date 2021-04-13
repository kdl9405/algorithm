package BOJ;

import java.util.*;
import java.io.*;

/* 
    호텔
*/
public class BOJ1106 {

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int c = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        int[] dp = new int[c+101]; // i명의 고객을 늘릴 때의 최소값
        Arrays.fill(dp, 200000);
        dp[0] = 0;

        while (n-- > 0) {
            st = new StringTokenizer(br.readLine());
            int cost = Integer.parseInt(st.nextToken());
            int customer = Integer.parseInt(st.nextToken());

            for (int i = customer; i < c+101; i++) {

                dp[i] = Math.min(dp[i], dp[i - customer] + cost);

            }
        }
       
        int min = Integer.MAX_VALUE;
        for (int i = c; i <c+101; i++) {
            min = Math.min(min, dp[i]);
        }

        System.out.println(min);

    }
}
