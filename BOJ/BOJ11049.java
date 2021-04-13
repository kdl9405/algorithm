package BOJ;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ11049 {

    static int[][] arr;
    static int[][] dp;
    static int[][] point;
    
    public static void main(String[] args)throws IOException{
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        arr = new int[n][2];

        for(int i = 0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        dp = new int[n][n];

        for(int[] d: dp){
            Arrays.fill(d, Integer.MAX_VALUE);
        }

        System.out.println(calDP(0, n-1));


    }

    static int calDP(int x, int y){
        if (x == y) {
            return 0;
        }
        if (y - x ==1) {
           return arr[x][0] * arr[x][1] * arr[y][1];
        }

        if (dp[x][y] != Integer.MAX_VALUE ) {
            return dp[x][y];
        }

        for(int i = x; i<y; i++){
            int temp = calDP(x, i) + calDP(i+1, y) + (arr[x][0] * arr[i][1] * arr[y][1]);
            dp[x][y] = Math.min(dp[x][y], temp);
        }

        return dp[x][y];
    }
}
