package boj;

import java.io.*;
import java.util.*;

/*
 * 테트로미노
 */

public class BOJ14500 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visit = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            map[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        arr = new int[4];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                visit[i][j] = true;
                arr[0] = map[i][j];
                dfs(i, j, 1);
                check(i, j);
            }
        }

        System.out.println(max);

    }

    static int N, M;
    static int[][] map;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int[] arr;
    static int max = 0;
    static boolean[][] visit;

    static void dfs(int x, int y, int d) {
        if (d == 4) {
            int sum = 0;
            for (int a : arr) {
                sum += a;
            }
            max = Math.max(max, sum);
            return;
        }

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && nx < N && ny >= 0 && ny < M) {
                if (!visit[nx][ny]) {
                    visit[nx][ny] = true;
                    arr[d] = map[nx][ny];
                    dfs(nx, ny, d + 1);
                    visit[nx][ny] = false;

                }
            }
        }

        return;
    }

    static void check(int x, int y) {

        if (x < N - 2) {
            if (y < M - 1) {
                int sum = 0;
                sum += (map[x][y] + map[x + 1][y] + map[x + 1][y + 1] + map[x + 2][y]);
                max = Math.max(max, sum);
            }
            if (y > 0) {
                int sum = 0;
                sum += (map[x][y] + map[x + 1][y] + map[x + 1][y - 1] + map[x + 2][y]);
                max = Math.max(max, sum);
            }
        }

        if (y < M - 2) {
            if (x < N - 1) {
                int sum = 0;
                sum += (map[x][y] + map[x][y + 1] + map[x + 1][y + 1] + map[x][y + 2]);
                max = Math.max(max, sum);
            }
            if (x > 0) {
                int sum = 0;
                sum += (map[x][y] + map[x][y + 1] + map[x - 1][y + 1] + map[x][y + 2]);
                max = Math.max(max, sum);
            }
        }

        return;
    }
}
