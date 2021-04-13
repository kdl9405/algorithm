package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * BOJ12865
 */
public class BOJ12865 {

    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[][] goods = new int[n][2];

        for(int i = 0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            goods[i][0] = Integer.parseInt(st.nextToken());
            goods[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(goods, (g1,g2)->{
            if (g1[0] == g2[0]) {
                return g1[1] - g2[1]; 
            }
            else return g1[0] - g2[0];
        });

        int[] dp = new int[k+1];

        for(int i = 0; i<n; i++){
            for(int j = k; j-goods[i][0] >=0; j--){
                dp[j] = Math.max(dp[j], dp[j-goods[i][0]] + goods[i][1]);
            }
        }

        System.out.println(dp[k]);


    }
}