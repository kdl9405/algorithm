package BOJ;

import java.io.*;
import java.util.*;

/* 
    함께 블록 쌓기 
*/

public class BOJ18427 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());

        ArrayList<ArrayList<Integer>> blocks = new ArrayList<>();

        for (int i = 0; i < n; i++) {

            blocks.add(new ArrayList<>());
            blocks.get(i).add(0);

            st = new StringTokenizer(br.readLine());
            while (st.hasMoreTokens()) {
                blocks.get(i).add(Integer.parseInt(st.nextToken()));
            }
        }

        int[][] dp = new int[n + 1][h + 1]; // i번학생까지 블록을 쌓았을 때, 높이가 j일 경우의 수

        dp[0][0] = 1;
      
        for (int i = 1; i <= n; i++) {
            for (Integer b : blocks.get(i - 1)) {
                for (int j = b; j <= h; j++) {
                    dp[i][j] += dp[i - 1][j - b];
                    dp[i][j] %= 10007;
                }
            }
        }

        System.out.println(dp[n][h]);

    }
}
