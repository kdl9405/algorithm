package programmers;

/*
 * 코딩테스트 연습 연습문제 혼자서 하는 틱택토
 */

public class pro289 {

    public int solution(String[] board) {
        int oCount = 0;
        int xCount = 0;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i].charAt(j) == 'O')
                    oCount++;
                if (board[i].charAt(j) == 'X')
                    xCount++;
            }
        }

        // 1. 기본 개수 규칙 위반
        if (xCount > oCount || oCount > xCount + 1)
            return 0;

        boolean oWins = isWin(board, 'O');
        boolean xWins = isWin(board, 'X');

        // 2. 둘 다 승리하는 경우 (불가능)
        if (oWins && xWins)
            return 0;

        // 3. O가 승리했는데 X와 개수가 같으면 안 됨 (O가 마지막이어야 하므로 O = X + 1)
        if (oWins && oCount != xCount + 1)
            return 0;

        // 4. X가 승리했는데 O가 더 많으면 안 됨 (X가 마지막이어야 하므로 O = X)
        if (xWins && oCount != xCount)
            return 0;

        return 1;
    }

    private boolean isWin(String[] board, char p) {
        // 가로, 세로 확인
        for (int i = 0; i < 3; i++) {
            if (board[i].charAt(0) == p && board[i].charAt(1) == p && board[i].charAt(2) == p)
                return true;
            if (board[0].charAt(i) == p && board[1].charAt(i) == p && board[2].charAt(i) == p)
                return true;
        }
        // 대각선 확인
        if (board[0].charAt(0) == p && board[1].charAt(1) == p && board[2].charAt(2) == p)
            return true;
        if (board[0].charAt(2) == p && board[1].charAt(1) == p && board[2].charAt(0) == p)
            return true;

        return false;
    }
}
