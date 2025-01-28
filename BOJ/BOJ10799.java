package boj;

import java.util.*;

/*
 * 쇠막대기
 */
public class BOJ10799 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String s = sc.nextLine();

        Deque<Character> deque = new LinkedList<>();

        for (int i = 0; i < s.length(); i++) {

            if (s.charAt(i) == ')' && deque.peekLast() == '(') {

                deque.pollLast();
                deque.addLast('*');

            } else {
                deque.addLast(s.charAt(i));
            }
        }

        Stack<Character> stack = new Stack<>();
        int count = 0;

        while (!deque.isEmpty()) {
            char c = deque.pollFirst();
            if (c == '*') {
                count += stack.size();
            } else if (c == '(') {
                stack.push(c);
            } else {
                stack.pop();
                count++;
            }
        }

        System.out.println(count);
    }
}
