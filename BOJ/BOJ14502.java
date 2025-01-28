package boj;

import java.io.*;
import java.util.*;

/*
 * 연구소
 * 
 * 최적화 필요
 */

public class BOJ14502 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        blank = new ArrayList<>();
        virus = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());

                if (map[i][j] == 0) {
                    blank.add(new point(i, j));
                } else if (map[i][j] == 2) {
                    virus.add(new point(i, j));
                }
            }
        }

        max = 0;

        for (int a = 0; a < blank.size() - 2; a++) {
            point A = blank.get(a);
            map[A.r][A.c] = 1;

            for (int b = a + 1; b < blank.size() - 1; b++) {
                point B = blank.get(b);
                map[B.r][B.c] = 1;

                for (int c = b + 1; c < blank.size(); c++) {
                    point C = blank.get(c);
                    map[C.r][C.c] = 1;

                    infect();

                    map[C.r][C.c] = 0;
                }
                map[B.r][B.c] = 0;
            }
            map[A.r][A.c] = 0;
        }

        System.out.println(max);

    }

    static int n, m, init, max;
    static int[][] map;
    static List<point> blank;
    static List<point> virus;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static void infect() {

        int count = 0;

        boolean[][] visit = new boolean[n][m];

        Queue<point> queue = new LinkedList<>();
        queue.addAll(virus);
        while (!queue.isEmpty()) {
            point v = queue.poll();

            if (visit[v.r][v.c]) {
                continue;
            }
            visit[v.r][v.c] = true;
            if (map[v.r][v.c] == 0) {
                count++;
            }

            for (int i = 0; i < 4; i++) {
                int x = v.r + dx[i];
                int y = v.c + dy[i];

                if (x >= 0 && x < n && y >= 0 && y < m) {

                    if (map[x][y] == 0 && !visit[x][y]) {
                        queue.offer(new point(x, y));
                    }
                }
            }
        }

        max = Math.max(max, blank.size() - 3 - count);
    }
}


class point {
    int r;
    int c;

    public point(int r, int c) {
        this.r = r;
        this.c = c;
    }
}
