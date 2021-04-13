package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
    1, 2, 3 더하기
*/
public class BOJ9095 {

    public static void main(String[] args) throws NumberFormatException, IOException {
        
        dp = new int[12];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i<t; i++){
            int n = Integer.parseInt(br.readLine());
            sb.append(findDP(n)).append("\n");
        }

        System.out.println(sb.toString());
        
    }

    static int[] dp;

    static int findDP(int n){
        if (n <= 3) {
            return dp[n];
        }

        if (dp[n] != 0) {
            return dp[n];
        }

        dp[n] = findDP(n-1) + findDP(n-2) + findDP(n-3);

        return dp[n];
    }
}
