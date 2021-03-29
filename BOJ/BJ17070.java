package BOJ;

import java.io.*;
import java.util.*;

/* 
    파이프 옮기기 1

*/
public class BJ17070 {
    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        int[][] map = new int[N + 1][N + 1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 1; j <= N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][][] dp = new int[N + 1][N + 1][3]; // 0 = 가로일때, 1 = 세로일때, 2 = 대각선일때
        dp[1][2][0] = 1;

        for (int i = 1; i <= N; i++) {
            for (int j = 2; j <= N; j++) {
                if (map[i][j] == 0) {

                    dp[i][j][0] += (dp[i][j - 1][0] + dp[i][j - 1][2]); // 이동 후 가로가 됨

                    if (i>1) {
                        dp[i][j][1] += (dp[i - 1][j][1] + dp[i - 1][j][2]); // 이동 후 세로가 됨

                        if (map[i-1][j] == 0 && map[i][j-1] == 0){
                            dp[i][j][2] += (dp[i-1][j-1][0] + dp[i-1][j-1][1] + dp[i-1][j-1][2]);
                        }
                    }
                }
            }
        }

        int count = dp[N][N][0] + dp[N][N][1] +dp[N][N][2];

        System.out.println(count);

    }
}
