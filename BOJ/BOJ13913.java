package boj;

import java.io.*;
import java.util.*;

/*
 * 숨바꼭질 4
 */
public class BOJ13913 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] before = new int[100001];
        Arrays.fill(before, -1);
        before[N] = N;

        Queue<Integer> queue = new LinkedList<>();
        queue.add(N);

        while (!queue.isEmpty()) {

            int now = queue.poll();

            if (now == K) {
                break;
            }

            if (now - 1 >= 0 && before[now - 1] == -1) {
                before[now - 1] = now;
                queue.add(now - 1);
            }

            if (now + 1 <= 100000 && before[now + 1] == -1) {
                before[now + 1] = now;
                queue.add(now + 1);
            }

            if (now * 2 <= 100000 && before[now * 2] == -1) {
                before[now * 2] = now;
                queue.add(now * 2);
            }
        }

        int x = K;

        Stack<Integer> stack = new Stack<>();

        while (x != N) {
            stack.add(x);
            x = before[x];
        }

        StringBuilder sb = new StringBuilder();
        sb.append(stack.size()).append("\n").append(N + " ");

        while (!stack.isEmpty()) {
            sb.append(stack.pop() + " ");
        }

        System.out.println(sb.toString());

    }
}
