package boj;

import java.io.*;
import java.util.*;

/*
 * 알파벳
 * 
 * dfs (boolean[]) - 868ms
 */
public class BOJ1987_copy2 {

    static int max, R, C;
    static char[][] board;
    static boolean[] visit; // 사용한 알파벳을 boolean값으로 저장
    static int[][] direction = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}}; // 상하좌우 이동

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        board = new char[R][C];
        for (int i = 0; i < R; i++) {
            board[i] = br.readLine().toCharArray();
        }

        visit = new boolean[26]; // 알파벳의 수만큼 할당
        visit[board[0][0] - 'A'] = true; // 시작 칸의 알파벳을 체크

        max = 0;

        dfs(0, 0, 1); // 줄, 칸, 이동거리

        System.out.println(max);
    }

    static void dfs(int r, int c, int d) {

        for (int i = 0; i < 4; i++) {
            int nr = r + direction[i][0];
            int nc = c + direction[i][1];

            if (nr >= 0 && nr < R && nc >= 0 && nc < C) { // 다음 이동 칸이 범위 안에 있다면
                if (!visit[board[nr][nc] - 'A']) { // 이미 사용된 알파벳이 아니라면
                    visit[board[nr][nc] - 'A'] = true;
                    dfs(nr, nc, d + 1); // 거리를 추가하고 dfs 진행
                    visit[board[nr][nc] - 'A'] = false;
                }
            }
        }
        max = Math.max(max, d); // 이동거리 갱신
    }
}
