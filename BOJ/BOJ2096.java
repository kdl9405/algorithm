package BOJ;

import java.io.*;
import java.util.*;

/* 
    내려가기 

*/
public class BOJ2096 {

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        max = new int[N][3];
        min = new int[N][3];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            if (i == 0) {
                max[i][0] = min[i][0] = a;
                max[i][1] = min[i][1] = b;
                max[i][2] = min[i][2] = c;
            } else {

                // max
                max[i][0] = Math.max(max[i - 1][0], max[i - 1][1]) + a;
                max[i][1] = Math.max(max[i - 1][0], Math.max(max[i - 1][1], max[i - 1][2])) + b;
                max[i][2] = Math.max(max[i - 1][1], max[i - 1][2]) + c;

                // min
                min[i][0] = Math.min(min[i - 1][0], min[i - 1][1]) + a;
                min[i][1] = Math.min(min[i - 1][0], Math.min(min[i - 1][1], min[i - 1][2])) + b;
                min[i][2] = Math.min(min[i - 1][1], min[i - 1][2]) + c;
            }
        }

        System.out.println(Math.max(max[N-1][0], Math.max(max[N-1][1], max[N-1][2])) +" "+
                Math.min(min[N-1][0],Math.min(min[N-1][1], min[N-1][2])));

    }

    static int N;
    static int[][] num;
    static int[][] max, min;

}
