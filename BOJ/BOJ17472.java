package boj;

/*
 * 다리 만들기 2
 * 
 */

import java.io.*;
import java.util.*;

public class BOJ17472 {

    public static void main(String[] args) throws IOException {

        input();

        defindLand();

        searchBridge();

        int answer = minBridges();

        System.out.println(answer);

    }

    static int N, M, land;
    static int[][] map;
    static boolean[][] visit;
    static int[][] move = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    static List<int[]> bridge;
    static int[] group;

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }

    static void defindLand() {
        int idx = 1;
        visit = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 1 && !visit[i][j]) {
                    dfsForDefine(i, j, idx);
                    idx++;
                }
            }
        }

        land = idx - 1;
    }

    static void dfsForDefine(int i, int j, int idx) {
        map[i][j] = idx;
        visit[i][j] = true;

        for (int d = 0; d < 4; d++) {
            int x = i + move[d][0];
            int y = j + move[d][1];

            if (x < 0 || x >= N || y < 0 || y >= M) {
                continue;
            }

            if (visit[x][y] || map[x][y] != 1) {
                continue;
            }

            dfsForDefine(x, y, idx);
        }
    }

    static void searchBridge() {

        bridge = new ArrayList<>();

        Queue<int[]> queue = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] != 0) {
                    queue.add(new int[] {i, j, map[i][j]});
                }
            }
        }

        while (!queue.isEmpty()) {

            int[] now = queue.poll();

            for (int i = 0; i < 4; i++) {
                int x = now[0] + move[i][0];
                int y = now[1] + move[i][1];

                int count = 0;
                while (true) {
                    if (x < 0 || x >= N || y < 0 || y >= M || map[x][y] == now[2]) {
                        break;
                    }

                    if (map[x][y] > now[2]) {
                        if (count >= 2) {
                            bridge.add(new int[] {now[2], map[x][y], count});
                        }
                        break;
                    }

                    x += move[i][0];
                    y += move[i][1];
                    count++;

                }

            }

        }

    }

    static int minBridges() {
        int distance = 0;
        group = new int[land + 1];

        Collections.sort(bridge, (a, b) -> {
            return a[2] - b[2];
        });

        int count = 0;

        for (int[] b : bridge) {

            int x = findGroup(b[0]);
            int y = findGroup(b[1]);

            if (x == y) {
                continue;
            }

            distance += b[2];
            group[y] = x;
            count++;

            if (count == land - 1) {
                return distance;
            }
        }
        return -1;

    }

    static int findGroup(int x) {
        if (group[x] == 0) {
            return x;
        }

        return group[x] = findGroup(group[x]);
    }

}
