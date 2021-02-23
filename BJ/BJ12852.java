package BJ;

import java.util.*;

/* 
    1로 만들기 2
    
*/
public class BJ12852 {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();

        dp = new int[n+1];
        dp[1] = 0;

        for(int i = 2; i<=n; i++){
            dp[i] = dp[i-1]+1;

            if (i % 2 == 0) {
                dp[i] = Math.min(dp[i], dp[i/2]+1);
            }

            if (i % 3 == 0) {
                dp[i] = Math.min(dp[i], dp[i/3]+1);
            }
        }

        sb = new StringBuilder();
        sb.append(n).append(" ");
        findRoute(n);
        
        System.out.println(dp[n]);
        System.out.println(sb.toString());

        
    }

    static int[] dp;
    static StringBuilder sb;

    static void findRoute(int n){
        if (n == 1) {
            return;
        }

        int min = n-1;

        if (n % 2 == 0) {
            if (dp[n/2] < dp[min]) {
                min = n/2;
            }
        }
        if (n % 3 == 0) {
            if (dp[n/3] < dp[min]) {
                min = n/3;
            }
        }

        sb.append(min).append(" ");
        findRoute(min);
    }
   
}
