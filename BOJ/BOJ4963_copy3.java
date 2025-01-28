package boj;

import java.io.*;
import java.util.*;

/*
 * 섬의 개수
 * 
 */

public class BOJ4963_copy3 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        while (true) {
            st = new StringTokenizer(br.readLine());

            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());

            if (w == 0 && h == 0) {
                break;
            }

            map = new boolean[h + 2][w + 2];

            for (int i = 1; i <= h; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 1; j <= w; j++) {
                    if (Integer.parseInt(st.nextToken()) == 1) {
                        map[i][j] = true;
                    }
                }
            }

            int count = 0;
            for (int i = 1; i <= h; i++) {
                for (int j = 1; j <= w; j++) {
                    if (map[i][j]) {
                        dfs(i, j);
                        count++;
                    }
                }
            }
            sb.append(count).append("\n");

        }
        System.out.println(sb.toString().trim());

    }

    static int w, h;
    static boolean[][] map;
    static int[][] d = {{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};

    static void dfs(int x, int y) {

        map[x][y] = false;

        for (int i = 0; i < 8; i++) {
            int nx = x + d[i][0];
            int ny = y + d[i][1];

            if (map[nx][ny]) {
                dfs(nx, ny);
            }
        }
        return;
    }
}
