package BOJ;

/* 
    영역 구하기

 */

import java.io.*;
import java.util.*;

public class BOJ2583 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        map = new boolean[M+2][N+2];
        visit = new boolean[N][M];

        int x1, y1, x2, y2;
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            y1 = Integer.parseInt(st.nextToken());
            x1 = Integer.parseInt(st.nextToken());
            y2 = Integer.parseInt(st.nextToken());
            x2 = Integer.parseInt(st.nextToken());

            for(int r = x1; r<x2; r++){
                for(int c = y1; c<y2; c++){
                    map[r][c] = true;
                }
            }
        }

        for(int i = M-1; i>=0; i--){
            for(int j = 0; j<N; j++){
                System.out.print((map[i][j])? "X " : "- ");
            }System.out.println();
        }


    }

    static int N, M;
    static boolean[][] map;
    static boolean[][] visit;
}
