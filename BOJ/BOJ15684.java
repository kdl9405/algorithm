package BOJ;

/* 
    사다리 조작

*/

import java.io.*;
import java.util.*;

public class BOJ15684 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        board = new boolean[H + 1][N + 1]; // false : 선없음 , true 오른쪽으로 연결
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            board[a][b] = true;

        }

        addLine(1, 1, 0);

        if (count > 3) {
            count = -1;
        }

        System.out.println(count);

    }

    static int N, M, H;
    static boolean[][] board;
    static int count = 5;
    static int index = 0;

    static void addLine(int h, int w, int c) {

        if (c > 3 || c >= count) {
            return;
        }

        if (h > H) {
            return;
        }

        if (w > N) {
            addLine(h + 1, 1, c);
            return;
        }

        if (check()) {
            count = Math.min(count, c);
            return;
        }

        if (board[h][w]) {
            addLine(h, w + 1, c);

        } else {

            if (w == 1 || (!board[h][w - 1])) {
                if (w<N && !board[h][w + 1]) {
                    board[h][w] = true;
                    addLine(h, w + 2, c + 1);
                    board[h][w] = false;
                }
            }

            addLine(h, w + 1, c);

        }

        // if (!board[h][w] && w<N && !board[h][w+1]) {

        // if (!(w > 1 && board[h][w - 1]) ) {

        // board[h][w] = true;
        // addLine(h, w + 2, c + 1);
        // board[h][w] = false;
        // }

        // }

        // addLine(h, w + 1, c);
    }

    static boolean check() {

        for (int i = 1; i <= N; i++) {
            dfs(1, i, i);
            if (index != i) {
                return false;
            }
        }

        return true;
    }

    static void dfs(int h, int w, int bw) {

        if (h > H) {

            index = w;

            return;
        }

        if (board[h][w] && w + 1 != bw) {
            dfs(h, w + 1, w);
        } else if (w > 1 && board[h][w - 1] && w - 1 != bw) {
            dfs(h, w - 1, w);
        } else {
            dfs(h + 1, w, w);
        }

    }
}
