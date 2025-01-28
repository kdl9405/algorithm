package boj;

import java.io.*;
import java.util.*;

/*
 * 케빈 베이컨의 6단계 법칙
 * 
 */
public class BOJ1389 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] link = new int[N + 1][N + 1];

        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            link[a][b] = 1;
            link[b][a] = 1;
        }

        for (int k = 1; k <= N; k++) {
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    if (i != j) {
                        if (link[i][k] != 0 && link[k][j] != 0) {
                            if (link[i][j] == 0) {
                                link[i][j] = link[i][k] + link[k][j];
                            } else {
                                link[i][j] = Math.min(link[i][j], link[i][k] + link[k][j]);
                            }
                        }
                    }
                }
            }
        }

        int min = Integer.MAX_VALUE;
        int index = 0;

        for (int i = 1; i <= N; i++) {
            int sum = 0;
            for (int j = 1; j <= N; j++) {
                if (i == j) {
                    continue;
                }
                sum += link[i][j];

            }
            if (sum < min) {
                min = sum;
                index = i;
            }
        }

        System.out.println(index);

    }
}
