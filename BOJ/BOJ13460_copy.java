package BOJ;

/* 
    구슬 탈출 2

    1. 완전탐색으로 10번동안 상하좌우 이동의 경우를 모두 구함. 4^10
    2. 빨간 구슬과 파란구슬의 이동 경로가 겹친다면, 먼저 이동해야 하는 것부터 이동..
    3. 각 구슬 이동 경로 중, 구멍이 있으면 break.

*/

import java.io.*;
import java.util.*;

public class BOJ13460_copy {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        board = new char[N][M];

        int[] ball = new int[4];

        for (int i = 0; i < N; i++) {
            char[] line = br.readLine().toCharArray();
            for (int j = 0; j < M; j++) {
                board[i][j] = line[j];
                if (line[j] == 'R') {
                    ball[0] = i;
                    ball[1] = j;
                } else if (line[j] == 'B') {
                    ball[2] = i;
                    ball[3] = j;
                }
            }
        }

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(ball);

        int count = 1;
        check = new boolean[2];
        while (count < 10) {

            int size = queue.size();

            while (size-- > 0) {

                int[] now = queue.poll();

                for (int i = 0; i < 4; i++) {

                    check[0] = false;
                    check[1] = false;

                    int rx = now[0];
                    int ry = now[1];
                    int bx = now[2];
                    int by = now[3];

                    while (board[rx+dx[i]][ry+dy[i]] != '#') {
                        rx += dx[i];
                        ry += dy[i];
                        if (board[rx][ry] == 'O') {
                            check[0] = true;
                            break;
                        }
                    }

                    while (board[bx+dx[i]][by+dy[i]] != '#') {
                        bx += dx[i];
                        by += dy[i];
                        if (board[bx][by] == 'O') {
                            check[1] = true;
                            break;
                        }
                    }

                    // int[] red = move(now[0], now[1], i, 0);
                    // int[] blue = move(now[2], now[3], i, 1);

                    if (check[1]) {
                        continue;
                    }

                    if (check[0]) {
                        System.out.println(count);
                        return;
                    }

                    if (rx == bx && ry == by) {
                        switch (i) {
                            case 0:
                                if (now[0] > now[2]) {
                                    bx--;
                                } else {
                                    rx--;
                                }
                                break;
                            case 1:
                                if (now[0] < now[2]) {
                                    bx++;
                                } else {
                                    rx++;
                                }

                                break;
                            case 2:
                                if (now[1] < now[3]) {
                                    by++;
                                } else {
                                    ry++;
                                }

                                break;

                            case 3:
                                if (now[1] > now[3]) {
                                    by--;
                                } else {
                                    ry--;
                                }

                                break;
                        }
                    }

                    // if (red[0] == blue[0] && red[1] == blue[1]) {
                    // switch (i) {
                    // case 0:
                    // if (now[0] > now[2]) {
                    // blue[0]--;
                    // } else {
                    // red[0]--;
                    // }
                    // break;
                    // case 1:
                    // if (now[0] > now[2]) {
                    // red[0]++;
                    // } else {
                    // blue[0]++;
                    // }

                    // break;
                    // case 2:

                    // if (now[1] > now[3]) {
                    // red[1]++;
                    // } else {
                    // blue[1]++;
                    // }

                    // break;

                    // case 3:

                    // if (now[1] > now[3]) {
                    // blue[1]--;
                    // } else {
                    // red[1]--;
                    // }

                    // break;
                    // }
                    // }

                    queue.offer(new int[] { rx,ry,bx,by });

                }

            }

            count++;
        }

        System.out.println(-1);

    }

    static int N, M;
    static char[][] board;
    static int[] dx = { 1, -1, 0, 0 };
    static int[] dy = { 0, 0, -1, 1 };
    static boolean[] check;

    static int[] move(int x, int y, int d, int color) {

        while (true) {

            x += dx[d];
            y += dy[d];

            if (board[x][y] == '#') {
                x -= dx[d];
                y -= dy[d];
                break;
            }

            if (board[x][y] == 'O') {
                check[color] = true;
                break;
            }
        }

        return new int[] { x, y };
    }
}
