package boj;

/*
 * 숫자 정사각형
 */

import java.io.*;
import java.util.*;

public class BOJ1051 {

    public static void main(String[] args) throws IOException {

        new BOJ1051().solution();
    }

    private void solution() throws IOException {

        // input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        char[][] rectangle = new char[N][M];
        for (int i = 0; i < N; i++) {
            rectangle[i] = br.readLine().toCharArray();
        }

        // findMaxSize
        int size = 1;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                int len = Math.min(N - i, M - j);

                for (int x = 1; x < len; x++) {
                    if (rectangle[i][j] == rectangle[i][j + x]
                            && rectangle[i][j] == rectangle[i + x][j]
                            && rectangle[i][j] == rectangle[i + x][j + x]) {
                        size = Math.max(size, (int) Math.pow(x + 1, 2));
                    }
                }
            }
        }

        System.out.println(size);

    }

}
