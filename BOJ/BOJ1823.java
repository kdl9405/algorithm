package BOJ;

import java.io.*;

/* 
    수확 
*/

public class BOJ1823 {

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        arr = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        dp = new int[n+1][n+1];

        System.out.println(findDP(1, n));
       
    }

    static int n;
    static int[] arr;   
    static int[][] dp; // i에서 j범위의 벼가 남았을 때의 최대 가치

    static int findDP(int start, int end){
        
        if (start > end) { // 모두 수확한 경우
            return 0;
        }

        if (dp[start][end] != 0) { // 이미 계산된 최대 가치가 존재하는 경우
            return dp[start][end];
        }

        int index = n-(end-start); // 현재 수확 순서

        // Start~End 벼가 있을 때의 최대가치 
        //              = Max(왼쪽 벼를 수확했을 때 X 왼쪽 벼의 수확가치, 오른쪽 벼를 수확했을 때 X 오른쪽 벼의 수확가치)   
        dp[start][end] = Math.max(findDP(start+1, end)+(arr[start]*index), findDP(start, end-1)+(arr[end]*index));

        return dp[start][end];
    }
}
