package programmers;
/*
 * 코딩테스트 연습 PCCP 기출문제 [PCCP 기출문제] 2번 / 석유 시추
 */

import java.util.*;

public class pro277 {

    public static void main(String[] args) {

        int[][] land = {{1}};

        System.out.println(solution(land));
    }

    public static int solution(int[][] land) {

        oilSize = new HashMap<>();
        detectedMap = new HashMap<>();
        n = land.length;
        m = land[0].length;
        visited = new boolean[n][m];

        findOil(land);

        int answer = 0;

        for (int j = 0; j < m; j++) {
            int size = 0;

            if (!detectedMap.containsKey(j))
                continue;

            for (int oilNumber : detectedMap.get(j)) {
                size += oilSize.get(oilNumber);
            }

            answer = Math.max(answer, size);
        }

        return answer;
    }

    private static Map<Integer, Integer> oilSize;
    private static Map<Integer, Set<Integer>> detectedMap;
    private static boolean[][] visited;
    private static final int[][] dir = new int[][] {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    private static int n, m;


    private static void findOil(int[][] land) {
        int oilNumber = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (visited[i][j] || land[i][j] == 0)
                    continue;

                int size = getOilSize(land, oilNumber, i, j);
                oilSize.put(oilNumber, size);
                oilNumber++;
            }
        }
    }

    private int getOilSize(int[][] land, int oilNumber, int x, int y) {
        ArrayDeque<int[]> q = new ArrayDeque<>();
        q.add(new int[] {x, y});
        visited[x][y] = true;

        int size = 0;
        Set<Integer> touchedCols = new HashSet<>(); // BitSet 대신 HashSet 사용

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int cx = cur[0], cy = cur[1];

            size++;
            touchedCols.add(cy);

            for (int d = 0; d < 4; d++) {
                int nx = cx + dir[d][0];
                int ny = cy + dir[d][1];

                if (nx < 0 || nx >= n || ny < 0 || ny >= m)
                    continue;
                if (land[nx][ny] == 0 || visited[nx][ny])
                    continue;

                visited[nx][ny] = true;
                q.add(new int[] {nx, ny});
            }
        }

        for (int col : touchedCols) {
            detectedMap.computeIfAbsent(col, k -> new HashSet<>()).add(oilNumber);
        }

        return size;
    }

}
