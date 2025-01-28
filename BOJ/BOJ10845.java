package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

/*
 * 큐
 */

public class BOJ10845 {

    public static void main(String[] args) throws NumberFormatException, IOException {

        Deque<Integer> deque = new LinkedList<>();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < t; i++) {
            String s = br.readLine();

            if (s.length() > 5) {
                String num = s.replaceAll("[^0-9]", "");
                deque.add(Integer.parseInt(num));
            } else {
                switch (s) {
                    case "pop":
                        if (deque.isEmpty()) {
                            sb.append("-1" + "\n");
                        } else {
                            sb.append(deque.poll() + "\n");
                        }
                        break;

                    case "size":
                        sb.append(deque.size() + "\n");
                        break;
                    case "empty":
                        if (deque.isEmpty()) {
                            sb.append("1" + "\n");
                        } else {
                            sb.append("0" + "\n");
                        }
                        break;

                    case "front":
                        if (deque.isEmpty()) {
                            sb.append("-1" + "\n");
                        } else {
                            sb.append(deque.peekFirst() + "\n");
                        }
                        break;
                    case "back":
                        if (deque.isEmpty()) {
                            sb.append("-1" + "\n");
                        } else {
                            sb.append(deque.peekLast() + "\n");
                        }
                        break;
                }
            }

        }

        System.out.println(sb);

    }
}
