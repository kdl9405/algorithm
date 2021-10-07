package programmers.month2110;

import java.util.*;

/* 
    
*/

public class sol3_copy2 {

    public static void main(String[] args) {

        int n = 2;
        int m = 2;
        int x = 0;
        int y = 0;

        int[][] queries = { { 2, 1 }, { 0, 1 }, { 1, 1 }, { 0, 1 }, { 2, 1 } };

        System.out.println(solution(n, m, x, y, queries));

    }

    public static long solution(int n, int m, int x, int y, int[][] queries) {

        long answer = 0;

        query = new ArrayList<>();

        for (int[] q : queries) {
            for (int i = 0; i < q[1]; i++) {
                query.add(q[0]);
            }
        }

        boolean[][][] visit = new boolean[query.size()][n][m];

        int index = query.size() - 1;

        Queue<point> queue = new LinkedList<>();
        queue.add(new point(x, y));

        while (index >= 0) {

            int size = queue.size();

            while (size-- > 0) {

                point now = queue.poll();

                if (now.y == 0 && query.get(index) == 0) {

                    if (!visit[index][now.x][0]) {
                        visit[index][now.x][0] = true;
                        queue.add(new point(now.x, 0));
                    }

                    if (m > 1) {
                        if (!visit[index][now.x][1]) {
                            visit[index][now.x][1] = true;
                            queue.add(new point(now.x, 1));
                        }
                    }

                    continue;
                }

                if (now.y == m - 1 && query.get(index) == 1) {

                    if (!visit[index][now.x][m - 1]) {
                        visit[index][now.x][m - 1] = true;
                        queue.add(new point(now.x, m - 1));
                    }

                    if (m - 2 >= 0) {
                        if (!visit[index][now.x][m - 2]) {
                            visit[index][now.x][m - 2] = true;
                            queue.add(new point(now.x, m - 2));
                        }
                    }

                    continue;
                }
                if (now.x == 0 && query.get(index) == 2) {

                    if (!visit[index][0][now.y]) {
                        visit[index][0][now.y] = true;
                        queue.add(new point(0, now.y));
                    }

                    if (n > 1) {
                        if (!visit[index][1][now.y]) {
                            visit[index][1][now.y] = true;
                            queue.add(new point(1, now.y));
                        }
                    }

                    continue;
                }

                if (now.x == n - 1 && query.get(index) == 3) {

                    if (!visit[index][n - 1][now.y]) {
                        visit[index][n - 1][now.y] = true;
                        queue.add(new point(n - 1, now.y));
                    }

                    if (n - 2 >= 0) {
                        if (!visit[index][n - 2][now.y]) {
                            visit[index][n - 2][now.y] = true;
                            queue.add(new point(n - 2, now.y));
                        }
                    }
                    continue;
                }

                int nx = now.x;
                int ny = now.y;

                switch (query.get(index)) {
                    case 0:

                        ny++;

                        break;

                    case 1:

                        ny--;

                        break;
                    case 2:

                        nx++;
                        break;
                    case 3:
                        nx--;
                        break;
                }

                nx = (nx+n)%n;
                ny = (ny+m)%m;

               // System.out.println(query.get(index) +" "+ nx +" " + ny);

                if (!visit[index][nx][ny]) {
                    visit[index][nx][ny] = true;
                    queue.add(new point(nx,ny));
                }

            }


            index--;

        }

        // for (point p : queue) {
        //     System.out.println(p.x + " " + p.y);
        // }

        return answer = queue.size();
    }

    static List<Integer> query;

}

class point {
    int x;
    int y;

    point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}