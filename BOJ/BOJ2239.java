package BOJ;

import java.io.*;
import java.util.*;

/* 
    스도쿠

    1) 빈칸마다, 들어갈 수 있는 숫자를 조회해서 대입.
    2) 올바른 대입이 모두 끝나면, String으로 만들어서 list에 저장
    3) list 정렬
    4) 9자리씩 끊어서 출력.
*/
public class BOJ2239 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        board = new int[9][9];
        visit = new boolean[9][9];

        for (int i = 0; i < 9; i++) {
            board[i] = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();
        }

        finish = false;

        result = "";

        dfs(0, 0);

        System.out.println(result);

    }

    static String result;
    static int[][] board;
    static boolean finish;
    static boolean[][] visit;

    static void dfs(int x, int y) {

        if (finish) {
            return;
        }

        if (x == 9) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    sb.append(board[i][j]);
                }
                sb.append("\n");
            }
            result = sb.toString();
            finish = true;
            return;
        }

        if (y == 9) {
            dfs(x + 1, 0);

        } else {
            if (board[x][y] != 0) {
                dfs(x, y + 1);
            } else {
                boolean[] num = candidateN(x, y);
                boolean check = false;

                for (int k = 1; k <= 9; k++) {
                    if (!num[k]) {
                        check = true;
                        board[x][y] = k;
                        
                        dfs(x, y + 1);

                        board[x][y] = 0;
                    }
                }
                if (!check) {
                    return;
                }
            }
        }

    }

    static boolean[] candidateN(int x, int y) {


        boolean[] num = new boolean[10];
        num[0] = true;

        for (int i = 0; i < 9; i++) {
            if (i != x) {
                num[board[i][y]] = true;
            }
            if (i != y) {
                num[board[x][i]] = true;
            }
        }

        int nx = (x / 3) * 3;
        int ny = (y / 3) * 3;

        for (int i = nx; i < nx + 3; i++) {
            for (int j = ny; j < ny + 3; j++) {
                if (nx == x && ny == y) {
                    continue;
                }
                num[board[i][j]] = true;
            }
        }

        return num;
    }
}
