package BOJ;

/* 
    Base Conversion
*/

import java.io.*;
import java.util.*;

public class BOJ11576 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        int m = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        Stack<Integer> stack = new Stack<>();
        while (m-- > 0) {
            stack.add(Integer.parseInt(st.nextToken()));
        }

        int num = 0;
        int radix = 1;
        while (!stack.isEmpty()) {
            num += (radix * stack.pop());
            radix *= A;
        }

        while (num > 0) {
            stack.add(num % B);
            num/=B;
        }

        StringBuilder answer = new StringBuilder();
        while (!stack.isEmpty()) {
            answer.append(stack.pop()).append(" ");
        }
        System.out.println(answer.toString().trim());

    }

}
