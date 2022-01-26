package BOJ;

/* 
    녹색 옷 입은 애가 젤다지?
*/

import java.io.*;
import java.util.*;

public class BOJ4485_copy {

    public static void main(String[] args) throws NumberFormatException, IOException {

        new BOJ4485_copy().solution();
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

            if (!inputOrStop()) {
                break;
            }

            initVisit();

            findMinRupee(0, 0, cave[0][0]);

            answer.append("Problem " + testNumber + ": " + visit[N - 1][N - 1] + "\n");
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

    void initVisit() {
        int max = N * N * 10;
        visit = new int[N][N];

        for (int i = 0; i < N; i++) {
            Arrays.fill(visit[i], max);
        }

        visit[0][0] = cave[0][0];

    }

    void findMinRupee(int x, int y, int rupee) {
        if (x == N - 1 && y == N - 1) {
            visit[x][y] = Math.min(visit[x][y], rupee);
            return;
        }

        for (int i = 0; i < 4; i++) {
            int nx = x + move[i][0];
            int ny = y + move[i][1];

            if (nx < 0 || nx >= N || ny < 0 || ny >= N) {
                continue;
            }

            if (rupee + cave[nx][ny] >= visit[nx][ny]) {
                continue;
            }

            visit[nx][ny] = rupee + cave[nx][ny];
            findMinRupee(nx, ny, visit[nx][ny]);
        }
    }

}
