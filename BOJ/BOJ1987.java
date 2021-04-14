package BOJ;

import java.io.*;
import java.util.*;

/* 
    알파벳 

    dfs (비트마스크) - 196ms
*/
public class BOJ1987 {

    static int max, R, C;
    static char[][] board;
    static int[][] visit; // 해당 칸에 도착할 때까지 사용한 알파벳을 비트(int)값으로 저장
    static int[][] direction = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } }; // 상하좌우 이동

    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        board = new char[R][C];
        for(int i= 0; i<R; i++){
            board[i] = br.readLine().toCharArray();
        }

        visit = new int[R][C];

        max = 0;
       
        dfs(0, 0,1<<board[0][0]-'A' ,1);  // 줄, 칸, 시작 칸의 알파벳을 비트값으로 저장하고 시작, 이동거리 

        System.out.println(max);
    }

    static void dfs(int r, int c, int check_bit, int d){

        if (visit[r][c] == check_bit) { // 조회하려는 비트값(이동경로)를 이미 조회했다면.
            return;
        }        

        visit[r][c] = check_bit; // 해당 칸의 이동경로(비트값) 갱신

        max = Math.max(max, d);  // 현재까지의 최대 이동거리 갱신

        for(int i = 0; i<4; i++){
            int nr = r + direction[i][0];
            int nc = c + direction[i][1];

            if (nr >= 0 && nr<R && nc>=0 && nc<C) { // 다음 이동 칸이 볌위내에 존재한다면
                if ((check_bit & 1<<board[nr][nc]-'A') == 0) { // 이미 사용된 알파벳이 아니라면
                    dfs(nr, nc,check_bit|1<<board[nr][nc]-'A', d+1); // 알파벳 비트를 추가하고 dfs 지속
                }
            }
        }        
    }
}
