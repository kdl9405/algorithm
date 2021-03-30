package BOJ;

import java.io.*;
import java.util.*;

/* 
    캐슬 디펜스

    완탐 => 848ms...
*/
public class BOJ17135_copy {

    static int N, M, D;
    static int[][] map;
    static int[][] testMap;
    static boolean[] visit;
    static int[] position;
    static int max;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        map = new int[N + 1][M];
        visit = new boolean[M];
        position = new int[3];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        max = Integer.MIN_VALUE;

        testMap = new int[N + 1][M];
        nCr(0, 0);

        System.out.println(max);

        /*
         * int p = 2; loop: for (int d = 1; d <= D; d++) { for (int i = d - 1; i >= 0;
         * i--) { if (p - i >= 0) {
         * 
         * System.out.println("left and mid " + (N - (d - i)) + " " + (p - i)); } }
         * 
         * for (int i = 1; i <= d - 1; i++) { if (p + i < M) {
         * System.out.println("right " + (N - (d - i)) + " " + (p + i)); } } }
         */

    }

    static void nCr(int depth, int x) {

        if (depth == 3) {
            // 궁수 자리 픽스 후 시뮬레이션 시작

            max = Math.max(max, simulation());

            return;
        }

        for (int i = x; i < M; i++) {
            if (!visit[i]) {
                visit[i] = true;
                position[depth] = i;
                nCr(depth + 1, x + 1);
                visit[i] = false;
            }
        }
    }

    static int simulation() {

        for (int i = 0; i < N; i++) {
            testMap[i] = map[i].clone();
        }

        int count = 0;

        for (int c = 0; c < N; c++) {

            HashSet<String> enemy = new HashSet<>();
            for (int p : position) {

                loop: for (int d = 1; d <= D; d++) {
                    for (int i = d - 1; i >= 0; i--) {
                        if (d - i <= N && p - i >= 0 && testMap[N - (d - i)][p - i] == 1) {

                            enemy.add((N - (d - i)) + " " + (p - i));

                            break loop;
                        }
                    }

                    for (int i = 1; i <= d - 1; i++) {
                        if (d - i <= N && p + i < M && testMap[N - (d - i)][p + i] == 1) {
                            enemy.add((N - (d - i)) + " " + (p + i));

                            break loop;
                        }
                    }
                }
            }

            if (!enemy.isEmpty()) {
                count += enemy.size();
                for (String e : enemy) {
                    String[] str = e.split(" ");
                    testMap[Integer.parseInt(str[0])][Integer.parseInt(str[1])] = 0;
                }
            }

            for (int i = N - 1; i > 0; i--) {
                testMap[i] = testMap[i - 1].clone();
            }

            Arrays.fill(testMap[0], 0);

        }

        return count;

    }
}
