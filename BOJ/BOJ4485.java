package BOJ;

/* 
    녹색 옷 입은 애가 젤다지?
*/

import java.io.*;
import java.util.*;

public class BOJ4485 {

    public static void main(String[] args) throws NumberFormatException, IOException {

        new BOJ4485().solution();
    }

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    int N;
    int[][] cave;
    int[][] visit;
    int[][] move = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

    void solution() throws NumberFormatException, IOException {

        StringBuilder answer = new StringBuilder();
        int testNumber = 1;

        while (true) {

            if (!init()) {
                break;
            }

            findMinRupee();

            answer.append("Problem ").append(testNumber).append(": ").append(visit[N - 1][N - 1]).append("\n");
            testNumber++;
        }

        System.out.println(answer.toString().trim());
    }

    boolean init() throws NumberFormatException, IOException {

        N = Integer.parseInt(br.readLine());
        if (N == 0) {
            return false;
        }

        int max = N * N * 10;
        cave = new int[N][N];
        visit = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                cave[i][j] = Integer.parseInt(st.nextToken());
                visit[i][j] = max;
            }
        }

        return true;
    }

    int findMinRupee() {

        int rupee = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            return a[2] - b[2];
        });
        pq.add(new int[] { 0, 0, cave[0][0] });

        while (!pq.isEmpty()) {
            int[] now = pq.poll();

            for (int i = 0; i < 4; i++) {
                int nx = now[0] + move[i][0];
                int ny = now[1] + move[i][1];

                if (nx < 0 || nx >= N || ny < 0 || ny >= N) {
                    continue;
                }

                if (visit[nx][ny] > cave[nx][ny] + now[2]) {
                    visit[nx][ny] = cave[nx][ny] + now[2];
                    pq.add(new int[] { nx, ny, visit[nx][ny] });

                }
            }
        }

        return rupee;
    }

}
