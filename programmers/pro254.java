package programmers;

import java.util.ArrayDeque;
import java.util.Queue;

public class pro254 {

    public int solution(int[] queue1, int[] queue2) {

        long sum1 = 0L;
        long sum2 = 0L;

        Queue<Integer> q1 = new ArrayDeque<>();
        Queue<Integer> q2 = new ArrayDeque<>();

        for (int num : queue1) {
            sum1 += num;
            q1.add(num);
        }

        for (int num : queue2) {
            sum2 += num;
            q2.add(num);
        }

        if (sum1 == sum2) {
            return 0;
        }

        if ((sum1 + sum2) % 2 == 1) {
            return -1;
        }

        int maxCount = (queue1.length + queue2.length) * 2;
        for (int i = 1; i <= maxCount; i++) {
            if (sum1 > sum2) {
                int num = q1.peek();
                sum1 -= num;
                sum2 += num;
                q1.poll();
                q2.add(num);
            } else {
                int num = q2.peek();
                sum2 -= num;
                sum1 += num;
                q2.poll();
                q1.add(num);
            }

            if (sum1 == sum2) {
                return i;
            }
        }

        return -1;
    }
}
