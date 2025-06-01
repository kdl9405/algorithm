package programmers;

// Summer/Winter Coding(2019)

import java.util.*;



public class pro238 {

    public static void main(String[] args) {

        int[][] land = {{10, 11, 10, 11}, {2, 21, 20, 10}, {1, 20, 21, 11}, {2, 1, 2, 1}};
        int height = 1;

        solution(land, height);
    }

    // 1. 사다리 없이 이동할 수 있는,, 각 그룹을 구하고.
    // 2. 그룹간 이동할수 있는 최소 비용 사다리를 구하고..
    // 3. 그 사다리를 모두 더한다.

    public static int solution(int[][] land, int height) {

        findGroup(land, height);

        findMinBetweenGroup(land);

        return findMinCost();
    }

    static int N;
    static int[][] group;
    static int groupCount;
    static boolean[][] visited;
    static List<int[]> minCosts;
    static Map<String, Integer> costMap;
    static int[] xPoint = {-1, 1, 0, 0};
    static int[] yPoint = {0, 0, -1, 1};

    static void findGroup(int[][] land, int height) {

        N = land.length;
        group = new int[N][N];
        visited = new boolean[N][N];
        int groupNo = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (visited[i][j]) {
                    continue;
                }

                dfs(land, height, groupNo, i, j);
                groupNo++;
            }
        }

        groupCount = groupNo;
    }

    static void dfs(int[][] land, int height, int groupNo, int x, int y) {

        visited[x][y] = true;
        group[x][y] = groupNo;

        for (int i = 0; i < 4; i++) {
            int nx = x + xPoint[i];
            int ny = y + yPoint[i];

            if (nx < 0 || nx >= N || ny < 0 || ny >= N || visited[nx][ny]) {
                continue;
            }

            if (Math.abs(land[x][y] - land[nx][ny]) <= height) {
                dfs(land, height, groupNo, nx, ny);
            }
        }
    }

    static void findMinBetweenGroup(int[][] land) {

        minCosts = new ArrayList<>();
        costMap = new HashMap<>();

        for (int x = 0; x < N; x++) {
            for (int y = 0; y < N; y++) {

                for (int i = 0; i < 4; i++) {
                    int nx = x + xPoint[i];
                    int ny = y + yPoint[i];

                    if (nx < 0 || nx >= N || ny < 0 || ny >= N) {
                        continue;
                    }

                    if (group[x][y] == group[nx][ny]) {
                        continue;
                    }

                    int cost = Math.abs(land[x][y] - land[nx][ny]);

                    int from = Math.min(group[x][y], group[nx][ny]);
                    int to = Math.max(group[x][y], group[nx][ny]);
                    String key = from + "-" + to;

                    if (!costMap.containsKey(key) || costMap.get(key) > cost) {
                        costMap.put(key, cost);
                    }

                }
            }
        }

        for (String key : costMap.keySet()) {
            String[] parts = key.split("-");
            int from = Integer.parseInt(parts[0]);
            int to = Integer.parseInt(parts[1]);
            int cost = costMap.get(key);

            minCosts.add(new int[] {from, to, cost});
        }
    }

    static int findMinCost() {
        minCosts.sort(Comparator.comparingInt(a -> a[2]));

        int[] parents = new int[groupCount];

        for (int i = 0; i < groupCount; i++) {
            parents[i] = i;
        }

        int totalCost = 0;
        int connectCount = 0;

        for (int[] connect : minCosts) {
            int from = connect[0];
            int to = connect[1];
            int cost = connect[2];


            if (find(parents, from) != find(parents, to)) {
                union(parents, from, to);
                totalCost += cost;
                connectCount++;

                if (connectCount == groupCount - 1)
                    break;
            }

        }

        return totalCost;
    }


    static int find(int[] parents, int x) {
        if (parents[x] != x) {
            parents[x] = find(parents, parents[x]);
        }

        return parents[x];
    }

    static void union(int[] parents, int a, int b) {
        int rootA = find(parents, a);
        int rootB = find(parents, b);

        if (rootA != rootB) {
            parents[rootB] = rootA;
        }
    }
}
