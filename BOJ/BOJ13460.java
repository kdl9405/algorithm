package BOJ;

/* 
    구슬 탈출 2

    1. 완전탐색으로 10번동안 상하좌우 이동의 경우를 모두 구함. 4^10
    2. 빨간 구슬과 파란구슬의 이동 경로가 겹친다면, 먼저 이동해야 하는 것부터 이동..
    3. 각 구슬 이동 경로 중, 구멍이 있으면 break.

*/

import java.io.*;
import java.util.*;

public class BOJ13460 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        board = new char[N][M];

        int[] ball = new int[4];

        for (int i = 0; i < N; i++) {
            char[] line = br.readLine().toCharArray();
            for (int j = 0; j < M; j++) {
                board[i][j] = line[j];
                if (line[j] == 'R') {
                    ball[0] = i;
                    ball[1] = j;
                } else if (line[j] == 'B') {
                    ball[2] = i;
                    ball[3] = j;
                }
            }
        }

        

    }

    static int N, M;
    static char[][] board;
    static int[] dx = { 1, -1, 0, 0 };
    static int[] dy = { 0, 0, -1, 1 };
    static boolean[] check;

    static int[] move(int x, int y, int d, int xx, int yy, int color) {

        while (true) {

            if (board[x][y] == 'O') {
                check[color] = true;
                break;
            }

            if (board[x][y] == '#') {
                x -= dx[d];
                y -= dy[d];
                break;
            }

            if ((x == xx && y == yy)) {
                x -= dx[d];
                y -= dy[d];
                break;
            }

            x += dx[d];
            y += dy[d];

        }

        return new int[] { x, y };
    }

    static void dfs(int rx, int ry, int bx, int by, int count){

        if (count>10) {
            return;
        }

        for(int i = 0; i<4; i++){

            
        }

    }
}
