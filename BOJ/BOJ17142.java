package boj;

/*
 * 연구소 3
 */

import java.io.*;
import java.util.*;

public class BOJ17142 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        S = 0;
        lab = new int[N][N];
        virus = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                lab[i][j] = Integer.parseInt(st.nextToken());
                if (lab[i][j] == 2) {
                    virus.add(new int[] {i, j});
                } else if (lab[i][j] == 0) {
                    S++;
                }
            }
        }

        if (S == 0) {
            System.out.println(0);
        } else {
            active = new int[M];
            T = -1;
            choiceVirus(0, 0);

            System.out.println(T);
        }

    }

    static int N, M, T, S;
    static int[][] lab;
    static List<int[]> virus;
    static int[] active;
    static int[][] move = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    static void choiceVirus(int index, int depth) {
        if (depth == M) {
            // 시뮬레이션

            simulation();

            return;
        }

        if (index == virus.size()) {
            return;
        }

        active[depth] = index;
        choiceVirus(index + 1, depth + 1);
        choiceVirus(index + 1, depth);
    }

    static void simulation() {

        boolean[][] visit = new boolean[N][N];

        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> {
            return a[2] - b[2];
        });

        for (int i = 0; i < M; i++) {

            int[] v = virus.get(active[i]);
            visit[v[0]][v[1]] = true;
            queue.add(new int[] {v[0], v[1], 0});
        }

        int space = S;

        while (!queue.isEmpty()) {

            int[] v = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = v[0] + move[i][0];
                int ny = v[1] + move[i][1];

                if (nx < 0 || nx >= N || ny < 0 || ny >= N) {
                    continue;
                }
                if (lab[nx][ny] == 1 || visit[nx][ny]) {
                    continue;
                }

                if (lab[nx][ny] == 0) {
                    space--;
                }
                if (space == 0) {
                    if (T == -1) {
                        T = v[2] + 1;
                    } else {
                        T = Math.min(T, v[2] + 1);
                    }
                    return;
                }

                visit[nx][ny] = true;
                queue.add(new int[] {nx, ny, v[2] + 1});

            }
        }
    }

}
