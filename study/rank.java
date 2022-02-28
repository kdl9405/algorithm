package study;

/**
 * rank
 */

import java.util.*;

public class rank {

    public int[] solution(int[] grade) {
        int[][] rank = new int[grade.length][2];

        for (int i = 0; i < grade.length; i++) {
            rank[i][0] = i;
            rank[i][1] = grade[i];
        }

        Arrays.sort(rank, (a, b) -> {
            return b[1] - a[1];
        });

        int[] answer = new int[grade.length];

        answer[rank[0][0]] = 1;
        int r = 1;
        int cnt = 0;
        for (int i = 1; i < rank.length; i++) {
            if (rank[i][1] == rank[i - 1][1]) {
                cnt++;
                answer[rank[i][0]] = r;
            } else {

                r = r + cnt + 1;
                answer[rank[i][0]] = r;

                cnt = 0;
            }
        }

        return answer;

    }

}