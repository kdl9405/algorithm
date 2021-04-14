package BOJ;

import java.io.*;
import java.util.*;

/* 
    알파벳 

    dfs (boolean[]) - 868ms
*/
public class BOJ1987_copy2 {

    static int count, R, C;
    static char[][] board;
    static boolean[] visit;
    static int[][] direction = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        board = new char[R][C];
        for(int i= 0; i<R; i++){
            board[i] = br.readLine().toCharArray();
        }

        visit = new boolean[26];
        visit[board[0][0]-'A'] = true;

        count = 0;
       
        dfs(0, 0, 1);

        System.out.println(count);


    }

    static void dfs(int r, int c, int d){

        for(int i = 0; i<4; i++){
            int nr = r + direction[i][0];
            int nc = c + direction[i][1];

            if (nr>=0 && nr<R && nc>=0 && nc<C) {
                if (!visit[board[nr][nc]-'A']) {
                    visit[board[nr][nc]-'A'] = true;
                    dfs(nr, nc, d+1);
                    visit[board[nr][nc]-'A'] = false;
                }                
            }
        }

        count = Math.max(count, d);
        
    }
}
