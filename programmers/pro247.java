package programmers;
/* 
2025 프로그래머스 코드챌린지 2차 예선
완전범죄
 */

import java.util.HashSet;
import java.util.Set;

public class pro247 {

    public int solution(int[][] info, int n, int m) {

        N = n;
        M = m;

        dfs(info, 0, 0, 0);

        return minA < n ? minA : -1;
    }

    private int minA = Integer.MAX_VALUE;
    private int N, M;
    private Set<String> visited = new HashSet<>();

    private void dfs(int[][] info, int index, int a, int b) {

        if (a >= N || b >= M)
            return;

        if (index == info.length) {
            minA = Math.min(minA, a);
            return;
        }

        String key = index + "," + a + "," + b;
        if (visited.contains(key))
            return;
        visited.add(key);

        dfs(info, index + 1, a + info[index][0], b);
        dfs(info, index + 1, a, b + info[index][1]);
    }
}
