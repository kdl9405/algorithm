package programmers;

import java.util.*;

/*
    빛의 경로 사이클
*/
public class pro214 {

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

                    if (!visit[i][j][k]) {

                        int x = i;
                        int y = j;
                        int d = k;

                        int count = 0;
                        while (!visit[x][y][d]) {
                            visit[x][y][d] = true;
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
                            x = (x + dx[d] + N) % N;
                            y = (y + dy[d] + M) % M;
                            count++;

                        }

                        if (count > 0) {
                            cycle.add(count);
                        }

                    }

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

}