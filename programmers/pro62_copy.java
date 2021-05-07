package programmers;

import java.util.*;

/**
 * [카카오 인턴] 수식 최대화
 * 
 */
public class pro62_copy {

    public static void main(String[] args) {

        String expression = "100-200*300-500+20";

        System.out.println(solution(expression));

    }

    static long solution(String expression) {

        max = 0;

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < expression.length(); i++) {
            if (Character.isDigit(expression.charAt(i))) {
                sb.append(expression.charAt(i));
            } else {
                sb.append(" " + expression.charAt(i) + " ");
            }
        }

        String[] temp = sb.toString().split(" ");

        expr = new LinkedList<>();

        for (String t : temp) {
            expr.add(t);
        }

        for (int i = 0; i < 6; i++) {
            Deque<String> test = new LinkedList<>();
            test.addAll(expr);

            String[] op = oper[i].split("");

            for (String o : op) {
                int size = test.size();

                while (size-- > 0) {
                    String x = test.pollFirst();

                    if (x.equals(o)) {

                        long a = Long.parseLong(test.pollLast());
                        long b = Long.parseLong(test.pollFirst());

                        switch (o) {
                            case "*":
                                a *= b;
                                break;
                            case "+":
                                a += b;
                                break;
                            case "-":
                                a -= b;
                                break;
                        }

                        test.add(a+"");
                        size--;

                    } else {
                        test.addLast(x);
                    }
                }
            }

            max = Math.max(max, Math.abs(Long.parseLong(test.poll())));
        }

        return max;
    }

    static long max;
    static String[] oper = { "*+-", "*-+", "+*-", "+-*", "-*+", "-+*" };
    static Deque<String> expr;

}