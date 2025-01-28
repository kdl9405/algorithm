package boj;

import java.io.*;
import java.util.*;

public class BOJ1932 {

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        arr = new int[n][n];
        sum = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j <= i; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(findSum(0, 0));

    }

    static int[][] arr;
    static int[][] sum;

    static int findSum(int depth, int index) {

        if (depth == sum.length - 1) {
            return arr[depth][index];
        }

        if (sum[depth][index] != 0) {
            return sum[depth][index];
        }

        return sum[depth][index] =
                Math.max(findSum(depth + 1, index), findSum(depth + 1, index + 1))
                        + arr[depth][index];
    }

}
