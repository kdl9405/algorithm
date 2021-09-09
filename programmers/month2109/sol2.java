package programmers.month2109;

import java.util.*;

/* 

   1. 4방향에 따라 칸에 들어오는 빛.
   2. 다시 같은방향으로 시작에 들어오는 경우.

*/

public class sol2 {
    public static void main(String[] args) {

        String[] grid = { "SL", "LR" };

        int[] answer = solution(grid);

        for (int a : answer) {
            System.out.println(a);
        }

    }

    public static int[] solution(String[] grid) {

        map = new char[grid.length][grid[0].length()];
        for (int i = 0; i < grid.length; i++) {
            map[i] = grid[i].toCharArray();
        }

        cycle = new ArrayList<>();

        visit = new boolean[grid.length][grid[0].length()][4];

        // for (int i = 0; i < grid.length; i++) {
        //     for (int j = 0; j < grid[0].length(); j++) {
        //         start = new int[] { i, j, 0 };
        //         findCycle(i, j, 0, 0);

        //         start = new int[] { i, j, 1 };
        //         findCycle(i, j, 1, 0);

        //         start = new int[] { i, j, 2 };
        //         findCycle(i, j, 2, 0);

        //         start = new int[] { i, j, 3 };
        //         findCycle(i, j, 3, 0);

        //     }
        // }

        start = new int[] { 0, 0, 0 };
        findCycle(0, 0, 0, 0);

        int[] answer = Arrays.stream(cycle.toArray()).mapToInt(i -> (int) i).toArray();
        Arrays.sort(answer);
        return answer;

    }

    static char[][] map;
    static List<Integer> cycle;
    static boolean[][][] visit;
    static int[] start;
    static int[] dx = { 1, -1, 0, 0 };
    static int[] dy = { 0, 0, -1, 1 }; // 0 : 상 1 : 하 2 : 좌 3 : 우

    static void findCycle(int r, int c, int d, int count) {

        if (r == map.length) {
            r = 0;
        }
        if (r < 0) {
            r = map.length - 1;
        }
        if (c == map[0].length) {
            c = 0;
        }
        if (c < 0) {
            c = map[0].length - 1;
        }

         System.out.println(r + " " + c + " " + d + " " + count);

        if (r == start[0] && c == start[1] && d == start[2] && count != 0) {
            cycle.add(count);
            return;
        }

        if (r < start[0] && c < start[1] && d < start[2]) {
            return;
        }

        if (visit[r][c][d]) {
            return;
        }

        visit[r][c][d] = true;

        switch (map[r][c]) {
            case 'S':

                findCycle(r + dx[d], c + dy[d], d, count + 1);

                break;

            case 'L':

                if (d == 0) {
                    d = 2;
                } else if (d == 1) {
                    d = 3;
                } else if (d == 2) {
                    d = 1;
                } else {
                    d = 0;
                }

                findCycle(r + dx[d], c + dy[d], d, count + 1);

                break;
            case 'R':

                if (d == 0) {
                    d = 3;
                } else if (d == 1) {
                    d = 2;
                } else if (d == 2) {
                    d = 0;
                } else {
                    d = 1;
                }
                findCycle(r + dx[d], c + dy[d], d, count + 1);

                break;
        }

    }
}
