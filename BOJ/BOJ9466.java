package boj;

import java.io.*;
import java.util.*;

/*
 * 텀 프로젝트
 * 
 * 개선 필요!
 * 
 * 
 */
public class BOJ9466 {

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        while (T-- > 0) {

            int count = Integer.parseInt(br.readLine());

            visit = new boolean[count + 1];
            want = new int[count + 1];

            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= count; i++) {
                want[i] = Integer.parseInt(st.nextToken());
            }

            result = 0;
            stack = new Stack<>();

            for (int i = 1; i < want.length; i++) {
                if (visit[i]) {
                    continue;
                }

                check = false;
                dfs(i, i);

            }

            sb.append(result + "\n");
        }

        System.out.println(sb.toString().trim());

    }

    static int[] want;
    static boolean check;
    static boolean[] visit;
    static Stack<Integer> stack;
    static int result;

    static void dfs(int n, int start) {

        if (visit[n]) {
            if (n == start) {
                check = true;
            }

            if (stack.contains(n)) {
                while (true) {
                    if (stack.peek() == n) {
                        stack.pop();
                        break;
                    }
                    stack.pop();
                }
            }

            while (!stack.isEmpty()) {
                stack.pop();
                result++;
            }

            return;
        }

        visit[n] = true;
        stack.push(n);

        dfs(want[n], start);

    }
}
