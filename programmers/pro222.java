package programmers;

import java.util.*;

/* 
    10주차_교점에 별 만들기
*/

public class pro222 {

    public static void main(String[] args) {

        int[][] line = { { 0, 1, -1 }, { 1, 0, -1 }, { 1, 0, 1 } };

        String[] answer = solution(line);

        StringBuilder sb = new StringBuilder();
        for (String a : answer) {
            sb.append(a + "\n");
        }

        System.out.println(sb.toString());
    }

    public static String[] solution(int[][] line) {
        String[] answer = {};

        long minR = Long.MAX_VALUE;
        long maxR = Long.MIN_VALUE;
        long minC = Long.MAX_VALUE;
        long maxC = Long.MIN_VALUE;
        long A, B, C, D, E, F;
        long X, Y, base;

        HashSet<point> set = new HashSet<>();

        for (int i = 0; i < line.length - 1; i++) {

            A = line[i][0];
            B = line[i][1];
            E = line[i][2];

            for (int j = i + 1; j < line.length; j++) {

                C = line[j][0];
                D = line[j][1];
                F = line[j][2];

                base = ((A * D) - (B * C));

                if (base == 0) {
                    continue;
                }

                X = ((B * F) - (E * D));
                Y = (0 - ((E * C) - (A * F)));

                if (X != 0) {

                    if (X % base != 0) {
                        continue;
                    }

                    X /= base;
                }
                if (Y != 0) {
                    if (Y % base != 0) {
                        continue;
                    }
                    Y /= base;
                }

                minR = Math.min(minR, Y);
                maxR = Math.max(maxR, Y);

                minC = Math.min(minC, X);
                maxC = Math.max(maxC, X);

                set.add(new point(Y, X));

            }
        }

        char[][] map = new char[(int) Math.abs(maxR - minR) + 1][(int) Math.abs(maxC - minC) + 1];

        for (int i = 0; i < map.length; i++) {
            Arrays.fill(map[i], '.');
        }

        for (point p : set) {

            map[(int) (p.r - minR)][(int) (p.c - minC)] = '*';
        }

        answer = new String[map.length];
        for (int i = 0; i < map.length; i++) {
            answer[i] = new String(map[i]);
        }

        return answer;
    }

}

class point {
    long r;
    long c;

    public point(long r, long c) {
        this.r = r;
        this.c = c;

    }
}
