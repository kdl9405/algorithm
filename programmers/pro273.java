package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * 코딩테스트 연습 연습문제 테이블 해시 함수
 * 
 * https://school.programmers.co.kr/learn/courses/30/lessons/147354
 * 
 */
public class pro273 {

    public int solution(int[][] data, int col, int row_begin, int row_end) {

        Arrays.sort(data, (a, b) -> {

            if (a[col - 1] == b[col - 1])
                return b[0] - a[0];

            return a[col - 1] - b[col - 1];
        });

        List<Integer> sums = new ArrayList<>();

        for (int i = row_begin; i <= row_end; i++) {

            int sum = 0;
            for (int num : data[i - 1]) {
                sum += (num % i);
            }

            sums.add(sum);
        }

        int answer = 0;
        for (int sum : sums) {
            answer ^= sum;
        }

        return answer;
    }
}
