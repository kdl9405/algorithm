package boj;

import java.io.*;
import java.util.*;

/**
 * BOJ18258
 * 
 * Deque를 이용해서 구현 - java 8 - 1276ms java 11 - 1480ms
 */
public class BOJ18258 {

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        Deque<Integer> deque = new LinkedList<>();

        while (N-- > 0) {

            st = new StringTokenizer(br.readLine());
            String f = st.nextToken();

            switch (f) {
                case "push":

                    deque.addLast(Integer.parseInt(st.nextToken()));

                    break;

                case "pop":

                    if (deque.isEmpty()) {
                        sb.append("-1");
                    } else {
                        sb.append(deque.pollFirst());
                    }
                    sb.append("\n");

                    break;
                case "size":

                    sb.append(deque.size()).append("\n");

                    break;
                case "empty":

                    if (deque.isEmpty()) {
                        sb.append("1");
                    } else {
                        sb.append("0");
                    }
                    sb.append("\n");

                    break;
                case "front":

                    if (deque.isEmpty()) {
                        sb.append("-1");
                    } else {
                        sb.append(deque.peekFirst());
                    }
                    sb.append("\n");

                    break;
                case "back":

                    if (deque.isEmpty()) {
                        sb.append("-1");
                    } else {
                        sb.append(deque.peekLast());
                    }

                    sb.append("\n");

                    break;
            }

        }

        System.out.println(sb.toString().trim());

    }
}
