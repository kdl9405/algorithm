package boj;

import java.io.*;
import java.util.*;

/*
 * 해킹
 * 
 * 시작지점부터 시작해서 가장 먼 시간의 지점을 찾음.
 * 
 * 메모리초과
 */

public class BOJ10282_copy {

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {

            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            int[][] link = new int[n + 1][n + 1];

            while (d-- > 0) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int s = Integer.parseInt(st.nextToken());

                // link[a][b] = s;
                link[b][a] = s;
            }

            for (int k = 1; k <= n; k++) {
                for (int i = 1; i <= n; i++) {
                    for (int j = 1; j <= n; j++) {
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

            int max = 0;
            for (int t : link[c]) {
                if (t == 0) {
                    n--;
                }
                max = Math.max(max, t);
            }

            sb.append((n + 2) + " " + max + "\n");

        }

        System.out.println(sb.toString());
    }
}
