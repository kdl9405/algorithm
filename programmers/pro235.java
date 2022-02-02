package programmers;

/**
 * 사라지는 발판
 * 
 */
public class pro235 {

    public int solution(int[][] board, int[] aloc, int[] bloc) {
        int answer = -1;

        return answer;
    }

    int min = Integer.MAX_VALUE;
    int max = 0;
    boolean winA = false;

    private class State {
        boolean isWin;
        int moveCount;

        State(boolean isWin, int moveCount) {
            this.isWin = isWin;
            this.moveCount = moveCount;
        }
    }

    // 0 : 승패 1 : 이동 횟수
    State moveA(int r, int c, int[][] board, State state) {

        

        return new State(state.isWin, state.moveCount);
    }

    void moveB(int r, int c, int[][] board) {

    }

}