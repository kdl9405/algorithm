package boj;

/*
 * 오아시스 재결합
 */

import java.io.*;
import java.util.*;

public class BOJ3015 {

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] height = new int[N];

        for (int i = 0; i < N; i++) {

            height[i] = Integer.parseInt(br.readLine());
        }

        long count = 0;
        Stack<int[]> stack = new Stack<>();
        for (int i = 0; i < N; i++) {

            int[] now = new int[] {height[i], 1};
            while (!stack.isEmpty()) {
                if (stack.peek()[0] <= now[0]) {
                    if (stack.peek()[0] == now[0]) {
                        now[1] += stack.peek()[1];
                    }
                    count += stack.pop()[1];

                } else {
                    count++;
                    break;
                }
            }

            stack.push(now);

        }

        System.out.println(count);

    }
}
