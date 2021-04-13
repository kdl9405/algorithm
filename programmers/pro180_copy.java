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

        if (n <= cores.length) {
            return n;
        }

        n -= cores.length;

        PriorityQueue<core> pq = new PriorityQueue<>((q1, q2) -> {
            if (q1.time == q2.time) {
                return q1.index - q2.index;
            }
            return q1.time - q2.time;
        });

        for (int i = 0; i < cores.length; i++) {
            pq.add(new core(i, cores[i]));
        }

        int time = 1;
        while (n > 0) {

            core now = pq.poll();

            if (now.time == time) {
                n--;
            } else if (now.time > time) {
                time = now.time;
                n--;
            }

            if (n == 0) {
                answer = now.index + 1;
            } else {
                pq.add(new core(now.index, time + cores[now.index]));
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
