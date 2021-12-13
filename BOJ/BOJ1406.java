package BOJ;

/* 
    에디터
*/

import java.io.*;
import java.util.*;

public class BOJ1406 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();

        Deque<Character> front = new LinkedList<>();
        Stack<Character> back = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            front.addLast(s.charAt(i));
        }

        int M = Integer.parseInt(br.readLine());

        while (M-- > 0) {

            String input = br.readLine();

            if (input.equals("L")) {
                if (!front.isEmpty()) {
                    back.add(front.pollLast());
                }

            } else if (input.equals("D")) {

                if (!back.isEmpty()) {
                    front.addLast(back.pop());
                }

            } else if (input.equals("B")) {

                if (!front.isEmpty()) {
                    front.pollLast();
                }

            } else {

                front.add(input.charAt(2));

            }
        }

        StringBuilder sb = new StringBuilder();

        while (!front.isEmpty()) {
            sb.append(front.pollFirst());
        }

        while (!back.isEmpty()) {
            sb.append(back.pop());
        }

        System.out.println(sb.toString());

    }
}
