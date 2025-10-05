package programmers;

/*
 * 코딩테스트 연습 연습문제 호텔 대실
 * 
 * https://school.programmers.co.kr/learn/courses/30/lessons/155651
 */


import java.util.Arrays;
import java.util.PriorityQueue;

public class pro270 {


    public int solution(String[][] book_time) {
        int answer = 0;

        int[][] times = new int[book_time.length][2];

        for (int i = 0; i < book_time.length; i++) {
            times[i] = new int[] {convertToIntTime(book_time[i][0]),
                    convertToIntTime(book_time[i][1])};
        }

        Arrays.sort(times, (a, b) -> {
            if (a[0] == b[0]) {
                return a[1] - b[1];
            }

            return a[0] - b[0];
        });

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int[] booking : times) {

            if (pq.isEmpty() || pq.peek() <= booking[0]) {
                pq.poll();
            }

            pq.add(booking[1] + 10);

            answer = Math.max(answer, pq.size());
        }

        return answer;
    }

    private Integer convertToIntTime(String time) {

        String[] timeArray = time.split(":");

        return Integer.parseInt(timeArray[0]) * 60 + Integer.parseInt(timeArray[1]);
    }
}
