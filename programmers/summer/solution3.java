package programmers.summer;

import java.util.*;

// 맵 전체를 순회
// 제거 함수..
// max값의 좌표 기억

//19	6	17

public class solution3 {

    public static void main(String[] args) {

        int[][] maps = { { 1, 28, 41, 22, 25, 79, 4 }, { 39, 20, 10, 17, 19, 18, 8 }, { 21, 4, 13, 12, 9, 29, 19 },
                { 58, 1, 20, 5, 8, 16, 9 }, { 5, 6, 15, 2, 39, 8, 29 }, { 39, 7, 17, 5, 4, 49, 5 },
                { 74, 46, 8, 11, 25, 2, 11 } };

        int p = 19;
        int r = 6;

        System.out.println(solution(maps, p, r));
    }

    public static int solution(int[][] maps, int p, int r) {

        P = p;
        R = r / 2;
        map = maps.clone();

        int max = 0;

        for (int i = 0; i < maps.length; i++) {
            for (int j = 0; j < maps.length; j++) {

                max = Math.max(max, countE(i, j));

            }
        }

        return max;
    }

    static int P, R;
    static int[][] map;

    static int countE(int x, int y) {
        int count = 0;

        int r = (R - 1) * 2;

        int left = y - (R - 2);

        int t = 0;

        while (r >= 0) {

            int right = left + r;

            if (r > 0) {

                for (int j = left; j < map.length; j++) {
                    if (j < 0) {
                        j = 0;
                    }

                    if (j >= right) {
                        break;
                    }

                    if (x - t >= 0 && map[x - t][j] <= P) {
                        count++;
                    }

                    if (x + t + 1 < map.length && map[x + t + 1][j] <= P) {
                        count++;
                    }
                }
            }

            if (x - t >= 0) {
                if (left - 1 >= 0 && map[x - t][left - 1] <= P / 2) {
                    count++;
                }
                if (right < map.length && map[x - t][right] <= P / 2) {
                    count++;
                }
            }

            if (x + t + 1 < map.length) {
                if (left - 1 >= 0 && map[x + t + 1][left - 1] <= P / 2) {
                    count++;
                }
                if (right < map.length && map[x + t + 1][right] <= P / 2) {
                    count++;
                }
            }

            r -= 2;
            left++;
            t++;
        }
        return count;
    }

}
