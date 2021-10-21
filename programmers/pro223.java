package programmers;

import java.util.*;

public class pro223 {

    public static void main(String[] args) {

        int[][] rectangle = { { 1, 1, 7, 4 }, { 3, 2, 5, 5 }, { 4, 3, 6, 9 }, { 2, 6, 8, 8 } };
        int characterX = 1;
        int characterY = 3;
        int itemX = 7;
        int itemY = 8;

        System.out.println(solution(rectangle, characterX, characterY, itemX, itemY));

    }

    public static int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        answer = 0;

        map = new int[101][101]; // 0 = default , 1 = 다갹형 내부, 2 = 테두리

        characterX *= 2;
        characterY *= 2;
        itemX *= 2;
        itemY *= 2;

        for (int[] r : rectangle) {

            int x1 = r[0] * 2;
            int y1 = r[1] * 2;
            int x2 = r[2] * 2;
            int y2 = r[3] * 2;

            for (int i = y1; i <= y2; i++) {
                if (map[i][x1] != 1) {
                    map[i][x1] = 2;
                }
                if (map[i][x2] != 1) {
                    map[i][x2] = 2;
                }
            }

            for (int j = x1; j <= x2; j++) {
                if (map[y1][j] != 1) {
                    map[y1][j] = 2;
                }
                if (map[y2][j] != 1) {
                    map[y2][j] = 2;
                }
            }

            for (int i = y1 + 1; i < y2; i++) {
                for (int j = x1 + 1; j < x2; j++) {
                    map[i][j] = 1;
                }
            }
           
        }

        visit = new boolean[101][101];
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] { characterX, characterY });
        visit[characterY][characterX] = true;

        loop: while (!queue.isEmpty()) {

            int size = queue.size();

            while (size-- > 0) {

                int[] now = queue.poll();

                if (now[0] == itemX && now[1] == itemY) {
                    break loop;
                }

                for (int i = 0; i < 4; i++) {
                    int nx = now[0] + dx[i];
                    int ny = now[1] + dy[i];

                    if (nx < 0 || nx > 100 || ny < 0 || ny > 100 || map[ny][nx] != 2) {
                        continue;
                    }

                    if (visit[ny][nx]) {
                        continue;
                    }

                    visit[ny][nx] = true;

                    queue.add(new int[] { nx, ny });
                }

            }
            answer++;

        }

        return answer / 2;
    }

    static int answer;
    static int[][] map;
    static boolean[][] visit;
    static int[] dx = { 1, 0, 0, -1 };
    static int[] dy = { 0, 1, -1, 0 };

}
