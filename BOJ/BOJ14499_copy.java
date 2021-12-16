package BOJ;

/* 
    주사위 굴리기

 */

import java.io.*;
import java.util.*;

public class BOJ14499_copy {

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

        List<Integer> horizontalDice = new ArrayList<>();
        List<Integer> verticalDice = new ArrayList<>();
        int[] dice = new int[7];

        horizontalDice.add(4);
        horizontalDice.add(1);
        horizontalDice.add(3);
        horizontalDice.add(6);

        verticalDice.add(1);
        verticalDice.add(5);
        verticalDice.add(6);
        verticalDice.add(2);

        StringBuilder sb = new StringBuilder();
        st = new StringTokenizer(br.readLine());

        while (K-- > 0) {
            int k = Integer.parseInt(st.nextToken());

            int nx = x + dx[k];
            int ny = y + dy[k];

            if (nx < 0 || nx >= N || ny < 0 || ny >= M) {
                continue;
            }

            switch (k) {
                case 1:

                    y++;
                    verticalDice.set(0, horizontalDice.get(2));
                    verticalDice.set(2, horizontalDice.get(0));

                    horizontalDice.add(horizontalDice.get(0));
                    horizontalDice.remove(0);

                    break;

                case 2:

                    y--;
                    verticalDice.set(0, horizontalDice.get(0));
                    verticalDice.set(2, horizontalDice.get(2));

                    horizontalDice.add(0, horizontalDice.get(3));
                    horizontalDice.remove(4);

                    break;
                case 3:

                    x--;

                    horizontalDice.set(1, verticalDice.get(3));
                    horizontalDice.set(3, verticalDice.get(1));

                    verticalDice.add(0, verticalDice.get(3));
                    verticalDice.remove(4);

                    break;
                case 4:

                    x++;

                    horizontalDice.set(1, verticalDice.get(1));
                    horizontalDice.set(3, verticalDice.get(3));

                    verticalDice.add(verticalDice.get(0));
                    verticalDice.remove(0);

                    break;
            }

            if (map[x][y] == 0) {
                map[x][y] = dice[verticalDice.get(0)];
            } else {
                dice[verticalDice.get(0)] = map[x][y];
                map[x][y] = 0;
            }

            sb.append(dice[horizontalDice.get(3)] + "\n");
        }

        System.out.println(sb.toString().trim());

    }

    static int[] dx = { 0, 0, 0, -1, 1 };
    static int[] dy = { 0, 1, -1, 0, 0 };
}
