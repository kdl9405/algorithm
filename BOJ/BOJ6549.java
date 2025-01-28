package boj;

/*
 * 히스토그램에서 가장 큰 직사각형
 */

import java.io.*;
import java.util.*;

public class BOJ6549 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        while (true) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());

            if (n == 0) {
                break;
            }

            long[] h = new long[n];
            for (int i = 0; i < n; i++) {
                h[i] = Long.parseLong(st.nextToken());
            }

            long max = 0;
            Stack<Integer> stack = new Stack();
            for (int i = 0; i < n; i++) {
                while (!stack.isEmpty() && h[stack.peek()] > h[i]) {
                    long before = h[stack.pop()];

                    int width = i;
                    if (!stack.isEmpty()) {
                        width = (i - stack.peek() - 1);
                    }
                    if (max < width * before) {
                        max = width * before;
                    }

                }
                stack.push(i);
            }

            while (!stack.isEmpty()) {
                long before = h[stack.pop()];

                int width = n;
                if (!stack.isEmpty()) {
                    width = (n - stack.peek() - 1);
                }
                if (max < width * before) {
                    max = width * before;
                }
            }

            sb.append(max + "\n");
        }

        System.out.println(sb.toString().trim());

    }
}
