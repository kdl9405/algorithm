package BJ;

import java.io.IOException;
import java.util.Scanner;
import java.util.Stack;

/* 
    괄호의 값
*/
public class BJ2504 {

    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);

        Stack<String> stack = new Stack<>();

        String expression = sc.nextLine();

        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);

            switch (c) {
                case ')':

                    if (stack.isEmpty()) {
                        stack.clear();
                        break;
                    }

                    if (stack.peek().equals("(")) {
                        stack.pop();
                        stack.push("2");
                    } else {
                        int num = 0;
                        while (!stack.isEmpty()) {
                            // if (stack.peek().equals("(")) {
                            // break;
                            // }
                            if (!Character.isDigit(stack.peek().charAt(0))) {
                                break;
                            }
                            num += Integer.parseInt(stack.pop());
                        }
                        if (!stack.isEmpty()) {
                            stack.pop();
                        }
                        num *= 2;
                        stack.push(Integer.toString(num));
                    }

                    break;

                case ']':

                    if (stack.isEmpty()) {
                        stack.clear();
                        break;
                    }

                    if (stack.peek().equals("[")) {
                        stack.pop();
                        stack.push("3");
                    } else {
                        int num = 0;
                        while (!stack.isEmpty()) {
                            // if (stack.peek().equals("[")) {
                            // break;
                            // }
                            if (!Character.isDigit(stack.peek().charAt(0))) {
                                break;
                            }
                            num += Integer.parseInt(stack.pop());
                        }
                        if (!stack.isEmpty()) {
                            stack.pop();
                        }
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

        while (!stack.isEmpty()) {
            String s = stack.pop();
            if (!Character.isDigit(s.charAt(0))) {
                result = 0;
                break;
            }
            result += Integer.parseInt(s);
        }

        System.out.println(result);
    }
}
