package programmers;

import java.util.*;

/* 
    선입 선출 스케줄링

    효율성 X 
*/

public class pro180_copy {
    public static void main(String[] args) {

        int n = 6;
        int[] cores = { 1, 2, 3 };

        System.out.println(solution(n, cores));
    }

    public static int solution(int n, int[] cores) {
        int answer = 0;

        if (n <= cores.length) { // n이 core의 개수보다 작을 경우 n번째 코어를 리턴
            return n;
        }

        n -= cores.length;  // 시간이 0일 때, 모든 코어가 작업을 하나씩 담당하여 처리

        PriorityQueue<core> pq = new PriorityQueue<>((q1, q2) -> {  // 다음 처리시간순으로 정렬, 처리시간이 같을 경우는 index값이 작은 순으로 정렬
            if (q1.time == q2.time) {
                return q1.index - q2.index;
            }
            return q1.time - q2.time;
        });

        for (int i = 0; i < cores.length; i++) { // core를 pq에 삽입
            pq.add(new core(i, cores[i]));
        }

        int time = 1;
        while (n > 0) { // n이 0이 될 때까지 core가 작업을 하나씩 담당 처리

            core now = pq.poll(); // 다음 작업을 처리할 core

            if (now.time == time) {  // 현재시간과 core의 다음처리시간이 같은 경우
                n--;
            } else if (now.time > time) { // 현재시간보다 core의 다음처리가 큰 경우
                time = now.time;
                n--;
            }

            if (n == 0) { // 작업이 모두 처리되었으니, core의 인덱스를 출력
                answer = now.index + 1;
            } else {
                pq.add(new core(now.index, time + cores[now.index])); // 작업이 남은경우, 사용한 core의 다음 처리시간을 구하여 pq에 삽입
            }
        }

        return answer;
    }
}

class core {
    int index;
    int time;

    public core(int index, int time) {
        this.index = index;
        this.time = time;
    }
}
