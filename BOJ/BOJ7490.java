package BOJ;

/* 
    0 만들기
*/

import java.io.*;
import java.util.*;

public class BOJ7490 {

    public static void main(String[] args) throws NumberFormatException, IOException {

        ansewr = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            makeExpression(2, new StringBuilder("1"), N);
            ansewr.append("\n");
        }

        System.out.println(ansewr.toString());

    }

    static StringBuilder ansewr;

    static void makeExpression(int index, StringBuilder expression, int N) {
        if (index > N) {

            if (calculate(expression.toString()) == 0) {
                ansewr.append(expression.toString()).append("\n");
            }
            return;
        }

        makeExpression(index + 1, new StringBuilder(expression).append(" ").append(index), N);
        makeExpression(index + 1, new StringBuilder(expression).append("+").append(index), N);
        makeExpression(index + 1, new StringBuilder(expression).append("-").append(index), N);

    }

    static int calculate(String expression) {

        expression = expression.replaceAll(" ", "");

        StringTokenizer st = new StringTokenizer(expression, "+-", true);

        int number = Integer.parseInt(st.nextToken());

        while (st.hasMoreTokens()) {
            String s = st.nextToken();

            if (s.equals("+")) {
                number += (Integer.parseInt(st.nextToken()));
            } else {
                number -= (Integer.parseInt(st.nextToken()));
            }
        }

        return number;
    }
}
