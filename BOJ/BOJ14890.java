package boj;

/*
 * 경사로
 */

import java.io.*;
import java.util.*;

public class BOJ14890 {

    public static void main(String[] args) throws IOException {

        init();

        int answer = countRoad();

        System.out.println(answer);

    }

    static int N, K;
    static int[][] map;

    static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }

    static boolean isPossibleForRow(int r) {

        boolean[] isUsed = new boolean[N];
        for (int i = 1; i < N; i++) {
            if (map[r][i] == map[r][i - 1]) {
                continue;
            }

            if (Math.abs(map[r][i] - map[r][i - 1]) > 1) {
                return false;
            }

            if (map[r][i - 1] - map[r][i] == 1) {

                if (N - i < K || isUsed[i]) {
                    return false;
                }

                isUsed[i] = true;
                for (int j = 1; j < K; j++) {
                    if (map[r][i] != map[r][i + j] || isUsed[i + j]) {
                        return false;
                    }
                    isUsed[i + j] = true;
                }

            } else if (map[r][i] - map[r][i - 1] == 1) {

                if (i < K || isUsed[i - 1]) {
                    return false;
                }

                isUsed[i - 1] = true;
                for (int j = 2; j <= K; j++) {
                    if (map[r][i - 1] != map[r][i - j] || isUsed[i - j]) {
                        return false;
                    }
                    isUsed[i - j] = true;
                }

            }
        }

        return true;
    }

    static boolean isPossibleForCol(int c) {

        boolean[] isUsed = new boolean[N];
        for (int i = 1; i < N; i++) {
            if (map[i][c] == map[i - 1][c]) {
                continue;
            }

            if (Math.abs(map[i][c] - map[i - 1][c]) > 1) {
                return false;
            }

            if (map[i - 1][c] - map[i][c] == 1) {

                if (N - i < K || isUsed[i]) {
                    return false;
                }

                isUsed[i] = true;
                for (int j = 1; j < K; j++) {
                    if (map[i][c] != map[i + j][c] || isUsed[i + j]) {
                        return false;
                    }
                    isUsed[i + j] = true;
                }

            } else if (map[i][c] - map[i - 1][c] == 1) {

                if (i < K || isUsed[i - 1]) {
                    return false;
                }

                isUsed[i - 1] = true;
                for (int j = 2; j <= K; j++) {
                    if (map[i - 1][c] != map[i - j][c] || isUsed[i - j]) {
                        return false;
                    }
                    isUsed[i - j] = true;
                }

            }
        }

        return true;
    }

    static int countRoad() {

        int count = 0;
        for (int i = 0; i < N; i++) {
            if (isPossibleForRow(i)) {
                count++;
            }
            if (isPossibleForCol(i)) {
                count++;
            }
        }

        return count;
    }

}
