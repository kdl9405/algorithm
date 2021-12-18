package BOJ;

/* 
    탈출 
*/

import java.io.*;
import java.util.*;

public class BOJ3055 {

    static int[][] move = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        char[][] forest = new char[R][C];

        Queue<int[]> hedgehog = new LinkedList<>();
        Queue<int[]> water = new LinkedList<>();
        boolean[][] visit = new boolean[R][C];

        for (int i = 0; i < R; i++) {
            String input = br.readLine();
            for (int j = 0; j < C; j++) {
                forest[i][j] = input.charAt(j);

                if (input.charAt(j) == 'S') {
                    hedgehog.add(new int[] { i, j });
                    forest[i][j] = '.';
                    visit[i][j] = true;

                } else if (input.charAt(j) == '*') {
                    water.add(new int[] { i, j });
                }

            }
        }

        int count = 0;

        while (!hedgehog.isEmpty()) {

            count++;

            // 물 이동
            int size = water.size();
            while (size-- > 0) {

                int[] w = water.poll();

                for (int i = 0; i < 4; i++) {
                    int wr = w[0] + move[i][0];
                    int wc = w[1] + move[i][1];

                    if (wr < 0 || wr >= R || wc < 0 || wc >= C || forest[wr][wc] != '.') {
                        continue;
                    }

                    forest[wr][wc] = '*';
                    water.add(new int[] { wr, wc });
                }
            }

            // 고슴도치 이동
            size = hedgehog.size();
            while (size-- > 0) {

                int[] h = hedgehog.poll();

                for (int i = 0; i < 4; i++) {
                    int hr = h[0] + move[i][0];
                    int hc = h[1] + move[i][1];

                    if (hr < 0 || hr >= R || hc < 0 || hc >= C || visit[hr][hc] || forest[hr][hc] == '*'
                            || forest[hr][hc] == 'X') {
                        continue;
                    }

                    if (forest[hr][hc] == 'D') {
                        System.out.println(count);
                        return;
                    }

                    visit[hr][hc] = true;
                    hedgehog.add(new int[] { hr, hc });

                }
            }

        }

        System.out.println("KAKTUS");

    }

}


