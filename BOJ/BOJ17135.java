package BOJ;

import java.io.*;
import java.util.*;

/* 
    캐슬 디펜스

*/
public class BOJ17135 {

    static int N, M, D;
    static int[][] map;
    static int[][] testMap;
    static boolean[] visit;
    static int[] position;
    static int max;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

    }

    static void simulation(int r, int c) {

        for(int d = 0; d<D; d++){

            int nr = r;

            for(int nc = c-d; nc<=c+d; nc++){
                if (nc>=0 && nc<M && nr <N && nr >=0) {
                    if (testMap[nr][nc] == 1) {
                        
                    }
                }
            }
        }

    }
}
