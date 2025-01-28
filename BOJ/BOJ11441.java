package boj;

/*
 * 합 구하기
 */

import java.io.*;
import java.util.*;

public class BOJ11441 {

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] A = new int[N + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            A[i] = A[i - 1] + Integer.parseInt(st.nextToken());
        }

        int M = Integer.parseInt(br.readLine());

        StringBuilder answer = new StringBuilder();
        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());
            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());

            answer.append(A[j] - A[i - 1]).append("\n");
        }

        System.out.println(answer.toString().trim());

    }
}
