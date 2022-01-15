package BOJ;

/**
    상자넣기
 */

import java.io.*;
import java.util.*;

public class BOJ1965 {

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int[] box = new int[n];

        st = new StringTokenizer(br.readLine());

        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            box[i] = Integer.parseInt(st.nextToken());
            dp[i] = 1;
        }

        int max = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (box[j] < box[i] && dp[j] + 1 > dp[i]) {
                    dp[i] = dp[j] + 1;
                }
            }
            max = Math.max(max, dp[i]);

        }

        System.out.println(max);

    }

}