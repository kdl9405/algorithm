package BOJ;

import java.io.*;
import java.util.*;

/* 
    받아쓰기 
*/

public class BOJ20542 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        String answer = br.readLine();
        String correct = br.readLine();

        int[][] dp = new int[n + 1][m + 1];

        for (int i = 1; i <= n; i++) {
            dp[i][0] = i;
        }
        for (int i = 1; i <= m; i++) {
            dp[0][i] = i;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                
                if (checkEqual(answer.charAt(i-1), correct.charAt(j-1))) {
                    dp[i][j] = dp[i-1][j-1];
                }else{
                    dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i][j - 1], dp[i-1][j]))+1;
                }
            }         
        }

        System.out.println(dp[n][m]);

    }

    static boolean checkEqual(char a, char c){

        if (a == c) {
            return true;
        }

        if (a == 'i') {
            if (c == 'j' || c=='l') {
                return true;
            }
        }

        if (a == 'v') {
            if (c == 'w') {
                return true;
            }
        }

        return false;
    }
}
