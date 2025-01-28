package boj;

/*
 * 합이 0인 네 정수
 * 
 */

import java.io.*;
import java.util.*;

public class BOJ7453 {

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int max = n * n;

        int[] A = new int[n];
        int[] B = new int[n];
        int[] C = new int[n];
        int[] D = new int[n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            A[i] = Integer.parseInt(st.nextToken());
            B[i] = Integer.parseInt(st.nextToken());
            C[i] = Integer.parseInt(st.nextToken());
            D[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(A);
        Arrays.sort(B);
        Arrays.sort(C);
        Arrays.sort(D);

        int[] front = new int[max];
        int[] back = new int[max];

        int idx = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                front[idx] = A[i] + B[j];
                back[idx] = C[i] + D[j];
                idx++;
            }
        }

        Arrays.sort(front);
        Arrays.sort(back);
        long answer = 0L;

        for (int i = 0; i < max; i++) {
            answer += (upperBound(back, -front[i]) - lowerBound(back, -front[i]));
        }

        System.out.println(answer);

    }

    static int upperBound(int[] back, int x) {
        int min = 0;
        int max = back.length - 1;

        while (min < max) {

            int mid = (min + max) / 2;

            if (back[mid] <= x) {
                min = mid + 1;
            } else {
                max = mid;
            }
        }

        return min;
    }

    static int lowerBound(int[] back, int x) {
        int min = 0;
        int max = back.length - 1;

        while (min < max) {

            int mid = (min + max) / 2;

            if (back[mid] < x) {
                min = mid + 1;
            } else {
                max = mid;
            }
        }

        return min;
    }
}
