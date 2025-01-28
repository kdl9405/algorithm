package boj;

import java.io.*;
import java.util.*;

/*
 * 알파벳
 * 
 * dfs (HashSet) - 1912ms
 */
public class BOJ1987_copy {

    static int max, R, C;
    static HashSet<Character> alphabet; // 사용한 알파벳을 저장
    static char[][] board;
    static int[][] direction = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}}; // 상하좌우 이동


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        board = new char[R][C];
        for (int i = 0; i < R; i++) {
            board[i] = br.readLine().toCharArray();
        }

        max = 0; // 최대 이동 칸의 수
        alphabet = new HashSet<>();
        alphabet.add(board[0][0]); // 시작 칸의 알파벳을 저장
        dfs(0, 0);

        System.out.println(max);
    }

    static void dfs(int r, int c) {

        boolean possible = false; // 다음 이동이 가능한지 체크

        for (int i = 0; i < 4; i++) {
            int nr = r + direction[i][0];
            int nc = c + direction[i][1];

            if (nr >= 0 && nr < R && nc >= 0 && nc < C) { // 다음 이동 좌표가 볌위안에 존재하는지
                if (alphabet.contains(board[nr][nc])) { // 다음 좌표의 알파벳을 이미 지나왔는지
                    continue;
                }
                possible = true; // 다음 이동 가능

                alphabet.add(board[nr][nc]); // 알파벳을 추가하고 DFS
                dfs(nr, nc);
                alphabet.remove(board[nr][nc]); // 추가한 알파벳 제거
            }
        }

        if (!possible) { // 더 이상 이동이 불가한 경우, 이동 거리를 갱신
            max = Math.max(max, alphabet.size());
            return;
        }
    }
}
