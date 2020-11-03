package programmers;

import java.util.*;

//가장 큰 정사각형
// 시간초과

public class pro49_copy {

    public static void main(String[] args) {
        int[][] board = { { 0, 0, 0, 0 }, { 1, 1, 1, 1 } };
        System.out.println(solution(board));
    }

    static int solution(int[][] board) {
        int answer = 0;

        h = board.length;
        w = board[0].length;
        map = board.clone();

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                int len = Math.min(h - i, w - j);
                if (map[i][j] == 1 &&answer < len * len) {
                    answer = Math.max(answer, bfs(i, j));
                }
            }
        }

        return answer;
    }

    static int h, w;
    static int[][] map;
    static boolean[][] visit;

    static int bfs(int x, int y) {
        int count = 1;
        visit = new boolean[h][w];
        Queue<Integer[]> queue = new LinkedList<>();
        Queue<Integer[]> temp = new LinkedList<>();
        queue.offer(new Integer[] { x, y });
        visit[x][y] = true;

        int[] dx = { 0, 1, 1 };
        int[] dy = { 1, 1, 0 };

        boolean check = true;

        loop: while (true) {

            while (!queue.isEmpty()) {
                int px = queue.peek()[0];
                int py = queue.poll()[1];

                for (int i = 0; i < 3; i++) {
                    int nx = px + dx[i];
                    int ny = py + dy[i];

                    if (nx < h && ny < w) {
                        if (!visit[nx][ny]) {
                            if (map[nx][ny] == 1) {
                                temp.offer(new Integer[] { nx, ny });
                                visit[nx][ny] = true;
                            } else {
                                break loop;
                            }
                        }
                    } else {
                        break loop;
                    }
                }

            }

            queue.addAll(temp);
            count++;
        }

        return count * count;
    }
}