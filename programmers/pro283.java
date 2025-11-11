package programmers;

/*
 * 코딩테스트 연습 2022 KAKAO TECH INTERNSHIP 등산코스 정하기
 */

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class pro283 {


    public int[] solution(int n, int[][] paths, int[] gates, int[] summits) {
        costs = new int[n + 1][n + 1];
        pathMap = new HashMap<>();
        for (int[] path : paths) {
            int from = path[0];
            int to = path[1];
            int cost = path[2];

            if (!pathMap.containsKey(from)) {
                pathMap.put(from, new HashSet<>());
            }

            if (!pathMap.containsKey(to)) {
                pathMap.put(to, new HashSet<>());
            }

            pathMap.get(from).add(to);
            pathMap.get(to).add(from);
            costs[from][to] = cost;
            costs[to][from] = cost;
        }

        gateSet = new HashSet<>();
        summitSet = new HashSet<>();

        for (int gate : gates) {
            gateSet.add(gate);
        }

        for (int summit : summits) {
            summitSet.add(summit);
        }

        visited = new boolean[n + 1];
        minSummit = 0;
        minIntensity = Integer.MAX_VALUE;

        for (int gate : gates) {
            visited[gate] = true;
            findMinRoute(gate, 0, gate);
            visited[gate] = false;
        }

        int[] answer = {minSummit, minIntensity};
        return answer;
    }

    private int[][] costs;
    private Map<Integer, Set<Integer>> pathMap;
    private Set<Integer> gateSet, summitSet;
    private int minIntensity;
    private int minSummit;
    private boolean[] visited;

    private void findMinRoute(int now, int maxCost, int gate) {

        if (minIntensity < maxCost)
            return;

        if (now != gate && gateSet.contains(now))
            return;

        if (summitSet.contains(now)) {
            if (minIntensity == maxCost) {
                minSummit = Math.min(minSummit, now);
            } else {
                minIntensity = maxCost;
                minSummit = now;
            }
            return;
        }

        for (int next : pathMap.get(now)) {
            if (visited[next])
                continue;

            visited[next] = true;
            findMinRoute(next, Math.max(maxCost, costs[now][next]), gate);
            visited[next] = false;
        }

    }
}
