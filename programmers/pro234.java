package programmers;

/* 
    파괴되지 않은 건물
*/

public class pro234 {

    public static void main(String[] args) {

        new pro234().test();

    }

    void test() {

        int[][] board = { { 5, 5, 5, 5, 5 }, { 5, 5, 5, 5, 5 }, { 5, 5, 5, 5, 5 }, { 5, 5, 5, 5, 5 } };
        int[][] skill = { { 1, 0, 0, 3, 4, 4 }, { 1, 2, 0, 2, 3, 2 }, { 2, 1, 0, 3, 1, 2 }, { 1, 0, 1, 3, 3, 1 } };

        int answer = solution(board, skill);
        System.out.println(answer);
    }

    public int solution(int[][] board, int[][] skill) {
        int answer = 0;

        int row = board.length;
        int col = board[0].length;
        int[][] state = new int[row + 1][col + 1];

        for (int[] s : skill) {

            int degree = s[5];

            if (s[0] == 1) {
                degree *= -1;
            }

            state[s[1]][s[2]] += degree;
            state[s[1]][s[4] + 1] -= degree;
            state[s[3] + 1][s[2]] -= degree;
            state[s[3] + 1][s[4] + 1] += degree;
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                state[i][j + 1] += state[i][j];
            }
        }

        for (int i = 0; i < col; i++) {
            for (int j = 0; j < row; j++) {
                state[j + 1][i] += state[j][i];
            }
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (board[i][j] + state[i][j] > 0) {
                    answer++;
                }
            }
        }

        return answer;
    }
}
