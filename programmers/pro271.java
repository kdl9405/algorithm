package programmers;
/*
 * 코딩테스트 연습 연습문제 디펜스 게임
 * 
 * https://school.programmers.co.kr/learn/courses/30/lessons/142085
 */


import java.util.*;

public class pro271 {
    public int solution(int n, int k, int[] enemy) {
        int answer = enemy.length;

        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> {
            return b - a;
        });

        for (int i = 0; i < enemy.length; i++) {
            pq.add(enemy[i]);

            n -= enemy[i];

            while (n < 0) {
                if (k == 0 || pq.isEmpty()) {
                    break;
                }

                k--;
                n += pq.peek();
                pq.poll();
            }

            if (n < 0) {
                answer = i;
                break;
            }
        }

        return answer;
    }
}
