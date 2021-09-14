package programmers;

import java.util.*;

/*
    빛의 경로 사이클

    // 7번 테케 => 런타임 에러
*/
public class pro214_copy {

    public static void main(String[] args) {

        String[] grid = { "R", "R" };

        solution(grid);

    }

    public static int[] solution(String[] grid) {
        int[] answer = {};

        N = grid.length;
        M = grid[0].length();

        map = new char[N][M];
        for (int i = 0; i < N; i++) {
            map[i] = grid[i].toCharArray();
        }

        visit = new boolean[N][M][4];
        cycle = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                for (int k = 0; k < 4; k++) {
                    dfs(i, j, k, 0, i, j, k);
                }
            }
        }

        answer = Arrays.stream(cycle.toArray()).mapToInt(i -> (int) i).toArray();

        Arrays.sort(answer);

        return answer;
    }

    static int N, M;
    static char[][] map;
    static boolean[][][] visit;
    // 빛의 방향
    static int[] dx = { 0, 1, 0, -1 }; // 우, 하, 좌, 상
    static int[] dy = { 1, 0, -1, 0 };
    static List<Integer> cycle;

    static void dfs(int x, int y, int d, int count, int sx, int sy, int sd) {

        switch (map[x][y]) {
            case 'S':

                // D 그대로.

                break;

            case 'L':

                // 0 => 3
                // 1 => 0
                // 2 => 1
                // 3 => 2

                d = (d + 3) % 4;

                break;
            case 'R':

                // 0 => 1
                // 1 => 2
                // 2 => 3
                // 3 => 0

                d = (d + 1) % 4;

                break;
        }

        int nx = (x + dx[d] + N) % N;
        int ny = (y + dy[d] + M) % M;

        if (!visit[nx][ny][d]) {

            visit[nx][ny][d] = true;

            dfs(nx, ny, d, count + 1, sx, sy, sd);

        } else if (count > 0) {
            cycle.add(count);
        }

        return;
    }

}