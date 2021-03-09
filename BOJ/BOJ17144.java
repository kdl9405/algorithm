package BJ;

import java.io.*;
import java.util.*;

/* 
    미세먼지 안녕!
*/

public class BJ17144 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        int[] m = new int[2];
        map = new int[R][C];
        for(int i = 0; i<R; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j<C; j++){
                map[i][j] = Integer.parseInt(st.nextToken());                
            }
            if (map[i][0] == -1) {
                m[1] = i;
            }
        }
        m[0] = m[1]-1;

        while (T-- > 0) {
            
            spread(m[0], m[1]);

            clean(m[0], m[1]);

        }

        int count = 0;
        for(int i = 0; i<R; i++){
            for(int j = 0; j<C; j++){
                count += map[i][j];
            }
        }
        
        System.out.println(count+2);
    }

    static int R;
    static int C;
    static int T;
    static int[][] map;
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};


    static void spread(int m0, int m1){
        int[][] nMap = new int[R][C];
        
        nMap[m0][0] = -1;
        nMap[m1][0] = -1;

        for(int i = 0; i<R; i++){
            for(int j = 0; j<C; j++){               

                if (i == m0 && j == 0 ) {
                    continue;
                }
                if (i == m1 && j == 0 ) {
                    continue;
                }

                if(map[i][j] == 0){
                    continue;
                }

                int s = map[i][j]/5;

                for(int k = 0; k<4; k++){
                    int nr = i+dx[k];
                    int nc = j+dy[k];

                    if (nr>=0 && nr<R && nc>=0 && nc<C && nMap[nr][nc] != -1) {
                        nMap[nr][nc] += s;
                        map[i][j] -= s;
                    }                    
                }
                nMap[i][j] += map[i][j];
            }
        }

        map = nMap.clone();
        return;

    }

    static void clean(int x, int y){

        for(int i = x-1; i>0; i--){
            map[i][0] = map[i-1][0];
        }
        for(int i = y+1; i<R-1; i++){
            map[i][0] = map[i+1][0];
        }

        for(int i = 0; i<C-1; i++){
            map[0][i] = map[0][i+1];
            map[R-1][i] = map[R-1][i+1];
        }

        for(int i = 0; i<x; i++){
            map[i][C-1] = map[i+1][C-1];
        }

        for(int i = R-1; i>y; i--){
            map[i][C-1] = map[i-1][C-1];
        }

        for(int i = C-1; i>1; i--){
            map[x][i] = map[x][i-1];
            map[y][i] = map[y][i-1];           
        }

       

        map[x][1] = 0;
        map[y][1] = 0;

        return;

    }
    
}
