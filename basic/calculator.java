package basic;

import java.io.*;
import java.util.*;

public class calculator {

    public static void main(String[] args) throws IOException {

        new calculator().test();
    }

    private void test() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(step2(br.readLine()));
    }

    // 숫자와 덧셈 뺄셈 , 결과는 int값.
    private int step1(String s) {

        StringTokenizer st = new StringTokenizer(s, "+-", true);

        int result = 0;

        while (st.hasMoreTokens()) {
            String e = st.nextToken();
            if (e.equals("+")) {
                result += Integer.parseInt(st.nextToken());
            } else if (e.equals("-")) {
                result -= Integer.parseInt(st.nextToken());
            } else {
                result += Integer.parseInt(e);
            }
        }

        return result;
    }

    private int step2(String s) {

        // 연산자 우선순위
        setPriority();

        // 후위표기식으로 변경
        StringBuilder postfix = new StringBuilder();
        StringTokenizer st = new StringTokenizer(s, "+-*/()", true);
        Stack<String> operStack = new Stack<>();

        while (st.hasMoreTokens()) {
            String e = st.nextToken();

            if (!operPriority.containsKey(e)) {
                postfix.append(e).append(" ");
            } else {
                if (operStack.isEmpty()) {
                    operStack.push(e);
                } else {

                    if (e.equals(")")) {
                        while (!operStack.peek().equals("(")) {
                            postfix.append(operStack.pop()).append(" ");
                        }
                        operStack.pop();
                    } else if (e.equals("(")) {
                        operStack.push(e);
                    } else {
                        int nowPriority = operPriority.get(e);

                        if (nowPriority > operPriority.get(operStack.peek())) {
                            operStack.push(e);
                        }else{
                            while (nowPriority <= operPriority.get(operStack.peek())) {
                                if (operStack.isEmpty()) {
                                    operStack.push(e);
                                    break;
                                }
                                

                            }
                        }

                        while (true) {
                            if (operStack.isEmpty() || operPriority.get(operStack.peek()) < nowPriority) {
                                operStack.push(e);
                                break;
                            }

                            postfix.append(operStack.pop()).append(" ");
                        }

                        // while (!operStack.isEmpty() && operPriority.get(operStack.peek()) >=
                        // nowPriority) {
                        // postfix.append(operStack.pop()).append(" ");
                        // }
                        // operStack.push(e);
                        // break;
                    }
                }
            }

            System.out.println(e);
            System.out.println(postfix);
            System.out.println(operStack);

        }

        System.out.println(operStack);
        System.out.println(postfix);

        int result = 0;

        return result;
    }

    private Map<String, Integer> operPriority;

    private void setPriority() {
        operPriority = new HashMap<>();

        operPriority.put("(", 0);
        operPriority.put(")", 0);
        operPriority.put("*", 1);
        operPriority.put("/", 1);
        operPriority.put("+", 2);
        operPriority.put("-", 2);

    }

}
