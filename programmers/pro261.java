package programmers;

import java.util.ArrayDeque;
import java.util.Queue;

public class pro261 {

    public int solution(int x, int y, int n) {

        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[] { x, 0 });

        boolean[] visited = new boolean[y + 1];

        int answer = -1;
        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            if (now[0] > y || visited[now[0]])
                continue;
            visited[now[0]] = true;

            if (now[0] == y) {
                answer = now[1];
                break;
            }

            queue.add(new int[] { now[0] + n, now[1] + 1 });
            queue.add(new int[] { now[0] * 2, now[1] + 1 });
            queue.add(new int[] { now[0] * 3, now[1] + 1 });
        }

        return answer;

    }
}
