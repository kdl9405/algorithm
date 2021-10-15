package BOJ;

import java.io.*;
import java.util.*;

/* 
    어두운 건 무서워

*/
public class BOJ16507 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());

        int[][] picture = new int[R + 1][C + 1];

        for (int i = 1; i <= R; i++) {

            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= C; j++) {
                picture[i][j] = picture[i - 1][j] + picture[i][j - 1] - picture[i - 1][j - 1]
                        + Integer.parseInt(st.nextToken());
            }
        }

        StringBuilder sb = new StringBuilder();

        while (Q-- > 0) {
            st = new StringTokenizer(br.readLine());
            int r1 = Integer.parseInt(st.nextToken());
            int c1 = Integer.parseInt(st.nextToken());
            int r2 = Integer.parseInt(st.nextToken());
            int c2 = Integer.parseInt(st.nextToken());

            int sum = picture[r2][c2] - picture[r1-1][c2] - picture[r2][c1-1] + picture[r1-1][c1-1];
            int avg = sum / ((r2-r1+1)*(c2-c1+1));

            sb.append(avg+"\n");
        }

        System.out.println(sb.toString().trim());

    }
}
