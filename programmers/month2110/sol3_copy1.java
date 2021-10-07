package programmers.month2110;

import java.util.*;

/* 
    될거 같은뎅에ㅔ에
*/

public class sol3_copy1 {

    public static void main(String[] args) {

        int n = 2;
        int m = 2;
        int x = 0;
        int y = 0;

        int[][] queries = { { 2, 1 }, { 0, 1 }, { 1, 1 }, { 0, 1 }, { 2, 1 } };

        System.out.println(solution(n, m, x, y, queries));

    }

    public static long solution(int n, int m, int x, int y, int[][] queries) {

        long answer = 0;

        query = new ArrayList<>();

        for (int[] q : queries) {
            for (int i = 0; i < q[1]; i++) {
                query.add(q[0]);
            }
        }

        N = n;
        M = m;

        dp = new long[query.size()][n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int nx = i;
                int ny = j;

                switch (queries[0][0]) {
                    case 0:
                        ny--;

                        break;

                    case 1:

                        ny++;

                        break;
                    case 2:

                        nx--;

                        break;
                    case 3:

                        nx++;

                        break;
                }

                nx = (nx + n) % n;
                ny = (ny + m) % m;

                dp[0][nx][ny]++;
            }
        }

        return answer = findDP(query.size()-1, x, y);
    }

    static int N, M;
    static List<Integer> query;
    static long[][][] dp; // i번째 쿼리를 실행한 후, 해당 좌표에 올수 있는 경우의 수.
    static int[][] d = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

    static long findDP(int q, int x, int y) {


        if (q == 0) {
            return dp[q][x][y];
        }

        if (dp[q][x][y] != 0) {
            return dp[q][x][y];
        }

        System.out.println(q + " " + x + " " + y);


        int nx = x + d[query.get(q)][0];
        int ny = y + d[query.get(q)][1];

        nx = (nx + N) % N;
        ny = (ny + M) % M;

        dp[q][x][y] += findDP(q-1, nx, ny);

        if (x != nx || y != ny) {
            if (x == 0 && query.get(q) == 2) {
                dp[q][x][y] += findDP(q-1, x, y);
            }
    
            if (x == N-1 && query.get(q) == 3) {
                dp[q][x][y] += findDP(q-1, x, y);
            }
    
            if (y == 0 && query.get(q) == 0) {
                dp[q][x][y] += findDP(q-1, x, y);
            }
    
            if (y == M-1 && query.get(q) == 1) {
                dp[q][x][y] += findDP(q-1, x, y);
            }
        }

        return dp[q][x][y];

    }

}
