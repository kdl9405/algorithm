package BJ;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ7579 {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] app = new int[n][n];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i<n; i++){
            app[i][0] = Integer.parseInt(st.nextToken());
        }

        int cost = 0;
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i<n; i++){
            app[i][1] = Integer.parseInt(st.nextToken());
            cost += app[i][1];
        }

        Arrays.sort(app, (a1, a2) ->{
            if (a1[1] == a2[1]) {
                return a2[0] - a1[0];
            }
            return a1[1] - a1[2];
        });

        int[] dp = new int[100001];

        Arrays.fill(dp, -1);

        for(int i = 0; i<n; i++){
            int c = app[i][1];

            for(int j = 10000; j>=c; j--){
                if (dp[j-c] != -1) {
                    if (dp[j-c] + app[i][0] > dp[j]) {
                        dp[j] = dp[j-c] + app[i][0];
                    }
                }
            }

            if (dp[c] < app[i][0]) {
                dp[c] = app[i][0];
            }
        }

        for(int i = 0; i<10001; i++){
            if (dp[i] >= m) {
                System.out.println(i);
                break;
            }
        }
    }
}
