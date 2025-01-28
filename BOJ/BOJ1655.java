package boj;

import java.util.*;
import java.io.*;

public class BOJ1655 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        PriorityQueue<Integer> left = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> right = new PriorityQueue<>();

        int n = Integer.parseInt(br.readLine());

        while (n-- > 0) {
            int num = Integer.parseInt(br.readLine());

            if (left.size() == right.size()) {
                left.offer(num);
            } else {
                right.offer(num);
            }

            if (!left.isEmpty() && !right.isEmpty()) {
                if (left.peek() > right.peek()) {
                    left.offer(right.poll());
                    right.offer(left.poll());
                }
            }

            sb.append(left.peek() + "\n");

        }

        System.out.println(sb);
    }
}
