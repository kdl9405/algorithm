package BOJ;

import java.io.*;
import java.util.*;

/* 
    알파벳 

    dfs (HashSet) - 1912ms
*/
public class BOJ1987_copy {

    static int count, R, C;
    static HashSet<Character> alphabet;
    static char[][] board;
    static int[][] direction = {{-1,0}, {1,0},{0,-1},{0,1}};

    
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        board = new char[R][C];
        for(int i= 0; i<R; i++){
            board[i] = br.readLine().toCharArray();
        }

        System.out.println(1<<'D'-'A');

        count = 0;
        alphabet = new HashSet<>();
        alphabet.add(board[0][0]);
        dfs(0, 0);

        System.out.println(count);


    }

    static void dfs(int r, int c){

        boolean possible = false;

        for(int i = 0; i<4; i++){
            int nr = r+direction[i][0];
            int nc = c+direction[i][1];

            if (nr>=0 && nr<R && nc>=0 && nc<C) {
                if (alphabet.contains(board[nr][nc])) {
                    continue;
                }
                possible = true;

                alphabet.add(board[nr][nc]);
                dfs(nr, nc);
                alphabet.remove(board[nr][nc]);
            }
        }

        if (!possible) {
            count = Math.max(count, alphabet.size());
            return;
        }
    }
}
