package boj;

import java.io.*;
import java.util.*;

/*
 * 이진수 덧셈
 */

public class BOJ2729 {

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        StringBuilder result = new StringBuilder();

        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            String input = st.nextToken();

            Stack<Character> A = new Stack<>();

            for (int i = 0; i < input.length(); i++) {
                A.add(input.charAt(i));
            }

            input = st.nextToken();
            Stack<Character> B = new Stack<>();

            for (int i = 0; i < input.length(); i++) {
                B.add(input.charAt(i));
            }

            int num = 0;

            StringBuilder sb = new StringBuilder();

            while (!A.isEmpty() || !B.isEmpty()) {

                if (!A.isEmpty()) {
                    num += (A.pop() - '0');
                }
                if (!B.isEmpty()) {
                    num += (B.pop() - '0');
                }

                if (num > 1) {
                    sb.append(num % 2);
                    num = 1;
                } else {
                    sb.append(num);
                    num = 0;
                }

            }

            if (num == 1) {
                sb.append(1);
            }

            String sum = sb.reverse().toString();
            int index = 0;
            for (; index < sum.length(); index++) {
                if (sum.charAt(index) != '0') {
                    break;
                }
            }

            sum = sum.substring(index, sum.length());
            if (sum.length() == 0) {
                result.append(0).append("\n");
            } else {
                result.append(sum).append("\n");
            }

        }

        System.out.println(result.toString().trim());

    }
}
