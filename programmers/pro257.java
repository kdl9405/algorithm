package programmers;

public class pro257 {

    public String solution(int n, int m, int x, int y, int r, int c, int k) {

        N = n;
        M = m;
        K = k;
        R = r;
        C = c;

        int distance = Math.abs(x - r) + Math.abs(y - c);
        if (distance > k || (k - distance) % 2 != 0) {
            return "impossible";
        }

        findRoute(x, y, new StringBuilder());

        return answer;
    }

    private int N, M, K, R, C;
    private String answer = "impossible";
    private char[] dirChars = { 'd', 'l', 'r', 'u' };
    private int[][] dirs = { { 1, 0 }, { 0, -1 }, { 0, 1 }, { -1, 0 } };

    private void findRoute(int x, int y, StringBuilder route) {
        if (!"impossible".equals(answer) || route.length() > K) {
            return;
        }

        int remainingMoves = K - route.length();
        int distToTarget = Math.abs(x - R) + Math.abs(y - C);
        if (remainingMoves < distToTarget) {
            return;
        }

        if (route.length() == K && x == R && y == C) {
            answer = route.toString();
            return;
        }

        for (int i = 0; i < 4; i++) {
            int nx = x + dirs[i][0];
            int ny = y + dirs[i][1];

            if (nx > 0 && nx <= N && ny > 0 && ny <= M) {
                findRoute(nx, ny, new StringBuilder(route).append(dirChars[i]));
            }
        }
    }
}
