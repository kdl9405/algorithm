package BOJ;

import java.io.*;
import java.util.*;

/* 
    꿈틀꿈틀 호석 애벌레 - 효율성
*/

public class BOJ20181 {
    
    public static void main(String[] args) throws IOException {
             
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        arr = new int[n+1];

        st = new StringTokenizer(br.readLine());
        for(int i = 1; i<=n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dp = new long[n+1];

        int j = 0;
        long sum = 0;
        long e = 0;
        
        for(int i = 1; i<=n; i++){
            
            while (j<n && sum < k) {
                j++;
                sum += arr[j];                
            }
            
            long t = sum - k;
            if (t < 0) {
                t = 0;
            }

            dp[j] = Math.max(dp[j], e + t);
            sum-= arr[i];
            e = Math.max(e, dp[i]);
        }

        System.out.println(e);
    }

    static int[] arr;
    static long[] dp;

}