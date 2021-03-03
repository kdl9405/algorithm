package BJ;

import java.io.*;
import java.util.*;

/* 
    주지수
*/

public class BJ15724 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] arr = new int[n + 1][m + 1];

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 1; j <= m; j++) {
                arr[i][j] = arr[i - 1][j] + arr[i][j - 1] - arr[i - 1][j - 1] + Integer.parseInt(st.nextToken());
            }
        }

        int k = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        while (k-- > 0) {
            st = new StringTokenizer(br.readLine());

            int r1 = Integer.parseInt(st.nextToken());
            int c1 = Integer.parseInt(st.nextToken());
            int r2 = Integer.parseInt(st.nextToken());
            int c2 = Integer.parseInt(st.nextToken());

            int sum = arr[r2][c2] - (arr[r1-1][c2] + arr[r2][c1-1])+arr[r1-1][c1-1];

            sb.append(sum).append("\n");
        }
        System.out.println(sb.toString().trim());

    }
}
