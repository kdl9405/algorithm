package BOJ;

/**
    원판 돌리기
 */

import java.io.*;
import java.util.*;

public class BOJ17822 {

    public static void main(String[] args) throws IOException {

        new BOJ17822().solution();

    }

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    int N, M, T;
    int[][] board;
    boolean isRemoved;
    int[][] dir = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

    void solution() throws IOException {

        input();

        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            for (int i = x; i <= N; i += x) {
                rotate(i - 1, d, k);
            }

            isRemoved = false;

            remove();

            if (!isRemoved) {
                increaseAndDecrease();
            }

        }

        System.out.println(getSum());

    }

    void input() throws IOException {

        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        board = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }

    void rotate(int x, int d, int k) {

        List<Integer> list = new ArrayList<>();
        for (int number : board[x]) {
            list.add(number);
        }

        int index;

        if (d == 1) {
            index = k;
        } else {
            index = M - k;
        }

        int i = 0;
        for (; index < M; i++) {
            board[x][i] = list.get(index++);
        }
        index = 0;
        for (; i < M; i++) {
            board[x][i] = list.get(index++);
        }
    }

    void remove() {

        int[][] temp = new int[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                temp[i][j] = board[i][j];
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (board[i][j] != 0) {

                    if (j == 0 && temp[i][j] == temp[i][M - 1]) {
                        board[i][j] = 0;
                        board[i][M-1] = 0;
                        isRemoved = true;
                    }

                    for (int k = 0; k < 4; k++) {
                        int ii = i + dir[k][0];
                        int jj = j + dir[k][1];
                        if (ii >= 0 && ii < N && jj >= 0 && jj < M) {
                            if (temp[i][j] == temp[ii][jj]) {
                                board[i][j] = 0;
                                isRemoved = true;
                                break;
                            }
                        }
                    }
                }
            }
        }

    }

    void increaseAndDecrease() {

        double average = 0;
        double count = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (board[i][j] != 0) {
                    average += board[i][j];
                    count++;
                }
            }
        }

        average /= count;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (board[i][j] == 0) {
                    continue;
                }
                if (board[i][j] > average) {
                    board[i][j]--;
                } else if (board[i][j] < average) {
                    board[i][j]++;
                }
            }
        }
    }

    int getSum() {
        int sum = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                sum += board[i][j];
            }
        }

        return sum;
    }

}