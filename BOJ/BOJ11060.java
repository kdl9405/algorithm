package BOJ;

/**
점프 점프
 */

import java.io.*;
import java.util.*;

public class BOJ11060 {

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(solution(N, A));

    }

    static int solution(int N, int[] A) {

        if (N == 1) {
            return 0;
        }

        int count = 0;
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visit = new boolean[N];
        visit[0] = true;
        queue.add(0);

        while (!queue.isEmpty()) {

            int size = queue.size();

            count++;
            while (size-- > 0) {

                int now = queue.poll();

                for (int i = 1; i <= A[now] && now+i < N; i++) {
                    if (visit[now+i]) {
                        continue;
                    }

                    if (now+i == N - 1) {
                        return count;
                    }

                    visit[now+i] = true;
                    queue.add(now+i);
                }
            }

        }

        return -1;
    }

}