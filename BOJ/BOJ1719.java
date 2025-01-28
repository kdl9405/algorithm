package boj;

import java.io.*;
import java.util.*;

/*
 * 택배
 */
public class BOJ1719 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        disdance = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            Arrays.fill(disdance[i], 2000001);
        }

        while (m-- > 0) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            disdance[a][b] = d;
            disdance[b][a] = d;
        }

        result = new int[n + 1][n + 1];

        floyWarshall();

        StringBuilder sb = new StringBuilder();
        StringBuilder line;

        for (int i = 1; i <= n; i++) {
            line = new StringBuilder();
            for (int j = 1; j <= n; j++) {
                if (i == j) {
                    line.append("- ");
                } else {

                    if (result[i][j] == 0) {

                        line.append(j + " ");

                    } else {
                        int x = j;
                        while (result[i][x] != 0) {
                            x = result[i][x];
                        }

                        line.append(x + " ");
                    }

                }
            }
            sb.append(line.toString().trim() + "\n");
        }

        System.out.println(sb.toString());

    }

    static int n, m;
    static int[][] disdance;
    static int[][] result;

    static void floyWarshall() {

        for (int k = 1; k <= n; k++) {
            for (int f = 1; f <= n; f++) {
                for (int t = 1; t <= n; t++) {
                    if (f == t) {
                        continue;
                    }

                    if (disdance[f][k] == 0 || disdance[k][t] == 0) {
                        continue;
                    }

                    if (disdance[f][t] > disdance[f][k] + disdance[k][t]) {
                        disdance[f][t] = disdance[f][k] + disdance[k][t];
                        result[f][t] = k;
                    }
                }
            }
        }
    }
}
