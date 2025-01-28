package boj;

/*
 * 저울
 */

import java.io.*;
import java.util.*;

public class BOJ10159 {

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        int[][] isKnown = new int[N + 1][N + 1];
        StringTokenizer st;
        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            isKnown[a][b] = 1;
            isKnown[b][a] = -1;
        }

        for (int k = 1; k <= N; k++) {
            for (int i = 1; i <= N; i++) {
                if (k == i) {
                    continue;
                }
                for (int j = 1; j <= N; j++) {
                    if (i == j || j == k) {
                        continue;
                    }
                    if (isKnown[i][k] != 0 && isKnown[i][k] == isKnown[k][j]) {
                        isKnown[i][j] = isKnown[i][k];
                        isKnown[j][i] = -isKnown[i][k];
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            int count = 0;
            for (int j = 1; j <= N; j++) {

                if (i == j) {
                    continue;
                }
                if (isKnown[i][j] == 0) {
                    count++;
                }
            }
            sb.append(count).append("\n");
        }

        System.out.println(sb.toString().trim());
    }
}
