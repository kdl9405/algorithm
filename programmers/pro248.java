package programmers;

/* 
2025 프로그래머스 코드챌린지 2차 예선
서버 증설 횟수
 */

import java.util.PriorityQueue;

public class pro248 {
    public int solution(int[] players, int m, int k) {
        int answer = 0;

        PriorityQueue<Integer> servers = new PriorityQueue<>();

        for (int i = 0; i < 24; i++) {

            while (!servers.isEmpty() && servers.peek() <= i) {
                servers.poll();
            }

            int serverCount = servers.size();
            int needCount = players[i] / m;

            if (needCount > serverCount) {
                answer += (needCount - serverCount);

                for (int j = 0; j < needCount - serverCount; j++) {
                    servers.add(i + k);
                }
            }
        }

        return answer;
    }
}
