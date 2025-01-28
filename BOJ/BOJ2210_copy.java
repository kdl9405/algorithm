package boj;

/*
 * 숫자판 점프
 */

import java.io.*;
import java.util.*;

public class BOJ2210_copy {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        Queue<State> queue = new LinkedList<>();
        board = new int[5][5];
        for (int i = 0; i < 5; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                queue.add(new State(i, j, board[i][j]));
            }
        }

        int cnt = 1;
        while (cnt++ <= 5) {

            int size = queue.size();
            while (size-- > 0) {

                State now = queue.poll();

                for (int i = 0; i < 4; i++) {
                    int nx = now.x + move[i][0];
                    int ny = now.y + move[i][1];

                    if (nx < 0 || nx >= 5 || ny < 0 || ny >= 5) {
                        continue;
                    }

                    queue.add(new State(nx, ny, now.number * 10 + board[nx][ny]));
                }
            }
        }

        Set<Integer> answerSet = new HashSet<>();
        while (!queue.isEmpty()) {

            answerSet.add(queue.poll().number);
        }
        System.out.println(answerSet.size());

    }

    static int[][] board;
    static int[][] move = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    private static class State {
        int x;
        int y;
        int number;

        State(int x, int y, int number) {
            this.x = x;
            this.y = y;
            this.number = number;
        }
    }
}
