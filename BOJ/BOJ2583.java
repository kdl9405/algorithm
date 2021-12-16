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

        map = new boolean[M+1][N+1];
        visit = new boolean[M+1][N+1];

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

        // for(int i = M-1; i>=0; i--){
        //     for(int j = 0; j<N; j++){
        //         System.out.print((map[i][j])? "X " : "- ");
        //     }System.out.println();
        // }


        int count = 0;
        List<Integer> width = new ArrayList<>();
        for(int i = M-1; i>=0; i--){
            for(int j = 0; j<N; j++){
                if (!map[i][j] && !visit[i][j]) {
                    count++;

                    width.add(dfs(i, j));
                }
            }
        }

        Collections.sort(width);
        StringBuilder sb = new StringBuilder();
        for(int w : width){
            sb.append(w +" ");
        }
        
        System.out.println(count);
        System.out.println(sb.toString().trim());

    }

    static int N, M;
    static boolean[][] map;
    static boolean[][] visit;
    static int[] dr = {-1,1,0,0};
    static int[] dc = {0,0,-1,1};

    static int dfs(int r, int c){

        visit[r][c] = true;

        int w = 1;

        for(int i = 0; i<4; i++){
            int nr = r + dr[i];
            int nc = c + dc[i];

            if(nr < 0 || nr>=M || nc<0 || nc>=N){
                continue;
            }

            if (map[nr][nc] || visit[nr][nc]) {
                continue;
            }

            w+=dfs(nr, nc);
        }

        return w;
    }
}
