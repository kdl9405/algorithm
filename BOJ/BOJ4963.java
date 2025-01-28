package boj;

import java.io.*;
import java.util.*;

/*
 * 섬의 개수
 * 
 */

public class BOJ4963 {

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

            map = new int[h + 2][w + 2];

            for (int i = 1; i <= h; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 1; j <= w; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int count = 0;
            for (int i = 1; i <= h; i++) {
                for (int j = 1; j <= w; j++) {
                    if (map[i][j] == 1) {
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
    static int[][] map;
    static int[][] d = {{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};

    static void dfs(int x, int y) {

        map[x][y] = 0;

        for (int i = 0; i < 8; i++) {
            int nx = x + d[i][0];
            int ny = y + d[i][1];

            if (map[nx][ny] == 1) {
                dfs(nx, ny);
            }

        }

        return;

    }
}
