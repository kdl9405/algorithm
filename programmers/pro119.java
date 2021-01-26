package programmers;

/* 
2017 카카오코드 본선
GPS

dp[i][j] = i번째 경로가 j일때 i번째 경로까지 최소 수정값


 */

// 시간초과

public class pro119 {

    public static void main(String[] args) {

        int n = 7;
        int m = 10;
        int[][] edge_list = { { 1, 2 }, { 1, 3 }, { 2, 3 }, { 2, 4 }, { 3, 4 }, { 3, 5 }, { 4, 6 }, { 5, 6 }, { 5, 7 },
                { 6, 7 } };
        int k = 6;
        int[] gps_log = { 1, 2, 4, 6, 5, 7 };

        System.out.println(solution(n, m, edge_list, k, gps_log));

    }

    static int solution(int n, int m, int[][] edge_list, int k, int[] gps_log) {

        int answer = 0;

        boolean[][] road = new boolean[n + 1][n + 1];

        for (int i = 0; i < m; i++) {
            road[edge_list[i][0]][edge_list[i][1]] = true;
            road[edge_list[i][1]][edge_list[i][0]] = true;
        }

        int[][] dp = new int[k][n + 1];

        for (int i = 0; i < k; i++) {
            for (int j = 0; j <= n; j++) {
                dp[i][j] = 1000;
            }
        }
        dp[0][gps_log[0]] = 0;

        for (int i = 1; i < k; i++) {
            for (int j = 1; j <= n; j++) {
                if (road[gps_log[i-1]][j] && gps_log[i] == j) {
                    dp[i][j] = dp[i-1][]
                }
            }
        }

        if (dp[k - 1][gps_log[k - 1]] == 1000) {
            answer = -1;
        } else {
            answer = dp[k - 1][gps_log[k - 1]];
        }


        for(int i = 0; i<k; i++){
            for(int j = 1; j<=n; j++){
                // System.out.print(i+" "+j +"  = ");
                System.out.print(dp[i][j]+" ");
            }
            System.out.println(" ");
           
        }

        return answer;
    }
}
