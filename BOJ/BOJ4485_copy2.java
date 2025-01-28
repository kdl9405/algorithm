package boj;

/*
 * 녹색 옷 입은 애가 젤다지?
 */

import java.io.*;
import java.util.*;

public class BOJ4485_copy2 {

    public static void main(String[] args) throws NumberFormatException, IOException {

        new BOJ4485_copy2().solution();
    }

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    int N;
    int[][] cave;
    int[][] move = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    void solution() throws NumberFormatException, IOException {

        StringBuilder answer = new StringBuilder();
        int testNumber = 1;

        while (true) {

            if (!inputOrStop()) {
                break;
            }

            int rupee = findMinRupee();

            answer.append("Problem " + testNumber + ": " + rupee + "\n");
            testNumber++;
        }

        System.out.println(answer.toString().trim());
    }

    boolean inputOrStop() throws NumberFormatException, IOException {

        N = Integer.parseInt(br.readLine());
        if (N == 0) {
            return false;
        }

        cave = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                cave[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        return true;
    }

    int findMinRupee() {

        int rupee = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            return a[2] - b[2];
        });
        pq.add(new int[] {0, 0, cave[0][0]});

        boolean[][] visit = new boolean[N][N];
        visit[0][0] = true;

        loop: while (!pq.isEmpty()) {
            int[] now = pq.poll();

            for (int i = 0; i < 4; i++) {
                int nx = now[0] + move[i][0];
                int ny = now[1] + move[i][1];

                if (nx < 0 || nx >= N || ny < 0 || ny >= N || visit[nx][ny]) {
                    continue;
                }

                if (nx == N - 1 && ny == N - 1) {
                    rupee = cave[nx][ny] + now[2];
                    break loop;
                }

                visit[nx][ny] = true;
                pq.add(new int[] {nx, ny, cave[nx][ny] + now[2]});
            }
        }

        return rupee;
    }

}
