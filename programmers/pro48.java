package programmers;

import java.util.*;

public class pro48 {

    // 카카오 프렌즈 컬러링북
    public static void main(String[] args) {

        int[][] picture = { {1, 1, 1, 0}, {1, 1, 1, 0}, {0, 0, 0, 1}, {0, 0, 0, 1}, {0, 0, 0, 1}, {0, 0, 0, 1} };
        int m = 6;
        int n = 4;

        int[] answer = solution(m, n, picture);

        System.out.println(answer[0] + " " + answer[1]);

    }

    static int[] dx = { -1, 1, 0, 0 };
    static int[] dy = { 0, 0, -1, 1 };
    static boolean[][] visit;
    static int[][] map;

    static int w, h;

    static int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;

        visit = new boolean[m][n];
        map = picture.clone();
        w = n;
        h = m;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!visit[i][j] && picture[i][j] != 0) {
                    numberOfArea++;
                    maxSizeOfOneArea = Math.max(maxSizeOfOneArea, bfs(i, j));
               }
            }
        }

        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }

    static int bfs(int x, int y) {
        int count = 0;

        Queue<Integer[]> point = new LinkedList<>();

        point.add(new Integer[] { x, y });
        visit[x][y] = true;


        while (!point.isEmpty()) {

            int px = point.peek()[0];
            int py = point.poll()[1];

            count++;

            for (int i = 0; i < 4; i++) {
                int nx = px + dx[i];
                int ny = py + dy[i];

                if (nx >= 0 && nx < h && ny >= 0 && ny < w) {
                    if (!visit[nx][ny] && map[x][y] == map[nx][ny]) {
                        point.offer(new Integer[] { nx, ny });
                        visit[nx][ny] = true;
                    }
                }
            }
        }

        return count;
    }
}
