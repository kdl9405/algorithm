package boj;

import java.io.*;

/*
 * Puyo Puyo
 */

import java.util.*;

public class BOJ11559 {

    public static void main(String[] args) throws IOException {

        new BOJ11559().solution();
    }

    void solution() throws IOException {

        init();

        int answer = 0;
        while (true) {
            if (!destroy()) {
                break;
            }

            answer++;

            drop();

        }

        System.out.println(answer);

    }

    char[][] field;
    boolean[][] visit;
    int[][] move = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        field = new char[12][6];

        for (int i = 0; i < 12; i++) {
            field[i] = br.readLine().toCharArray();
        }
    }

    boolean destroy() {

        boolean check = false;

        visit = new boolean[12][6];
        int count = 0;
        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 6; j++) {
                if (visit[i][j] || field[i][j] == '.') {
                    continue;
                }

                if (bfs(i, j)) {
                    check = true;
                }
            }
        }

        return check;
    }

    boolean bfs(int r, int c) {

        char color = field[r][c];

        List<int[]> candidate = new ArrayList<>();
        candidate.add(new int[] {r, c});

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {r, c});
        visit[r][c] = true;

        while (!queue.isEmpty()) {
            int[] now = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nr = now[0] + move[i][0];
                int nc = now[1] + move[i][1];

                if (nr < 0 || nr >= 12 || nc < 0 || nc >= 6) {
                    continue;
                }

                if (visit[nr][nc] || field[nr][nc] != color) {
                    continue;
                }

                visit[nr][nc] = true;
                queue.add(new int[] {nr, nc});
                candidate.add(new int[] {nr, nc});
            }
        }

        if (candidate.size() >= 4) {

            for (int[] t : candidate) {
                field[t[0]][t[1]] = '.';
            }

            return true;
        } else {
            return false;
        }
    }

    void drop() {

        for (int c = 0; c < 6; c++) {

            int x = 10;
            for (int r = 11; r > 0; r--) {

                if (field[r][c] != '.') {
                    continue;
                }

                for (x = Math.min(x, r - 1); x >= 0; x--) {
                    if (field[x][c] != '.') {
                        field[r][c] = field[x][c];
                        field[x][c] = '.';
                        break;
                    }
                }
            }
        }
    }

}


