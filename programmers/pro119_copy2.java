package programmers;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

/* 
2017 카카오코드 본선
GPS

dp[i][j] = i번째 경로가 j가 맞을 때 i번째 경로까지 최소 수정값

    down-top
 */

public class pro119_copy2 {

    public static void main(String[] args) {

        int n = 7;
        int m = 10;
        int[][] edge_list = { { 1, 2 }, { 1, 3 }, { 2, 3 }, { 2, 4 }, { 3, 4 }, { 3, 5 }, { 4, 6 }, { 5, 6 }, { 5, 7 },
                { 6, 7 } };
        int k = 6;
        int[] gps_log = { 1, 2, 1, 4, 7, 7 };

        System.out.println(solution(n, m, edge_list, k, gps_log));

    }

    static int solution(int n, int m, int[][] edge_list, int k, int[] gps_log) {

        int answer = 0;

        road = new boolean[n+1][n+1];
        for(int i = 0; i<m; i++){
            road[edge_list[i][0]][edge_list[i][1]] = true;
            road[edge_list[i][1]][edge_list[i][0]] = true;            
        }
        for(int i = 1; i<=n; i++){
            road[i][i] = true;
        }

        hash = new HashMap<>();

        for(int i = 0; i<=n; i++){
            HashSet<Integer> set = new HashSet<>();
            for(int j = 0; j<=n ;j++){
                if (road[i][j]) {
                    set.add(j);
                }
            }
            hash.put(i, set);
        }

        dp = new int[k][n+1];
        for(int i = 0; i<k; i++){
            Arrays.fill(dp[i], 10000);
        }
        dp[0][gps_log[0]] = 0;
        
        for(int i = 1; i<k; i++){
            for(int j = 1; j<=n; j++){
              //  dp[i][j] = Math.min(dp[i][j], dp[i-1][j]);

                HashSet<Integer> temp = hash.get(j);

                for(int x : temp){
                    dp[i][j] = Math.min(dp[i][j], dp[i-1][x]);
                }
                if (gps_log[i] != j) {
                    dp[i][j]+=1;
                }
            }
        }

        if (dp[k-1][gps_log[k-1]] >= 10000) {
            answer = -1;
        }else{
            answer = dp[k-1][gps_log[k-1]];
        }
       
        return answer;
    }

    static int[][] dp;
    static boolean[][] road;
    static HashMap<Integer, HashSet<Integer>> hash;

    
}
