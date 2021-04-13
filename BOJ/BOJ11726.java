package BOJ;

import java.util.Scanner;

/* 
    2×n 타일링

*/
public class BOJ11726 {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());

        dp = new int[n+1];

        System.out.println(findDP(n));

    }

    static int[] dp;

    static int findDP(int n){
        if (n <= 2) {
            return n;
        }

        if (dp[n] != 0) {
            return dp[n];
        }

        dp[n] = (findDP(n-1) + findDP(n-2))%10007;

        return dp[n];
    }

}
