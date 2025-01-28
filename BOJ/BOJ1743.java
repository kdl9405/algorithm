package boj;

/*
 * 음식물 피하기
 */

import java.io.*;
import java.util.*;

public class BOJ1743 {

    public static void main(String[] args) throws IOException {

        new BOJ1743().solution();

    }

    int N, M;
    boolean[][] isTrash;
    int[][] move = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    int max;

    void solution() throws IOException {

        init();

        for (int r = 1; r <= N; r++) {
            for (int c = 1; c <= M; c++) {
                if (isTrash[r][c]) {
                    max = Math.max(max, dfs(r, c));
                    System.out.println(r + " " + c + " " + max);
                }
            }
        }

        System.out.println(max);

    }

    void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        isTrash = new boolean[N + 1][M + 1];
        while (K-- > 0) {
            st = new StringTokenizer(br.readLine());
            isTrash[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = true;
        }

        max = 0;
    }

    int dfs(int r, int c) {

        isTrash[r][c] = false;
        int cnt = 1;
        for (int i = 0; i < 4; i++) {
            int nr = r + move[i][0];
            int nc = c + move[i][1];

            if (nr <= 0 || nr > N || nc <= 0 || nc > M || !isTrash[nr][nc]) {
                continue;
            }

            cnt += dfs(nr, nc);
        }

        return cnt;
    }

}
