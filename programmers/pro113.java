package programmers;

import java.util.*;

/**
 * [카카오 인턴] 경주로 건설 98
 */
public class pro113 {

    public static void main(String[] args) {
        int[][] board = { { 0, 0, 1, 0, 1, 1, 0, 0, 0, 0 }, { 0, 0, 0, 0, 1, 0, 1, 1,
        0, 1 },
        { 1, 0, 0, 0, 0, 1, 1, 0, 1, 0 }, { 0, 0, 0, 0, 0, 0, 1, 0, 0, 0 }, { 0, 0,
        0, 0, 1, 0, 1, 0, 1, 1 },
        { 0, 0, 1, 0, 1, 1, 0, 1, 0, 1 }, { 0, 1, 0, 0, 1, 0, 0, 0, 1, 0 }, { 1, 0,
        0, 1, 0, 0, 0, 0, 0, 0 },
        { 0, 0, 0, 0, 0, 1, 0, 1, 0, 0 }, { 1, 0, 0, 0, 0, 0, 0, 0, 1, 0 } };

        // int[][] board = { { 0, 0, 0, 0, 0, 0, 0, 1 }, { 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 1, 0, 0 },
        //         { 0, 0, 0, 0, 1, 0, 0, 0 }, { 0, 0, 0, 1, 0, 0, 0, 1 }, { 0, 0, 1, 0, 0, 0, 1, 0 },
        //         { 0, 1, 0, 0, 0, 1, 0, 0 }, { 1, 0, 0, 0, 0, 0, 0, 0 } };

        System.out.println(solution(board));
    }

    // 위치와 방향을 보관
    // 방향이 바뀌면 +500
    // 칸 이동시 +100

    static int solution(int[][] board) {
        int answer = 0;
        int len = board.length;
        cost = new int[len][len][2];
        visit = new int[len][len][2];

        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                cost[i][j][0] = 10000000;
                cost[i][j][1] = 10000000;
            }
        }

        PriorityQueue<Integer[]> queue = new PriorityQueue<>(new Comparator<Integer[]>() {
            @Override
            public int compare(Integer[] o1, Integer[] o2) {
                return (cost[o1[0]][o1[1]][0]+cost[o1[0]][o1[1]][1]) - (cost[o2[0]][o2[1]][0]+ cost[o2[0]][o2[1]][1]);
            }
        });

        if (board[0][1] == 0) {
            queue.offer(new Integer[] { 0, 1, 1}); // 0은 가로방향, 1은 세로방향
            cost[0][1][0] = 100;
            visit[0][1][0] = 3;
        }

        if (board[1][0] == 0) {
            queue.offer(new Integer[] { 1, 0, 1});
            cost[1][0][1] = 100;
            visit[1][0][1] = 3;
        }

        visit[0][0][0] = 3;
        visit[0][0][1] = 3;

        while (!queue.isEmpty()) {
            Integer[] now = queue.poll();
            int x = now[0];
            int y = now[1];
            int dis = now[2];

            System.out.println(x + " " + y + " " + cost[x][y][0] + " " + cost[x][y][1]);

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 0 && nx < len && ny >= 0 && ny < len) {

                    if (board[nx][ny] == 1) {
                        continue;
                    }

                    if (nx == x && visit[nx][ny][0] < 3) {
                        visit[nx][ny][0]++;
                        cost[nx][ny][0] = Math.min(cost[x][y][0], (cost[x][y][1] + 500)) + 100;
                        queue.offer(new Integer[] { nx, ny ,dis+1});
                    }

                    if (ny == y && visit[nx][ny][1] < 3) {
                        visit[nx][ny][1]++;
                        cost[nx][ny][1] = Math.min(cost[x][y][1], (cost[x][y][0] + 500)) + 100;
                        queue.offer(new Integer[] { nx, ny, dis+1});
                    }
                }
            }
        }

        answer = Math.min(cost[len - 1][len - 1][0], cost[len - 1][len - 1][1]);

        return answer;
    }

    static int[][][] cost;
    static int[][][] visit;
    static int[] dx = { 0, 0, -1, 1 };
    static int[] dy = { -1, 1, 0, 0 };

}