package BOJ;

/*  
    물통
*/

import java.io.*;
import java.util.*;

public class BOJ2251 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        boolean[][][] state = new boolean[201][201][201];

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] { 0, 0, C });

        Set<Integer> answerSet = new TreeSet<>();
        answerSet.add(C);

        while (!queue.isEmpty()) {

            int[] now = queue.poll();

            if (now[0] != 0) {
                int d = Math.min(now[0], B - now[1]);
                if (!state[now[0] - d][now[1] + d][now[2]]) {
                    state[now[0] - d][now[1] + d][now[2]] = true;
                    queue.add(new int[] { now[0] - d, now[1] + d, now[2] });
                    if (now[0] - d == 0) {
                        answerSet.add(now[2]);
                    }
                }

                d = Math.min(now[0], C - now[2]);
                if (!state[now[0] - d][now[1]][now[2] + d]) {
                    state[now[0] - d][now[1]][now[2] + d] = true;
                    queue.add(new int[] { now[0] - d, now[1], now[2] + d });
                    if (now[0] - d == 0) {
                        answerSet.add(now[2] + d);
                    }
                }
            }

            if (now[1] != 0) {
                int d = Math.min(now[1], A - now[0]);
                if (!state[now[0] + d][now[1] - d][now[2]]) {
                    state[now[0] + d][now[1] - d][now[2]] = true;
                    queue.add(new int[] { now[0] + d, now[1] - d, now[2] });
                }

                d = Math.min(now[1], C - now[2]);
                if (!state[now[0]][now[1] - d][now[2] + d]) {
                    state[now[0]][now[1] - d][now[2] + d] = true;
                    queue.add(new int[] { now[0], now[1] - d, now[2] + d });
                    if (now[0] == 0) {
                        answerSet.add(now[2] + d);
                    }
                }
            }

            if (now[2] != 0) {
                int d = Math.min(now[2], A - now[0]);
                if (!state[now[0] + d][now[1]][now[2] - d]) {
                    state[now[0] + d][now[1]][now[2] - d] = true;
                    queue.add(new int[] { now[0] + d, now[1], now[2] - d });
                }

                d = Math.min(now[2], B - now[1]);
                if (!state[now[0]][now[1] + d][now[2] - d]) {
                    state[now[0]][now[1] + d][now[2] - d] = true;
                    queue.add(new int[] { now[0], now[1] + d, now[2] - d });
                    if (now[0] == 0) {
                        answerSet.add(now[2] - d);
                    }
                }
            }
        }

        StringBuilder answer = new StringBuilder();
        for (int a : answerSet) {
            answer.append(a).append(" ");
        }
        System.out.println(answer.toString().trim());

    }
}
