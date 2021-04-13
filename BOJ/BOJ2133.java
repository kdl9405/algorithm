package BOJ;

import java.util.Scanner;

/* 
    타일 채우기
*/

public class BOJ2133 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());

        dp = new long[31];
        dp[0] = 1;
        // dp[2] = 3;

        System.out.println(findDP(n));

    }
    static long[] dp;

    static long findDP(int n){

        if (n < 0) {
            return 0;
        }

        if (dp[n] != 0) {
            return dp[n];
        }

        dp[n] = findDP(n-2)*3;

        if (n>=4) {
            for(int i = 0; i<=n-4; i+=2){
                dp[n] += (findDP(i)*2);
            }   
        }
        
        return dp[n];
    }
    
}
