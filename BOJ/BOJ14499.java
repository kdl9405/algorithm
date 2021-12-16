package BOJ;

/* 
    주사위 굴리기

 */

import java.io.*;
import java.util.*;

public class BOJ14499 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[][] map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[] dice = new int[7];

        StringBuilder sb = new StringBuilder();
        st = new StringTokenizer(br.readLine());

        while (K-- > 0) {
            int k = Integer.parseInt(st.nextToken());

            int nx = x + dx[k];
            int ny = y + dy[k];

            if (nx < 0 || nx >= N || ny < 0 || ny >= M) {
                continue;
            }

            int temp;

            switch (k) {
                case 1:

                    y++;

                    temp = dice[4];
                    dice[4] = dice[1];
                    dice[1] = dice[3];
                    dice[3] = dice[6];
                    dice[6] = temp;

                    break;

                case 2:

                    y--;

                    temp = dice[3];
                    dice[3] = dice[1];
                    dice[1] = dice[4];
                    dice[4] = dice[6];
                    dice[6] = temp;

                    break;
                case 3:

                    x--;

                    temp = dice[1];
                    dice[1] = dice[2];
                    dice[2] = dice[6];
                    dice[6] = dice[5];
                    dice[5] = temp;

                    break;
                case 4:

                    x++;

                    temp = dice[1];
                    dice[1] = dice[5];
                    dice[5] = dice[6];
                    dice[6] = dice[2];
                    dice[2] = temp;

                    break;
            }

            if (map[x][y] == 0) {
                map[x][y] = dice[1];
            } else {
                dice[1] = map[x][y];
                map[x][y] = 0;
            }

            sb.append(dice[6] + "\n");
        }

        System.out.println(sb.toString().trim());

    }

    static int[] dx = { 0, 0, 0, -1, 1 };
    static int[] dy = { 0, 1, -1, 0, 0 };
}
