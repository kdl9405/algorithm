package boj;

import java.io.*;
import java.util.*;

/*
 * 
 * 행렬 제곱
 * 
 */

public class BOJ10830 {

    static int[][] unit;
    static int N;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        long B = Long.parseLong(st.nextToken());

        int[][] arr = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        unit = new int[N][N];
        for (int i = 0; i < N; i++) {
            unit[i][i] = 1;
        }

        arr = powArr(arr, B);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sb.append(arr[i][j] + " ");
            }
            sb.append("\n");
        }

        System.out.println(sb.toString().trim());
    }

    static int[][] powArr(int[][] a, long b) {

        if (b == 0) {
            return unit;
        }
        if (b == 1) {
            return a;
        }

        int[][] temp = powArr(a, b / 2);
        temp = multiful(temp, temp);


        if (b % 2 == 0) {
            return temp;
        } else {
            return multiful(temp, a);
        }

    }

    static int[][] multiful(int[][] a, int[][] b) {

        int[][] temp = new int[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    temp[i][j] += (a[i][k] * b[k][j]) % 1000;
                }
                temp[i][j] %= 1000;
            }
        }

        return temp;

    }

}
