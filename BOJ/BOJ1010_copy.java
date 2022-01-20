package BOJ;

import java.util.*;
import java.io.*;

/* 
    다리 놓기
*/
public class BOJ1010_copy {

    public static void main(String[] args) throws NumberFormatException, IOException {

        new BOJ1010_copy().solution();
    }

    private void solution() throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder answer = new StringBuilder();
        
        int T = Integer.parseInt(br.readLine());
        dp = new int[30][30];
        

        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            answer.append(findDP(N, M)).append("\n");

        }

        System.out.println(answer.toString().trim());

    }

    int[][] dp;

    int findDP(int l, int r) {
        if (l == 0 || l == r) {
            return 1;
        }

        if (dp[l][r] != 0) {
            return dp[l][r];
        }

        for(int i = r-1; i>=l-1; i--){
            dp[l][r] += findDP(l-1, i);
        }

        return dp[l][r];
    }

}
