package BOJ;

/* 
    감시
*/

import java.io.*;
import java.util.*;

public class BOJ15683 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        office = new int[N][M];
        cctvList = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                int t = Integer.parseInt(st.nextToken());

                if (t > 0 && t < 6) {
                    cctvList.add(new Cctv(i, j, t));
                    office[i][j] = -1;
                } else if (t == 6) {
                    office[i][j] = 6;
                }
            }

        }

        blind = N * M;

        dfs(0);

        System.out.println(blind);

    }

    static int N, M, blind;
    static int[][] office;
    static List<Cctv> cctvList;

    static int[][] dir = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };

    private static class Cctv {
        int r;
        int c;
        int type;

        public Cctv(int r, int c, int type) {
            this.r = r;
            this.c = c;
            this.type = type;
        }

    }

    static void dfs(int index) {

        if (index == cctvList.size()) {
            // 사각지대 체크.
            int sum = 0;

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {

                    if (office[i][j] == 0) {
                        sum++;
                    }
                }
            }

            blind = Math.min(blind, sum);

            return;
        }

        // cctv 방향 변경

        rotate(index);

    }

    static void watch(int r, int c, int d) {

        int nr = r;
        int nc = c;
        while (true) {
            nr += dir[d][0];
            nc += dir[d][1];
            if (nr < 0 || nr >= N || nc < 0 || nc >= M || office[nr][nc] == 6) {
                break;
            }
            office[nr][nc]--;

        }

        return;

    }

    static void unDoWatch(int r, int c, int d) {
        int nr = r;
        int nc = c;
        while (true) {
            nr += dir[d][0];
            nc += dir[d][1];
            if (nr < 0 || nr >= N || nc < 0 || nc >= M || office[nr][nc] == 6) {
                break;
            }
            office[nr][nc]++;

        }

        return;

    }

    static void rotate(int index) {

        if (index == cctvList.size()) {

            return;
        }

        int r = cctvList.get(index).r;
        int c = cctvList.get(index).c;
        int t = cctvList.get(index).type;

        switch (t) {
            case 1:

                for (int i = 0; i < 4; i++) {

                    watch(r, c, i);
                    dfs(index + 1);
                    unDoWatch(r, c, i);

                }

                break;
            case 2:

                for (int i = 0; i < 2; i++) {

                    watch(r, c, i);
                    watch(r, c, (i + 2) % 4);

                    dfs(index + 1);

                    unDoWatch(r, c, i);
                    unDoWatch(r, c, (i + 2) % 4);
                }
                break;

            case 3:

                watch(r, c, 0);
                watch(r, c, 1);

                for (int i = 0; i < 4; i++) {
                    dfs(index + 1);
                    unDoWatch(r, c, i);
                    watch(r, c, (i + 2) % 4);
                }

                unDoWatch(r, c, 0);
                unDoWatch(r, c, 1);

                break;
            case 4:

                watch(r, c, 1);
                watch(r, c, 2);
                watch(r, c, 3);

                for (int i = 0; i < 4; i++) {

                    dfs(index + 1);

                    watch(r, c, i);
                    unDoWatch(r, c, (i + 1) % 4);
                }

                unDoWatch(r, c, 1);
                unDoWatch(r, c, 2);
                unDoWatch(r, c, 3);

                break;

            default: // 5
                watch(r, c, 0);
                watch(r, c, 1);
                watch(r, c, 2);
                watch(r, c, 3);

                dfs(index + 1);

                unDoWatch(r, c, 0);
                unDoWatch(r, c, 1);
                unDoWatch(r, c, 2);
                unDoWatch(r, c, 3);
                break;
        }

        return;

    }

}
