package programmers.month2110;

import java.util.*;

/* 

    5.9....

    아마 Hashset[][] 으로 dp 를 구성했다면..
    
*/

public class sol3 {

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

        // boolean[][][] visit = new boolean[query.size()][n][m];

        int index = query.size() - 1;

        Queue<String> queue = new LinkedList<>();
        queue.add(x + " " + y);

        while (index >= 0) {

            int size = queue.size();

            HashSet<String> set = new HashSet<>();

            while (size-- > 0) {

                int[] now = Arrays.stream(queue.poll().split(" ")).mapToInt(Integer::parseInt).toArray();

                if (now[1] == 0 && query.get(index) == 0) {

                    set.add(now[0] + " " + 0);

                    if (m > 1) {

                        set.add(now[0] + " " + 1);

                    }

                    continue;
                }

                if (now[1] == m - 1 && query.get(index) == 1) {

                    set.add(now[0] + " " + (m - 1));

                    if (m - 2 >= 0) {

                        set.add(now[0] + " " + (m - 2));

                    }

                    continue;
                }
                if (now[0] == 0 && query.get(index) == 2) {

                    set.add(0 + " " + now[1]);

                    if (n > 1) {

                        set.add(1 + " " + now[1]);

                    }

                    continue;
                }

                if (now[0] == n - 1 && query.get(index) == 3) {

                    set.add((n - 1) + " " + now[1]);

                    if (n - 2 >= 0) {

                        set.add((n - 2) + " " + now[1]);

                    }
                    continue;
                }

                int nx = now[0];
                int ny = now[1];

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

                nx = (nx + n) % n;
                ny = (ny + m) % m;

                // System.out.println(query.get(index) +" "+ nx +" " + ny);

                set.add(nx + " " + ny);

            }

            queue.addAll(set);

            index--;

        }

        // for (point p : queue) {
        // System.out.println(p.x + " " + p.y);
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