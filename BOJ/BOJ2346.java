package boj;

import java.io.*;
import java.util.*;

/*
 * 풍선 터뜨리기
 * 
 * 
 */

public class BOJ2346 {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        Deque<Integer[]> deque = new ArrayDeque<>();
        for (int i = 1; i <= n; i++) {
            deque.add(new Integer[] {i, Integer.parseInt(st.nextToken())});
        }

        StringBuilder sb = new StringBuilder();
        int x = 1;
        while (!deque.isEmpty()) {


            Integer[] balloon;

            if (x > 0) {
                while (x-- > 1) {
                    deque.addLast(deque.pollFirst());
                }
                balloon = deque.pollFirst();
            } else {
                while (x++ < -1) {
                    deque.addFirst(deque.pollLast());
                }
                balloon = deque.pollLast();
            }

            sb.append(balloon[0]).append(" ");
            x = balloon[1];

        }

        System.out.println(sb.toString());

    }
}
