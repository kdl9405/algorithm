package programmers;

import java.util.Collection;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;

/* 
    이중 우선순위 큐

       
*/

public class pro128 {

    public static void main(String[] args) {
        String[] operations = { "I 7", "I 5", "I -5", "D -1" };

        int[] answer = solution(operations);
        System.out.println(answer[0] +" " + answer[1]);
    }

    public static int[] solution(String[] operations) {
        int[] answer = new int[2];

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        PriorityQueue<Integer> reverseQueue = new PriorityQueue<>(Collections.reverseOrder());

        for (String s : operations) {
            String[] str = s.split(" ");
            switch (str[0]) {
                case "I":
                    int n = Integer.parseInt(str[1]);
                    priorityQueue.offer(n);
                    reverseQueue.offer(n);
                    break;

                case "D":

                    if (priorityQueue.isEmpty()) {
                        continue;
                    }

                    if (str[1].equals("1")) {
                        int num = reverseQueue.poll();
                        priorityQueue.remove(num);
                    }else {
                        int num = priorityQueue.poll();
                        reverseQueue.remove(num);
                    }

                    break;

            }
        }

        if (!priorityQueue.isEmpty()) {
            answer[0] = reverseQueue.poll();
            answer[1] = priorityQueue.poll();
        }

        return answer;
    }
}