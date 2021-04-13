package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/* 
    플로이드

*/
public class BOJ11404 {

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        int INF = 200000000;

        int[][] arr = new int[n + 1][n + 1];
        for (int a[] : arr) {
            Arrays.fill(a, INF);
        }
        for (int i = 1; i <= n; i++) {
            arr[i][i] = 0;
        }

        while (m-- > 0) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            arr[a][b] = Math.min(arr[a][b], c);
        }

        for (int i = 1; i <= n; i++) {
            for (int f = 1; f <= n; f++) {
                for (int t = 1; t <= n; t++) {
                    arr[f][t] = Math.min(arr[f][t], arr[f][i] + arr[i][t]);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (arr[i][j] == INF) {
                    sb.append(0).append(" ");
                } else {
                    sb.append(arr[i][j]).append(" ");
                }
            }
            sb.append("\n");
        }

        System.out.println(sb.toString());
    }
}
