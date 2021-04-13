package BOJ;

import java.util.Scanner;
import java.util.Stack;

/* 
    후위 표기식2
*/

public class BOJ1935 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());

        String expression = sc.nextLine();

        double[] num = new double[n];

        for (int i = 0; i < n; i++) {
            num[i] = Integer.parseInt(sc.nextLine());
        }

        Stack<Double> stack = new Stack<>();

        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);
            if (c >= 'A' && c <= 'Z') {
                stack.push(num[c - 'A']);
            } else {
                double b = stack.pop();
                double a = stack.pop();

                double x = 0;

                switch (c) {
                    case '*':
                        x = a * b;
                        break;

                    case '/':
                        x = (a*100 / b) / (double)100 ;
                        break;
                    case '+':
                        x = a + b;
                        break;
                    case '-':
                        x = a - b;
                        break;
                }

                stack.push(x);
            }
        }

        double result = stack.pop();


        System.out.printf("%.2f",result);
    }
}
