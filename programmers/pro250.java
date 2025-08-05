package programmers;
/* 
연습문제
요격 시스템
 */

import java.util.Arrays;

public class pro250 {

    public int solution(int[][] targets) {

        Arrays.sort(targets, (x, y) -> {
            return x[1] - y[1];
        });

        int answer = 0;
        int point = 0;

        for (int[] t : targets) {
            if (t[0] < point)
                continue;

            answer++;
            point = t[1];
        }

        return answer;
    }

}
