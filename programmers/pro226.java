package programmers;

import java.util.Arrays;

/* 
    공 이동 시뮬레이션

    // 목표지점에 도착할 공들의 범위를 역으로 계산.. 
*/
public class pro226 {

    public static void main(String[] args) {

        int[][] queries = { {3,1},{2,2},{1,1},{2,3},{0,1},{2,1} };

        System.out.println(solution(2, 5, 0, 1, queries));



    }

    private static long solution(int n, int m, int x, int y, int[][] queries) {
        long answer = -1;

        long r1 = x;
        long r2 = x;
        long c1 = y;
        long c2 = y;

        for (int i = queries.length - 1; i >= 0; i--) {

            System.out.println(r1 + " " + r2 + " " + c1 +" " +c2);

            int dir = queries[i][0];
            int dist = queries[i][1];

            switch (dir) {
                case 0:

                    if (c1 != 0) {
                        c1 += dist;
                    }

                    c2 = Math.min(c2 + dist, m - 1);

                    break;

                case 1:

                    c1 = Math.max(c1 - dist, 0);

                    if (c2 != m - 1) {
                        c2 -= dist;
                    }

                    break;
                case 2:

                    if (r1 != 0) {
                        r1 += dist;
                    }

                    r2 = Math.min(r2 + dist, n - 1);

                    break;
                case 3:

                    r1 = Math.max(r1 - dist, 0);

                    if (r2 != n - 1) {
                        r2 -= dist;
                    }

                    break;
            }

            if (r1 >= n || r2 < 0 || c1 >= m || c2 < 0) {
                return answer;
            }

        }

        answer = (r2 - r1 + 1) * (c2 - c1 + 1);

        return answer;

    }
}
