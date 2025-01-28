package boj;

import java.io.*;
import java.util.*;

/*
 * 상범 빌딩
 */
public class BOJ6593 {

    public static void main(String[] args) throws IOException {

        new BOJ6593().solution();

    }

    void solution() throws IOException {

        answer = new StringBuilder();

        while (init()) {

            escape();
        }

        System.out.println(answer.toString().trim());

    }

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    int L, R, C;
    char[][][] building;
    int[] start;
    StringBuilder answer;
    int[][] move = {{1, 0, 0}, {-1, 0, 0}, {0, 1, 0}, {0, -1, 0}, {0, 0, 1}, {0, 0, -1}};

    boolean init() throws IOException {

        st = new StringTokenizer(br.readLine());

        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        if (L == 0 && R == 0 && C == 0) {
            return false;
        }

        building = new char[L][R][C];

        for (int l = 0; l < L; l++) {
            for (int r = 0; r < R; r++) {

                char[] line = br.readLine().toCharArray();
                for (int c = 0; c < C; c++) {
                    if (line[c] == 'S') {
                        start = new int[] {l, r, c};
                    }
                    building[l][r][c] = line[c];
                }
            }
            br.readLine();
        }

        return true;
    }

    void escape() {

        boolean[][][] isVisted = new boolean[L][R][C];

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {start[0], start[1], start[2]});
        isVisted[start[0]][start[1]][start[2]] = true;

        int min = 0;

        while (!queue.isEmpty()) {
            min++;
            int size = queue.size();

            while (size-- > 0) {

                int[] now = queue.poll();

                for (int d = 0; d < 6; d++) {
                    int nl = now[0] + move[d][0];
                    int nr = now[1] + move[d][1];
                    int nc = now[2] + move[d][2];

                    if (nl < 0 || nl >= L || nc < 0 || nc >= C || nr < 0 || nr >= R) {
                        continue;
                    }

                    if (building[nl][nr][nc] == 'E') {
                        answer.append("Escaped in ").append(min).append(" minute(s).\n");
                        return;
                    }

                    if (!isVisted[nl][nr][nc] && building[nl][nr][nc] == '.') {
                        isVisted[nl][nr][nc] = true;
                        queue.add(new int[] {nl, nr, nc});
                    }
                }
            }
        }

        answer.append("Trapped!\n");
    }
}
