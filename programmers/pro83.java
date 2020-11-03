import java.util.*;

/**
 * 가장 먼 노드
 * 
 */
public class pro83 {

    public static void main(String[] args) {

        int[][] edge = { { 3, 6 }, { 4, 3 }, { 3, 2 }, { 1, 3 }, { 1, 2 }, { 2, 4 }, { 5, 2 } };
        int n = 6;

        System.out.println(solution(n, edge));

    }

    static int solution(int n, int[][] edge) {
        int answer = 0;

        for (int e[] : edge) {
            if (e[0] > e[1]) {
                int temp = e[0];
                e[0] = e[1];
                e[1] = temp;
            }
        }

        Arrays.sort(edge, (e1, e2) -> {

            if (e1[0] == e2[0]) {
                return e1[1] - e2[1];
            }
            return e1[0] - e2[0];
        });

        boolean[] visit = new boolean[n + 1];
        boolean[] visitE = new boolean[edge.length];
        visit[0] = true;

        HashMap<Integer, Integer> map = new HashMap<>();
        Queue<Integer> queue = new LinkedList<>();
        map.put(1, 0);
        queue.offer(1);

        while (!queue.isEmpty()) {

            System.out.println("QQQQQ" + queue);

            int p = queue.poll();

            for (int i = 0; i < edge.length; i++) {
                if (!visitE[i]) {

                    int q = 0;
                    if (p == edge[i][0]) {
                        q = edge[i][1];
                    } else if (p == edge[i][1]) {
                        q = edge[i][0];
                    } else {
                        continue;
                    }

                    visitE[i] = true;
                    if (!visit[q]) {
                        visit[q] = true;
                        map.put(q, map.get(p) + 1);
                        queue.offer(q);
                    }
                }
            }
        }

        System.out.println(map);

        int max = 0;

        for (int c : map.keySet()) {

            if (map.get(c) == max) {
                answer++;
            }

            if (map.get(c) > max) {
                answer = 1;
                max = map.get(c);
            }
        }

        return answer;
    }
}