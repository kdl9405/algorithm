package boj;

import java.io.*;
import java.util.*;

/*
 * 수도배관공사
 */

public class BOJ2072 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int d = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());

        int[][] pipe = new int[p][2];
        for (int i = 0; i < p; i++) {
            st = new StringTokenizer(br.readLine());
            pipe[i][0] = Integer.parseInt(st.nextToken());
            pipe[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(pipe, (p1, p2) -> {
            if (p1[1] == p2[1]) {
                return p2[0] - p1[0];
            }
            return p2[1] - p1[1];
        });

        System.out.println("---------------");
        for (int[] pi : pipe) {
            System.out.println(pi[0] + " " + pi[1]);
        }

        int[] dp = new int[1000001]; // i길이의 파이프를 만들때의 최대 용량
        dp[0] = Integer.MAX_VALUE;

        for (int[] pi : pipe) {
            for (int i = d; i >= 0; i--) {
                int x = i + pi[0];
                if (x > d) {
                    continue;
                }
                dp[x] = Math.max(dp[x], Math.min(pi[1], dp[i]));
            }
        }

        System.out.println(dp[d]);

    }
}
