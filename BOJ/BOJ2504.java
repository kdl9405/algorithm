package BOJ;

import java.io.IOException;
import java.util.Scanner;
import java.util.Stack;

/* 
    괄호의 값
*/
public class BOJ2504 {

    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);

        Stack<String> stack = new Stack<>();

        String expression = sc.nextLine();
        boolean impossible = false;

        loop: for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);

            switch (c) {
                case ')':
                    if (stack.isEmpty()) {
                        impossible = true;
                        break loop;
                    }

                    if (stack.peek().equals("(")) {
                        stack.pop();
                        stack.push("2");
                    } else {
                        int num = 0;
                        while (!stack.isEmpty() && !stack.peek().equals("(")) {
                            if (!isNum(stack.peek())) {
                                impossible = true;
                                break loop;
                            }
                            num += Integer.parseInt(stack.pop());
                        }
                        if (stack.isEmpty()) {
                            impossible = true;
                            break loop;
                        }
                        stack.pop();
                        num *= 2;
                        stack.push(Integer.toString(num));
                    }
                    break;

                case ']':
                    if (stack.isEmpty()) {
                        impossible = true;
                        break loop;
                    }

                    if (stack.peek().equals("[")) {
                        stack.pop();
                        stack.push("3");
                    } else {
                        int num = 0;
                        while (!stack.isEmpty() && !stack.peek().equals("[")) {
                            if (!isNum(stack.peek())) {
                                impossible = true;
                                break loop;
                            }
                            num += Integer.parseInt(stack.pop());
                        }
                        if (stack.isEmpty()) {
                            impossible = true;
                            break loop;
                        }
                        stack.pop();
                        num *= 3;
                        stack.push(Integer.toString(num));
                    }
                    break;

                default:
                    stack.push(Character.toString(c));
                    break;
            }
        }

        int result = 0;

        if (!impossible) {
            while (!stack.isEmpty()) {
                String s = stack.pop();
                if (!isNum(s)) {
                    result = 0;
                    break;
                }
                result += Integer.parseInt(s);
            }
        }

        System.out.println(result);
    }

    static boolean isNum(String s) {
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
