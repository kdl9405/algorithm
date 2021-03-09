package BJ;

import java.io.*;
import java.util.StringTokenizer;

/* 
    퇴사
*/

public class BJ14501 {
    
    public static void main(String[] args) throws NumberFormatException, IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        arr = new int[n+2][2];

        for(int i = 1; i<=n; i++){
            st = new StringTokenizer(br.readLine());

            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        dp = new int[n+6];

        int sum = 0;
        for(int i = 1; i<=n+1; i++){
            dp[i] = Math.max(dp[i], sum);

            dp[arr[i][0]+ i] = Math.max(dp[arr[i][0]+ i], dp[i]+arr[i][1]);

            sum = Math.max(dp[i], sum);
        }

        System.out.println(sum);

    }

    static int[][] arr;
    static int[] dp; // dp[i] = i일까지의 최대 금액 (i)
}
