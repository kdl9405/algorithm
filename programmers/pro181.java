package programmers;

import java.util.*;
/*
    최적의 행렬 곱셈

    DP 이용
*/

public class pro181 {

    public static void main(String[] args) {

        int[][] matrix_sizes = { { 1, 2 }, { 2, 3 }, { 3, 4 }, { 4, 5 }, { 5, 6 } };

        System.out.println(solution(matrix_sizes));
    }

    static int dp[][]; // i~j까지 범위의 최소값.

    static public int solution(int[][] matrix_sizes) {
        int answer = 0;
        int size = matrix_sizes.length;
        dp = new int[size][size];

        answer = findDP(0, size - 1, matrix_sizes);

        return answer;
    }

    static public int findDP(int x, int y, int[][] matrix) {

        if (x == y) {
            return 0;
        }

        if (dp[x][y] != 0) {
            return dp[x][y];
        }

        int min = Integer.MAX_VALUE;

        for (int i = x; i < y; i++) {
            min = Math.min(min,
                    findDP(x, i, matrix) + findDP(i + 1, y, matrix) + (matrix[x][0] * matrix[i][1] * matrix[y][1]));
        }

        return dp[x][y] = min;
    }
}