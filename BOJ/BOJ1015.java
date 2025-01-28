package boj;

/*
 * 수열 정렬
 */

import java.io.*;
import java.util.*;

public class BOJ1015 {

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        Integer[][] A = new Integer[N][2];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            A[i][0] = i;
            A[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(A, (a, b) -> {
            return a[1] - b[1];
        });

        Integer[][] B = new Integer[N][2];

        for (int i = 0; i < N; i++) {
            B[i][0] = A[i][0];
            B[i][1] = i;
        }

        Arrays.sort(B, (a, b) -> {
            return a[0] - b[0];
        });

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            sb.append(B[i][1]).append(" ");
        }

        System.out.println(sb.toString().trim());

    }

}
