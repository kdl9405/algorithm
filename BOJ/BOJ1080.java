package boj;

/*
 * 행렬
 */

import java.io.*;
import java.util.*;

public class BOJ1080 {

    public static void main(String[] args) throws IOException {

        new BOJ1080().solution();
    }

    int N, M;
    boolean[][] matrixA;
    boolean[][] matrixB;

    BufferedReader br;
    StringTokenizer st;

    void solution() throws IOException {

        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        matrixA = inputMatrix();
        matrixB = inputMatrix();

        int count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {

                if (matrixA[i][j] != matrixB[i][j]) {
                    if (convert(i, j)) {
                        count++;
                    } else {
                        System.out.println(-1);
                        return;
                    }
                }
            }
        }

        System.out.println(count);
    }

    boolean[][] inputMatrix() throws IOException {
        boolean[][] matrix = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {

                if (line.charAt(j) == '1') {
                    matrix[i][j] = true;
                }

            }
        }

        return matrix;
    }

    boolean convert(int r, int c) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {

                try {
                    if (matrixA[r + i][c + j]) {
                        matrixA[r + i][c + j] = false;
                    } else {
                        matrixA[r + i][c + j] = true;
                    }
                } catch (ArrayIndexOutOfBoundsException e) {
                    return false;
                }

            }
        }

        return true;
    }
}
