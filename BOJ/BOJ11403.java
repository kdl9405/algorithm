package boj;

import java.io.*;
import java.util.*;

/*
 * 경로찾기
 */
public class BOJ11403 {

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        int[][] link = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                link[i][j] = Integer.parseInt(st.nextToken());

            }
        }

        for (int k = 0; k < N; k++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (link[i][j] == 0) {
                        if (link[i][k] == 1 && link[k][j] == 1) {
                            link[i][j] = 1;
                        }
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sb.append(link[i][j] + " ");
            }
            sb.append("\n");
        }

        System.out.println(sb.toString());

    }
}
