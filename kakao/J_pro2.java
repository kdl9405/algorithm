package kakao;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class J_pro2 {
    static int answer = 0;
    static Map<Integer, Set<Integer>> map = new HashMap<>();
    static Set<Integer> placed;
    static boolean[] visited;

    public static void main(String[] args) {
        int[][] needs = {{1, 0, 0 }, {1, 0, 0}, {1, 0, 0}, {1, 0, 1}, {1, 1, 0}, {1, 1, 1}};
        int result = solution(needs, 3);
        System.out.println(result);
    }

    public static int solution(int[][] needs, int r) {
        placed = new HashSet<>();
        visited = new boolean[15];

        map = new HashMap<>();
        for (int i = 0; i < needs.length; i++) {
            map.put(i, new HashSet<>());
            Set<Integer> currentSet = map.get(i);

            for (int j = 0; j < needs[i].length; j++) {
                if (needs[i][j] == 1) {
                    currentSet.add(j);
                }
            }
        }
        dfs(0, 3);

        return answer;
    }

    static void dfs(int index, int r) {
        if (index == r) {
            int currentResult = 0;
            for (int i = 0, size = map.size(); i < size; i++) {
                if (placed.containsAll(map.get(i))) {
                    currentResult++;
                }
            }
            if (answer < currentResult) {
                answer = currentResult;
            }
            System.out.println(placed);
            placed.clear();
            return;
        }

        for (int i = 0; i < 4; i++) {
            if (visited[i]) {
                continue;
            }

            visited[i] = true;
            placed.add(i);
            dfs(index + 1, r);
            visited[i] = false;
        }
    }
}