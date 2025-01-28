package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * 양
 */
public class BOJ3184 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new char[R][C];

        for (var i = 0; i < R; i++) {
            map[i] = br.readLine().toCharArray();
        }

        visit = new boolean[R][C];
        sheep = 0;
        wolf = 0;

        for (var i = 0; i < R; i++) {
            for (var j = 0; j < C; j++) {
                if (map[i][j] != '#' && !visit[i][j]) {
                    bfs(i, j);
                }
            }
        }

        System.out.println(sheep + " " + wolf);

    }

    static int R, C;
    static char[][] map;
    static boolean[][] visit;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int sheep, wolf;

    static void bfs(int r, int c) {

        var s = 0;
        var w = 0;

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {r, c});
        visit[r][c] = true;
        while (!queue.isEmpty()) {
            int[] now = queue.poll();

            if (map[now[0]][now[1]] == 'o') {
                s++;
            } else if (map[now[0]][now[1]] == 'v') {
                w++;
            }

            for (var i = 0; i < 4; i++) {
                int x = now[0] + dx[i];
                int y = now[1] + dy[i];

                if (x >= 0 && x < R && y >= 0 && y < C) {
                    if (map[x][y] != '#' && !visit[x][y]) {
                        visit[x][y] = true;
                        queue.add(new int[] {x, y});
                    }
                }
            }
        }

        if (s > w) {
            sheep += s;
        } else {
            wolf += w;
        }

        return;
    }

}
