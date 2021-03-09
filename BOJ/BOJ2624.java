package BJ;

import java.io.*;
import java.util.*;

/* 
    동전 바꿔주기
*/
public class BJ2624 {
    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());

        int[][] coins = new int[k+1][2];

        for (int i = 1; i <=k; i++) {
            st = new StringTokenizer(br.readLine());
            coins[i][0] = Integer.parseInt(st.nextToken());
            coins[i][1] = Integer.parseInt(st.nextToken());
        }


        int[][] dp = new int[k+1][t + 1];
        dp[0][0] = 1;

        for(int i = 1; i<=k; i++){
            for(int j = 0; j<=coins[i][1]; j++){
                for(int x = 0; x<=t; x++){
                    if (coins[i][0]*j+x > t) {
                        break;
                    }
                    dp[i][coins[i][0]*j+x] += dp[i-1][x];
                }
            }
        }

        System.out.println(dp[k][t]);

    }

}
