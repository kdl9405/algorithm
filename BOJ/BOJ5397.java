package BOJ;

/*

    키로거 

*/

import java.io.*;
import java.util.*;

public class BOJ5397 {

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        StringBuilder result = new StringBuilder();

        while (T-- > 0) {
            String input = br.readLine();

            Deque<Character> front = new LinkedList<>();
            Stack<Character> back = new Stack<>();

            for (int i = 0; i < input.length(); i++) {
                switch (input.charAt(i)) {
                    case '<':

                        if (!front.isEmpty()) {
                            back.add(front.pollLast());
                        }

                        break;
                    case '>':
                        if (!back.isEmpty()) {
                            front.addLast(back.pop());
                        }

                        break;
                    case '-':
                        if (!front.isEmpty()) {
                            front.removeLast();
                        }
                        break;

                    default:
                        front.addLast(input.charAt(i));
                        break;
                }
            }


            while (!front.isEmpty()) {
                result.append(front.pollFirst());
            }
            while (!back.isEmpty()) {
                result.append(back.pop());
            }
            result.append("\n");

        }

        System.out.println(result.toString().trim());
    }
}
