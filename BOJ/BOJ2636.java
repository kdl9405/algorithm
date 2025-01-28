package boj;

import java.io.*;
import java.util.*;

/*
 * 치즈
 * 
 * 1. 0이면 이동가능 -> 이동하면서 주위가 1인걸 저장 2. 1인걸 0으로 바꾸고 거기서부터 이동
 * 
 */
public class BOJ2636 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        map = new int[r][c];

        for (int i = 0; i < r; i++) {
            map[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        visit = new boolean[r][c];
        queue = new LinkedList<>();
        queue.add(new int[] {0, 0});
        check(0, 0);

        int time = 0;
        int count = 0;

        while (!queue.isEmpty()) {

            int size = queue.size();

            count = 0;

            for (int[] now : queue) {
                if (map[now[0]][now[1]] == 1) {
                    map[now[0]][now[1]] = 0;
                    count++;
                }
            }


            while (size-- > 0) {
                int[] now = queue.poll();

                if (visit[now[0]][now[1]]) {
                    continue;
                }

                check(now[0], now[1]);
            }


            time++;

        }

        System.out.println(time);
        System.out.println(count);

    }

    static int r, c;
    static int[][] map;
    static boolean[][] visit;
    static Queue<int[]> queue;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};

    static void check(int x, int y) {

        if (visit[x][y]) {
            return;
        }
        visit[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || nx >= r || ny < 0 || ny >= c || visit[nx][ny]) {
                continue;
            }

            if (map[nx][ny] == 0) {
                check(nx, ny);
            } else {
                queue.add(new int[] {nx, ny});
            }

        }
    }

}
