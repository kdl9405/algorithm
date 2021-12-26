package BOJ;

/* 
    낚시왕
*/

import java.io.*;
import java.util.*;

public class BOJ17143_copy {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[R + 1][C + 1][C + 1];

        Queue<Shark> queue = new LinkedList<>();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());

            if (d <=2) {
                s %= ((R-1)*2);
            }else{
                s %= ((C-1)*2);
            }

            queue.add(new Shark(r, c, s, d, z));

            map[r][c][1] = z;

        }

        int sum = 0;

        // 낚시꾼 이동
        for (int x = 1; x <= C; x++) {

            // 낚시
            for (int i = 1; i <= R; i++) {
                if (map[i][x][x] != 0) {
                    sum += map[i][x][x];
                    map[i][x][x] = 0;
                    break;
                }
            }

            // 상어 이동

            if (x == C) {
                break;
            }

            int size = queue.size();
            while (size-- > 0) {

                Shark shark = queue.poll();

                if (map[shark.r][shark.c][x] != shark.z) {
                    continue;
                }

                shark = move(shark);

                map[shark.r][shark.c][x + 1] = Math.max(map[shark.r][shark.c][x + 1], shark.z);
                queue.add(shark);

            }

        }

        System.out.println(sum);

    }

    static int R, C, M;
    static int[][][] map;
    static int[][] dir = { { 0, 0 }, { -1, 0 }, { 1, 0 }, { 0, 1 }, { 0, -1 } };

    private static class Shark {
        int r;
        int c;
        int s;
        int d;
        int z;

        public Shark(int r, int c, int s, int d, int z) {
            this.r = r;
            this.c = c;
            this.s = s;
            this.d = d;
            this.z = z;
        }
    }

    static Shark move(Shark shark) {

        // 상하 이동
        if (shark.d <= 2) {

            for (int i = 0; i < shark.s; i++) {
                shark.r += dir[shark.d][0];

                if (shark.r == 0 && shark.d == 1) {
                    shark.r = 2;
                    shark.d = 2;
                } else if (shark.r == R + 1 && shark.d == 2) {
                    shark.r = R - 1;
                    shark.d = 1;
                }

            }

        } else { // 좌우 이동
            for (int i = 0; i < shark.s; i++) {
                shark.c += dir[shark.d][1];
                if (shark.c == 0 && shark.d == 4) {
                    shark.c = 2;
                    shark.d = 3;
                } else if (shark.c == C + 1 && shark.d == 3) {
                    shark.c = C - 1;
                    shark.d = 4;
                }

            }
        }

        return shark;
    }
}
