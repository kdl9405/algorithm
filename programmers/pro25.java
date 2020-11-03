
import java.util.Arrays;

public class pro25 {

    public static void main(String[] args) {

        int[][] costs = { { 0, 1, 1 }, { 0, 2, 2 }, { 1, 2, 5 }, { 1, 3, 1 }, { 2, 3, 8 } };

        System.out.println(solution(4, costs));

    }

    static int solution(int n, int[][] costs) {
        int answer = 0;

        Arrays.sort(costs, (o1, o2) -> {
            return o1[2] - o2[2];
        });

        int[] parent = new int[n];

        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        for (int[] cost : costs) {
            int from = cost[0];
            int to = cost[1];
            int value = cost[2];

            if (checkConnect(parent, from, to))
                continue;
            else {
                answer += value;
                union(parent, from, to);
                System.out.println(from+" "+to);
            }
        }

        return answer;
    }

    static int getParent(int[] parent, int edge) {
        if (parent[edge] == edge)
            return edge;

        return getParent(parent, parent[edge]);
    }

    static boolean checkConnect(int[] parent, int from, int to) {
        from = getParent(parent, from);
        to = getParent(parent, to);

        return from == to;
    }

    static void union(int[] parent, int from, int to) {
        from = getParent(parent, from);
        to = getParent(parent, to);

        if (from < to)
            parent[from] = to;
        else
            parent[to] = from;
    }

}
