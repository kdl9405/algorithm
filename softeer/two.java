package softeer;

import java.util.*;
import java.io.*;

public class two {

    public static void main(String args[]) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st;

        workTimeA = new int[N+1];
        workTimeB = new int[N+1];
        aToB = new int[N+1];
        bToA = new int[N+1];

        for(int i = 1; i<N; i++){
                st = new StringTokenizer(br.readLine());
                workTimeA[i] = Integer.parseInt(st.nextToken());
                workTimeB[i] = Integer.parseInt(st.nextToken());
                aToB[i] = Integer.parseInt(st.nextToken());
                bToA[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        workTimeA[N] =  Integer.parseInt(st.nextToken());
        workTimeB[N] =  Integer.parseInt(st.nextToken());

        dp = new int[N+1][2];

        int answer = Math.min(findDP(N,0), findDP(N,1));

        System.out.println(answer);

    }

     static int[] workTimeA;
     static int[] workTimeB;
     static int[] aToB;
     static int[] bToA;
     static int[][] dp;

     static int findDP(int n, int line){

             if(n == 0){
                     return 0;
             }

             if(n == 1){
                     if(line == 0){
                             return workTimeA[1];
                     }else{
                             return workTimeB[1];
                     }
             }

             if(dp[n][line] != 0){
                     return dp[n][line];
             }

             if(line  == 0){
                     dp[n][0] = Math.min(findDP(n-1,0), findDP(n-1,1)+bToA[n-1]) + workTimeA[n];
             }else{
                     dp[n][1] = Math.min(findDP(n-1,1), findDP(n-1,0)+aToB[n-1]) + workTimeB[n];
             }

             return dp[n][line];

     }
    
}