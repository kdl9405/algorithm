package softeer;

import java.util.*;
import java.io.*;

public class three {

    public static void main(String args[]) throws IOException

    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
                
        K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        workTime = new int[N+1][K+1]; // n번째 작업이 K작업장에서 수행되는 시간
        moveTime = new int[N+1][K+1][K+1]; // n번째에서 n+1번째로 작업을  i작업장에서 j작업장으로 전달하는 시간
        
        for(int i = 1; i<N; i++){
                st = new StringTokenizer(br.readLine());
                for(int j = 1; j<=K; j++){
                        workTime[i][j] = Integer.parseInt(st.nextToken());
                }
                for(int j = 1; j<=K; j++){
                        for(int k = 1; k<=K; k++){
                                if(j != k){
                                        moveTime[i][j][k] = Integer.parseInt(st.nextToken());
                                }
                        }
                }
        }

        st = new StringTokenizer(br.readLine());
        for(int i = 1; i<=K; i++){
                workTime[N][i] = Integer.parseInt(st.nextToken());
        }

        int min = Integer.MAX_VALUE;
        dp = new int[N+1][K+1];
        for(int i = 1; i<=K; i++){
                min = Math.min(min, findDP(N,i));
        }

        System.out.println(min);
               
    }

    static int K;
    static int[][] workTime;
    static int[][][] moveTime;
    static int[][] dp;

    static int findDP(int n, int k){


            if(n == 0){
                    return 0;
            }
        
            if(dp[n][k] != 0){
                    return dp[n][k];
            }

            dp[n][k] = findDP(n-1,k); 

            for(int i = 1; i<=K; i++){
                    if(i == K){
                            continue;
                    }
                    dp[n][k] = Math.min(dp[n][k], findDP(n-1,i)+moveTime[n-1][i][k]);
            }

            dp[n][k] += workTime[n][k];

            return dp[n][k];
    }
}