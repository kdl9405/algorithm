package programmers;
/* 
2025 프로그래머스 코드챌린지 1차 예선
지게차와 크레인
 */

import java.util.*;

public class pro249 {

    public int solution(String[] storage, String[] requests) {

        N = storage.length;
        M = storage[0].length();
        map = new char[N][M];
        for (int i = 0; i < N; i++) {
            map[i] = storage[i].toCharArray();
        }

        deleted = new boolean[N][M];

        for (String request : requests) {
            if (request.length() == 1) {
                takeWithOutCrane(request.charAt(0));
            } else {
                takeWithCrane(request.charAt(0));
            }
        }

        int answer = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (!deleted[i][j]) {
                    answer++;
                }
            }
        }

        return answer;
    }

    private static int N, M;
    private static int[][] dirs = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
    private char[][] map;
    private boolean[][] deleted;

    private List<int[]> findCandidates() {

        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            queue.offer(new int[] { i, 0 });
            visited[i][0] = true;
            queue.offer(new int[] { i, M - 1 });
            visited[i][M - 1] = true;
        }
        for (int j = 1; j < M - 1; j++) {
            queue.offer(new int[] { 0, j });
            visited[0][j] = true;
            queue.offer(new int[] { N - 1, j });
            visited[N - 1][j] = true;
        }

        List<int[]> candidates = new ArrayList<>();

        while (!queue.isEmpty()) {
            int[] now = queue.poll();

            if (deleted[now[0]][now[1]]) {

                for (int d = 0; d < 4; d++) {
                    int nx = now[0] + dirs[d][0];
                    int ny = now[1] + dirs[d][1];

                    if (nx < 0 || nx >= N || ny < 0 || ny >= M || visited[nx][ny]) {
                        continue;
                    }

                    queue.offer(new int[] { nx, ny });
                    visited[nx][ny] = true;
                }
            } else {
                candidates.add(new int[] { now[0], now[1] });
            }
        }

        return candidates;
    }

    private void takeWithOutCrane(char c) {

        List<int[]> candidates = findCandidates();

        for (int[] candidate : candidates) {
            if (map[candidate[0]][candidate[1]] == c) {
                deleted[candidate[0]][candidate[1]] = true;
            }
        }

    }

    private void takeWithCrane(char c) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == c) {
                    deleted[i][j] = true;
                }
            }
        }
    }

}
