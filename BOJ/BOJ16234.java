package boj;

import java.io.*;
import java.util.*;

/*
 * 인구 이동
 * 
 * // 메모리초과
 */

public class BOJ16234 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        arr = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int count = 0;
        boolean change = true;
        while (change) {

            visit = new boolean[N][N];
            change = false;

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (!visit[i][j]) {
                        sum = 0;
                        united = new ArrayList<>();
                        findUnited(i, j);
                        if (united.size() > 1) {
                            change = true;
                            sum /= united.size();
                            for (int[] u : united) {
                                arr[u[0]][u[1]] = sum;
                            }
                        }
                    }
                }
            }
            count++;
        }

        System.out.println(count - 1);

    }

    static int N, L, R;
    static int[][] arr;
    static boolean[][] visit;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int sum;
    static List<int[]> united;

    static void findUnited(int x, int y) {
        visit[x][y] = true;
        united.add(new int[] {x, y});
        sum += arr[x][y];

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && nx < N && ny >= 0 && ny < N && !visit[nx][ny]) {
                int d = Math.abs(arr[nx][ny] - arr[x][y]);
                if (d >= L && d <= R) {
                    visit[nx][ny] = true;
                    findUnited(nx, ny);
                }
            }
        }

        return;
    }

}
