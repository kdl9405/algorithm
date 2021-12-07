package BOJ;

/* 
    안전 영역

*/

import java.io.*;

public class BOJ2468 {

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        arr = new int[N][N];

        int max = 0;

        for (int i = 0; i < N; i++) {
            String[] str = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(str[j]);
                max = Math.max(max, arr[i][j]);
            }
        }
        int answer = 0;

        for (int k = 0; k < max; k++) {
            visit = new boolean[N][N];

            int count = 0;

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (visit[i][j]) {
                        continue;
                    }

                    if (arr[i][j] > k) {
                        visit[i][j] = true;
                        check(i, j, k);
                        count++;
                    }

                }
            }

            answer = Math.max(answer, count);

        }

        System.out.println(answer);

    }

    static int N;
    static int[] dx = { 1, -1, 0, 0 };
    static int[] dy = { 0, 0, -1, 1 };
    static int[][] arr;
    static boolean[][] visit;

    static void check(int x, int y, int k) {

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || nx >= N || ny < 0 || ny >= N) {
                continue;
            }
            if (arr[nx][ny] <= k || visit[nx][ny]) {
                continue;
            }

            visit[nx][ny] = true;
            check(nx, ny, k);
        }

        return;
    }
}
