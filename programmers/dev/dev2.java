package programmers.dev;

public class dev2 {

    public static void main(String[] args) {

    }

    static int[][] map;

    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];

        map = new int[rows + 1][columns + 1];

        int num = 1;
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= columns; j++) {
                map[i][j] = (num++);
            }
        }

        for (int i = 0; i < queries.length; i++) {

            // 회전

            answer[i] = rotateAndMin(queries[i][0], queries[i][1], queries[i][2], queries[i][3]);

        }

        return answer;
    }

    static int rotateAndMin(int x1, int y1, int x2, int y2) {

        int init = map[x1][y1];
        int min = init;

        for (int i = x1; i < x2; i++) { // 위로 이동
            map[i][y1] = map[i + 1][y1];

            min = Math.min(min, map[i][y1]);
        }

        for (int i = y1; i < y2; i++) { // 좌로 이동
            map[x2][i] = map[x2][i + 1];

            min = Math.min(min, map[x2][i]);

        }

        for (int i = x2; i > x1; i--) { // 아래로 이동
            map[i][y2] = map[i - 1][y2];

            min = Math.min(min, map[i][y2]);

        }

        for (int i = y2; i > y1; i--) {

            if (i == y1 + 1) {
                map[x1][i] = init;
                break;
            }

            map[x1][i] = map[x1][i - 1];

            min = Math.min(min, map[x1][i]);

        }
        return min;
    }
}
