package BOJ;

import java.io.*;

/* 
    나의 인생에는 수학과 함께

    // 완전탐색
*/
public class BOJ17265 {

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        map = new String[N][N];

        for (int i = 0; i < N; i++) {
            map[i] = br.readLine().split(" ");
        }

        dp = new int[N][N][2];

        min = Integer.MAX_VALUE;
        max = Integer.MIN_VALUE;

        find(0, 0, 0, ' ');

        System.out.println(max + " " + min);

    }

    static int N;
    static String[][] map;
    static int[][][] dp;

    static int[] dx = { 1, 0 };
    static int[] dy = { 0, 1 };

    static int min, max;

    static void find(int x, int y, int v, char f) {

        for (int i = 0; i < 2; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < N && ny < N) {

                if (map[x][y].charAt(0)=='+') {

                    find(nx, ny, v, '+');

                } else if (map[x][y].equals("-")) {
                    find(nx, ny, v, '-');

                } else if (map[x][y].equals("*")) {
                    find(nx, ny, v, '*');

                } else {

                    int num = Integer.parseInt(map[nx][ny]);

                    switch (f) {
                        case '+':

                            v += num;

                            break;

                        case '-':

                            v -= num;

                            break;
                        case '*':

                            v *= num;
                            break;
                    }

                    find(nx, ny, v, f);

                }
            } else if (nx == N && ny == N) {
                max = Math.max(max, v);
                min = Math.min(min, v);
            }
        }

    }
}
