package boj;

/*
 * 배열 합치기
 */

import java.io.*;
import java.util.*;

public class BOJ11728 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int lenA = Integer.parseInt(st.nextToken());
        int lenB = Integer.parseInt(st.nextToken());

        int[] A = new int[lenA];
        int[] B = new int[lenB];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < lenA; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < lenB; i++) {
            B[i] = Integer.parseInt(st.nextToken());
        }

        StringBuilder sb = new StringBuilder();

        int a = 0;
        int b = 0;

        while (a < lenA || b < lenB) {

            if (a == lenA) {
                sb.append(B[b]).append(" ");
                b++;
                continue;
            }

            if (b == lenB) {
                sb.append(A[a]).append(" ");
                a++;
                continue;
            }

            if (A[a] <= B[b]) {
                sb.append(A[a]).append(" ");
                a++;
            } else {
                sb.append(B[b]).append(" ");
                b++;
            }
        }

        System.out.println(sb.toString().trim());

    }
}
