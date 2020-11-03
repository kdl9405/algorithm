import java.util.*;

/**
 * [1차] 프렌즈4블록
 * 
 */
public class pro71 {

    public static void main(String[] args) {
        String[] board = { "TTTANT", "RRFACC", "RRRFCC", "TRRRAA", "TTMMMF", "TMMTTJ" };

        System.out.println(solution(6, 6, board));
    }

    static int solution(int m, int n, String[] board) {
        int answer = 0;

        map = new String[m][n];
        for (int i = 0; i < m; i++) {
            String[] str = board[i].split("");
            for (int j = 0; j < n; j++) {
                map[i][j] = str[j];
            }
        }

        while (true) {

            Queue<Integer[]> queue = check(m, n);

            if (queue.isEmpty()) {
                break;
            }

            while (!queue.isEmpty()) {
                int x = queue.peek()[0];
                int y = queue.poll()[1];

                if (!map[x][y].equals("*")) {
                    map[x][y] = "*";
                    answer++;
                }
            }

            for (int j = 0; j < n; j++) {

                Queue<String> line = new LinkedList<>();

                for (int i = m - 1; i >= 0; i--) {
                    if (!map[i][j].equals("*")) {
                        line.offer(map[i][j]);
                        map[i][j] = "*";
                    }
                }
                int i = m - 1;
                while (!line.isEmpty()) {
                    map[i][j] = line.poll();
                    i--;
                }
            }

        }

        return answer;
    }

    static int[] dx = { 0, 1, 1 };
    static int[] dy = { 1, 1, 0 };
    static String[][] map;

    static Queue<Integer[]> check(int m, int n) {
        Queue<Integer[]> queue = new LinkedList<>();

        for (int i = 0; i < m - 1; i++) {
            for (int j = 0; j < n - 1; j++) {
                if (!map[i][j].equals("*")) {
                    String x = map[i][j];
                    boolean same = true;

                    Queue<Integer[]> temp = new LinkedList<>();

                    for (int d = 0; d < 3; d++) {
                        int nx = i + dx[d];
                        int ny = j + dy[d];
                        if (!x.equals(map[nx][ny])) {
                            same = false;
                            break;
                        }
                        temp.offer(new Integer[] { nx, ny });

                    }
                    if (same) {
                        queue.offer(new Integer[] { i, j });
                        queue.addAll(temp);
                    }
                }
            }
        }
        return queue;
    }
}