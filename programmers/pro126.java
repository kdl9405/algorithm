package programmers;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/* 
    경주로 건설
*/
public class pro126 {
    public static void main(String[] args) {

        int[][] board = { { 0, 0, 0, 0, 0, 0 }, { 0, 1, 1, 1, 1, 0 }, { 0, 0, 1, 0, 0, 0 }, { 1, 0, 0, 1, 0, 1 },
                { 0, 1, 0, 0, 0, 1 }, { 0, 0, 0, 0, 0, 0 } };

        System.out.println(solution(board));

    }

    static int answer;
    static int[] dy = { 1, -1, 0, 0 };
    static int[] dx = { 0, 0, -1, 1 };
    static int[][] map;
    static int n;

    public static int solution(int[][] board) {
        answer = Integer.MAX_VALUE;
        map = board.clone();
        n = board.length;

        bfs(0, 0, -1, 0);

        return answer;
    }

    static void bfs(int x, int y, int dir, int cost) {
        Queue<car> queue = new LinkedList<>();
        queue.offer(new car(x, y, dir, cost));

        map[x][y] = 1;

        while (!queue.isEmpty()) {
            car now = queue.poll();

            if (now.x == n - 1 && now.y == n - 1) {
                answer = Math.min(answer, now.cost);
                continue;
            }

            for (int i = 0; i < 4; i++) {
                int ny = now.y + dy[i];
                int nx = now.x + dx[i];

                if (nx >= 0 && nx < n && ny >= 0 && ny < n) {

                    if (map[nx][ny] != 1) {
                        int c = now.cost;

                        if (now.dir == -1 || now.dir == i) {
                            c += 100;
                        } else if (now.dir != i) {
                            c += 600;
                        }

                        if (map[nx][ny] == 0 || map[nx][ny] >= c) {
                            map[nx][ny] = c;
                            queue.offer(new car(nx, ny, i, c));
                        }
                    }

                }
            }
        }
    }

}

class car {
    int x, y, dir, cost;

    public car(int x, int y, int dir, int cost) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.cost = cost;
    }
}
