package BOJ;

import java.io.*;
import java.util.*;

/* 
    알파벳 

    dfs (비트마스크) - 868ms
*/
public class BOJ1987 {

    static int count, R, C;
    static char[][] board;
    static int[][] visit;
    static int[][] direction = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        board = new char[R][C];
        for (int i = 0; i < R; i++) {
            board[i] = br.readLine().toCharArray();
        }

        visit = new int[R][C];

        count = 0;

        dfs(0, 0, 1 << board[0][0] - 'A', 1);

        System.out.println(count);
    }

    static void dfs(int r, int c, int bit, int d) {

        if (visit[r][c] == bit) {
            return;
        }

        visit[r][c] = bit;

        count = Math.max(count, d);

        for (int i = 0; i < 4; i++) {
            int nr = r + direction[i][0];
            int nc = c + direction[i][1];

            if (nr < 0 || nr >= R || nc < 0 || nc >= C || (bit & 1 << board[nr][nc] - 'A') != 0) {               
                continue;
            }
            dfs(nr, nc, bit | 1 << board[nr][nc] - 'A', d + 1);
        }
    }
}
