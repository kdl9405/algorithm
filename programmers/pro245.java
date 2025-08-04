package programmers;

public class pro245 {

    private static final int[][] dirs = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
    private int n, m;

    public int solution(int[][] board, int[] aloc, int[] bloc) {
        n = board.length;
        m = board[0].length;

        return dfs(board, aloc[0], aloc[1], bloc[0], bloc[1]).turns;
    }

    private Result dfs(int[][] board, int ax, int ay, int bx, int by) {

        if (board[ax][ay] == 0)
            return new Result(false, 0);

        boolean canWin = false;
        int minWinTurn = Integer.MAX_VALUE;
        int maxLoseTurn = 0;

        for (int[] d : dirs) {
            int nx = ax + d[0];
            int ny = ay + d[1];

            if (nx < 0 || ny < 0 || nx >= n || ny >= m || board[nx][ny] == 0)
                continue;

            board[ax][ay] = 0;
            Result result = dfs(board, bx, by, nx, ny);
            board[ax][ay] = 1;

            if (!result.win) {
                canWin = true;
                minWinTurn = Math.min(minWinTurn, result.turns + 1);
            } else {
                maxLoseTurn = Math.max(maxLoseTurn, result.turns + 1);
            }
        }

        if (canWin)
            return new Result(true, minWinTurn);
        else
            return new Result(false, maxLoseTurn);
    }

    private static class Result {
        boolean win;
        int turns;

        Result(boolean win, int turns) {
            this.win = win;
            this.turns = turns;
        }
    }
}
