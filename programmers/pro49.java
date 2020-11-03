package programmers;

//가장 큰 정사각형

public class pro49 {

    public static void main(String[] args) {
        int[][] board = { { 0, 0, 0, 0 }, { 1, 1, 1, 1 } };
        System.out.println(solution(board));
    }

    static int solution(int[][] board) {
        int answer = 0;

        int up, left, upleft;
        for(int i = 1; i< board.length; i++){
            for(int j = 1; j<board[0].length; j++){
                if (board[i][j] == 1) {
                    up = board[i-1][j];
                    left = board[i][j-1];
                    upleft = board[i-1][j-1];

                    int min = Math.min(up, Math.min(left, upleft));

                    board[i][j] = min+1;
                }
            }
        }

        for(int i = 0; i< board.length; i++){
            for(int j = 0; j<board[0].length; j++){
                if (board[i][j] > 0) {
                    answer = Math.max(answer, board[i][j]);
                }
            }
        }
          

        return answer * answer;
    }   
}