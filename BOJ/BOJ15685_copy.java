package boj;

import java.io.*;
import java.util.*;

/*
 * 드래곤 커브
 */
public class BOJ15685_copy {
    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        map = new boolean[101][101];
        genration = new int[4][1024];

        for (int i = 0; i < 4; i++) {
            Arrays.fill(genration[i], -1);
            genration[i][0] = i;
        }

        while (n-- > 0) {
            st = new StringTokenizer(br.readLine());
            int y = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int g = Integer.parseInt(st.nextToken());

            drawing(x, y, d, g);
        }

        int count = 0;

        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                if (map[i][j]) {
                    if (map[i + 1][j] && map[i + 1][j + 1] && map[i][j + 1]) {
                        count++;
                    }
                }
            }
        }

        System.out.println(count);

    }

    static boolean[][] map;
    static int[][] genration;
    static int[][] direction = {{0, 1}, {-1, 0}, {0, -1}, {1, 0}};

    static void drawing(int x, int y, int d, int g) {

        fill(d, g);

        int last = (int) Math.pow(2, g);

        map[x][y] = true;
        for (int i = 0; i < last; i++) {
            x += direction[genration[d][i]][0];
            y += direction[genration[d][i]][1];

            map[x][y] = true;
        }
        return;
    }

    static void fill(int d, int g) {

        if (genration[d][(int) Math.pow(2, g) - 1] != -1) {
            return;
        }

        fill(d, g - 1);

        int i = (int) Math.pow(2, g - 1) - 1;
        int j = i + 1;

        for (; i >= 0; i--) {
            if (genration[d][i] == 3) {
                genration[d][j] = 0;
            } else {
                genration[d][j] = genration[d][i] + 1;
            }
            j++;
        }

        return;
    }
}
