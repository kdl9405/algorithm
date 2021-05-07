package programmers;

import java.util.*;

/**
 * [카카오 인턴] 수식 최대화
 * 
 */
public class pro62 {

    public static void main(String[] args) {

        String expression = "100-200*300-500+20";

        System.out.println(solution(expression));

    }

    static long solution(String expression) {
        long answer = 0;

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < expression.length(); i++) {
            if (Character.isDigit(expression.charAt(i))) {
                sb.append(expression.charAt(i));
            } else {
                sb.append(" " + expression.charAt(i) + " ");
            }
        }

        System.out.println(sb.toString());

        String[] exp = sb.toString().split(" ");        

        Deque<String> orideque = new LinkedList<>();
        Deque<String> deque;
        Deque<String> tempdeque;

        for (String e : exp) {
            orideque.offer(e);
        }

        String[] oper = { "+-*", "+*-", "-+*", "-*+", "*+-", "*-+" };

        for (int x = 0; x < 6; x++) {

            deque = new LinkedList<>();
            deque.addAll(orideque);

            String[] op = oper[x].split("");

            for (String o : op) {

                tempdeque = new LinkedList<>();

                while (!deque.isEmpty()) {
                    if (!deque.peek().equals(o)) {
                        tempdeque.offer(deque.poll());
                    } else {
                        long num1 = Long.parseLong(tempdeque.pollLast());
                        deque.poll();
                        long num2 = Long.parseLong(deque.pollFirst());

                        switch (o) {
                            case "+":
                                num1 += num2;
                                tempdeque.offer(Long.toString(num1));
                                break;

                            case "-":
                                num1 -= num2;
                                tempdeque.offer(Long.toString(num1));
                                break;
                            case "*":
                                num1 *= num2;
                                tempdeque.offer(Long.toString(num1));
                                break;
                        }
                    }
                }

                deque.addAll(tempdeque);               

            }
            answer = Math.max(answer, Math.abs(Long.parseLong(deque.poll())));

        }

        return answer;
    }

}