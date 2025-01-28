package boj;

/*
 * 배열 돌리기 4
 */

import java.io.*;
import java.util.*;

public class BOJ17406 {

    public static void main(String[] args) throws IOException {
        new BOJ17406().solution();
    }

    void solution() throws IOException {

        init();

        permutation(0);

        System.out.println(answer);

    }

    int N, M, K, answer;
    int[][] A;
    int[][] operation;
    int[] sequence;
    boolean[] visit;

    void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        A = new int[N + 1][M + 1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= M; j++) {
                A[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        operation = new int[K][3];
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                operation[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        answer = 5000;
        visit = new boolean[K];
        sequence = new int[K];
    }

    void rotate(int r1, int c1, int r2, int c2, int[][] arr) {

        if (r1 == r2 && c1 == c2) {
            return;
        }

        int temp = arr[r1][c1];

        // 위로 이동
        for (int i = r1; i < r2; i++) {
            arr[i][c1] = arr[i + 1][c1];
        }

        // 좌로 이동
        for (int i = c1; i < c2; i++) {
            arr[r2][i] = arr[r2][i + 1];
        }

        // 아래로 이동
        for (int i = r2; i > r1; i--) {
            arr[i][c2] = arr[i - 1][c2];
        }

        // 우로 이동
        for (int i = c2; i > c1 + 1; i--) {
            arr[r1][i] = arr[r1][i - 1];
        }

        arr[r1][c1 + 1] = temp;

        rotate(r1 + 1, c1 + 1, r2 - 1, c2 - 1, arr);

    }

    void permutation(int idx) {
        if (idx == K) {
            int[][] arr = copyArr();

            for (int i = 0; i < K; i++) {
                int r = operation[sequence[i]][0];
                int c = operation[sequence[i]][1];
                int s = operation[sequence[i]][2];
                rotate(r - s, c - s, r + s, c + s, arr);
            }

            answer = Math.min(answer, findMin(arr));
            return;
        }

        for (int i = 0; i < K; i++) {
            if (!visit[i]) {
                visit[i] = true;

                sequence[idx] = i;
                permutation(idx + 1);

                visit[i] = false;
            }
        }
    }

    int[][] copyArr() {
        int[][] arr = new int[N + 1][M + 1];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                arr[i][j] = A[i][j];
            }
        }

        return arr;
    }

    int findMin(int[][] arr) {
        int min = 5000;
        for (int i = 1; i <= N; i++) {
            int sum = 0;
            for (int j = 1; j <= M; j++) {
                sum += arr[i][j];
            }
            min = Math.min(min, sum);
        }

        return min;
    }
}
