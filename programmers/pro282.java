package programmers;
/*
 * 코딩테스트 연습 연습문제 인사고과
 */

import java.util.*;


public class pro282 {

    public static void main(String[] args) {

        int[][] scores = {{2, 2}, {1, 4}, {3, 2}, {3, 2}, {2, 1}};

        System.out.println(solution(scores));

    }

    public static int solution(int[][] scores) {

        int wonhoFirst = scores[0][0];
        int wonhoSecond = scores[0][1];
        int wonhoSum = scores[0][0] + scores[0][1];

        Arrays.sort(scores, (a, b) -> {
            if (a[0] == b[0]) {
                return a[1] - b[1];
            }
            return b[0] - a[0];
        });

        for (int[] score : scores) {
            System.out.println(score[0] + " , " + score[1]);
        }

        int maxSecond = 0;
        int rank = 1;

        for (int[] score : scores) {

            int first = score[0];
            int second = score[1];

            if (second < maxSecond) {

                if (first == wonhoFirst && second == wonhoSecond) {
                    return -1;
                }
            } else {

                maxSecond = second;

                if (first + second > wonhoSum) {
                    rank++;
                }
            }
        }

        return rank;
    }
}
