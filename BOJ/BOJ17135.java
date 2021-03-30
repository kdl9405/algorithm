package BOJ;

import java.io.*;
import java.util.*;

/* 
    캐슬 디펜스

*/
public class BOJ17135 {

    static int N, M, D;
    static int[][] map;
    static int[][] testMap;
    static int max;
    static Queue<int[]> queue;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < M - 2; i++) {
            for (int j = i + 1; j < M - 1; j++) {
                for (int k = j + 1; k < M; k++) {
                    initMap();
                    queue = new LinkedList<>();

                    int count = 0;

                    for (int r = N - 1; r >= 0; r--) {
                        simulation(r, i);
                        simulation(r, j);
                        simulation(r, k);

                        while (!queue.isEmpty()) {
                            int[] e = queue.poll();
                            if (testMap[e[0]][e[1]] == 1) {
                                count++;
                                testMap[e[0]][e[1]] = 0;
                            }
                        }

                    }
                    max = Math.max(max, count);

                }
            }
        }
        System.out.println(max);

    }

    static void initMap() {
        testMap = new int[N][N];

        for (int i = 0; i < N; i++) {
            testMap[i] = map[i].clone();
        }
    }

    static void simulation(int r, int c) {

        for (int d = 1; d <= D; d++) {

            int nr = r;
            int nc = c - d + 1;
            for (; nc <= c; nc++) {
                if (nc >= 0 && nc < M && nr < N && nr >= 0) {
                    if (testMap[nr][nc] == 1) {
                        queue.add(new int[] { nr, nc });
                        return;
                    }
                }
                nr--;
            }

            nr++;
            for (; nc <= c + d - 1; nc++) {
                nr++;
                if (nc >= 0 && nc < M && nr < N && nr >= 0) {
                    if (testMap[nr][nc] == 1) {
                        queue.add(new int[] { nr, nc });
                        return;
                    }
                }
            }

        }

        return;

    }

}
