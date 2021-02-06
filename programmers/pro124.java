package programmers;

/* 
    보행자 천국

    DP 가능한 경로 수 표기 후 합산
*/

public class pro124 {
    public static void main(String[] args) {

        int m = 3;
        int n = 3;
        int[][] cityMap = {{0, 0, 0}, {0, 0, 0}, {0, 0, 0}};

        System.out.println(solution(m, n, cityMap));

    }

    static int MOD = 20170805;

    static int solution(int m, int n, int[][] cityMap) {
        int answer = 0;

        int[][][] dp = new int[m+1][n+1][2];
        dp[1][1][0] = 1;
        dp[1][1][1] = 1;

        for(int i = 1; i<=m; i++){
            for(int j = 1; j<=n; j++){
                if (cityMap[i-1][j-1] == 1) {
                    dp[i][j][0] = 0;
                    dp[i][j][1] = 0;
                }else if(cityMap[i-1][j-1] == 2){
                    dp[i][j][0] = dp[i][j-1][0];
                    dp[i][j][1] = dp[i-1][j][1];
                }else {
                    dp[i][j][0] += (dp[i-1][j][1] + dp[i][j-1][0]) % MOD;
                    dp[i][j][1] = dp[i][j][0]; 
                }

            }
        }

        answer = dp[m][n][0];
       
        return answer;

    }
    
}
