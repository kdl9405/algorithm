package programmers;

import java.util.*;

/* 
    퍼즐 조각 채우기

    !! 리팩토링 필요!!
*/
public class pro189 {

    public static void main(String[] args) {

        int[][] game_board =
        {{1,1,0,0,1,0},{0,0,1,0,1,0},{0,1,1,0,0,1},{1,1,0,1,1,1},{1,0,0,0,1,0},{0,1,1,1,0,0}};
        int[][] table =
        {{1,0,0,1,1,0},{1,0,1,0,1,0},{0,1,1,0,1,1},{0,0,1,0,0,0},{1,1,0,1,1,0},{0,1,0,0,0,0}};

        // int[][] game_board = { { 1, 1, 1, 1, 1, 0 }, { 1, 1, 1, 1, 1, 0 }, { 1, 1, 1, 1, 1, 1 }, { 1, 1, 1, 1, 1, 1 },
        //         { 1, 1, 1, 1, 1, 1 }, { 1, 1, 1, 1, 1, 1 } };
        // int[][] table = { { 1, 1, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0 },
        //         { 0, 0, 0, 1, 1, 0 }, { 0, 0, 0, 0, 0, 0 } };

        System.out.println(solution(game_board, table));

    }

    public static int solution(int[][] game_board, int[][] table) {
        int answer = 0;

        size = game_board.length;

        space = new LinkedList<>();
        puzzle = new LinkedList<>();

        visit = new boolean[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (!visit[i][j] && game_board[i][j] == 0) {

                    visit[i][j] = true;
                    points = new HashSet<>();
                    points.add(new int[] { i, j });
                    find(game_board, i, j, 0);

                    int[][] s = toUnit();
                    space.add(s);
                }
            }
        }

        visit = new boolean[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (!visit[i][j] && table[i][j] == 1) {

                    visit[i][j] = true;
                    points = new HashSet<>();
                    points.add(new int[] { i, j });
                    find(table, i, j, 1);

                    puzzle.add(toUnit());
                }
            }
        }

        boolean[] used = new boolean[puzzle.size()];

        for (int x = 0; x < space.size(); x++) {

            int countX = 0;
            for (int i = 0; i < 6; i++) {
                for (int j = 0; j < 6; j++) {

                    if (space.get(x)[i][j] == 1) {
                        countX++;
                    }
                }
            }

            for (int y = 0; y < puzzle.size(); y++) {

                if (used[y]) {
                    continue;
                }

                int countY = 0;

                for (int i = 0; i < 6; i++) {
                    for (int j = 0; j < 6; j++) {

                        if (puzzle.get(y)[i][j] == 1) {
                            countY++;
                        }
                    }
                }

                if (countX == countY) {

                    if (compare(space.get(x), puzzle.get(y))) {
                        used[y] = true;
                        answer += countX;
                        break;
                    }
                }
            }
        }

        return answer;
    }

    static int size;
    static boolean[][] visit;
    static HashSet<int[]> points;
    static List<int[][]> space;
    static List<int[][]> puzzle;

    static int[] dx = { -1, 1, 0, 0 };
    static int[] dy = { 0, 0, -1, 1 };

    public static void find(int[][] board, int x, int y, int c) {

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && nx < size && ny >= 0 && ny < size) {
                if (!visit[nx][ny] && board[nx][ny] == c) {
                    visit[nx][ny] = true;
                    points.add(new int[] { nx, ny });
                    find(board, nx, ny, c);
                }
            }
        }
    }

    public static int[][] toUnit() {

        int[][] unit = new int[6][6];

        int minX = size;
        int minY = size;

        for (int[] p : points) {
            minX = Math.min(minX, p[0]);
            minY = Math.min(minY, p[1]);
        }

        for (int[] p : points) {
            unit[p[0] - minX][p[1] - minY] = 1;
        }

        return unit;
    }

    public static boolean compare(int[][] x, int[][] y) {

        for (int z = 0; z < 4; z++) {

            boolean check = true;

            loop: for (int i = 0; i < 6; i++) {
                for (int j = 0; j < 6; j++) {
                    if (x[i][j] != y[i][j]) {
                        check = false;
                        break loop;
                    }
                }
            }

            if (check) {
                return true;
            }

            y = rotate(y);
        }

        return false;
    }

    public static int[][] rotate(int[][] x) {


        int[][] y = new int[6][6];

        int minX = 6;
        int minY = 6;

        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                y[i][j] = x[6 - 1 - j][i];

                if (y[i][j] == 1) {
                    minX = Math.min(minX, i);
                    minY = Math.min(minY, j);
                }
            }
        }

        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {

                if (y[i][j] == 1) {
                    y[i - minX][j - minY] = 1;
                    y[i][j] = 0;
                }

            }
        }

        return y;

    }

}
