package boj;

import java.io.*;
import java.util.*;

public class BOJ21736 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new char[N][M];
        visited = new boolean[N][M];

        int x = -1, y = -1;

        for (int i = 0; i < N; i++) {
            map[i] = br.readLine().toCharArray();

            if (x == -1) {
                for (int j = 0; j < M; j++) {
                    if (map[i][j] == 'I') {
                        x = i;
                        y = j;
                    }
                }
            }
        }

        findFriendV2(x, y);

        System.out.println(meetCount == 0 ? "TT" : meetCount);
    }

    static int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    static int N, M;
    static char[][] map;
    static boolean[][] visited;
    static int meetCount = 0;


    static void findFriendV2(int x, int y) {
        Queue<int[]> queue = new ArrayDeque<int[]>();
        queue.add(new int[] {x, y});
        visited[x][y] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();

            if (map[current[0]][current[1]] == 'P')
                meetCount++;

            for (int[] d : dir) {
                int nx = current[0] + d[0];
                int ny = current[1] + d[1];

                if (nx >= 0 && nx < N && ny >= 0 && ny < M && map[nx][ny] != 'X'
                        && !visited[nx][ny]) {
                    queue.add(new int[] {nx, ny});
                    visited[nx][ny] = true;
                }
            }
        }
    }

    static void findFriend(int x, int y) {

        if (visited[x][y])
            return;
        visited[x][y] = true;

        if (map[x][y] == 'P') {
            meetCount++;
        }

        for (int[] d : dir) {

            int nx = x + d[0];
            int ny = y + d[1];

            if (nx >= 0 && nx < N && ny >= 0 && ny < M && map[nx][ny] != 'X' && !visited[nx][ny]) {
                findFriend(nx, ny);
            }
        }
    }

}
