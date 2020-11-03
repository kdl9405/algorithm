package programmers;

import java.util.*;

public class pro37 {
    
    public static void main(String[] args) {
        
        int[][] board ={{0,0,0,0,0},{0,0,1,0,3},{0,2,5,0,1},{4,2,4,4,2},{3,5,1,3,1}};
        int[] moves = {1,5,3,5,1,2,1,4};

        System.out.println(solution(board, moves));

    }

    static int solution(int[][] board, int[] moves) {
        int answer = 0;

        int len = board.length;

        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i<moves.length; i++){

            int n = moves[i]-1;
            
            for(int j = 0; j<len; j++){
                if (board[j][n] != 0) {
                  
                    if (stack.isEmpty()) {
                        stack.push(board[j][n]);
                    }else{
                        if (stack.peek() == board[j][n]) {
                            stack.pop();
                            answer+=2;
                        }else{
                            stack.push(board[j][n]);
                        }
                    }

                    board[j][n]=0;

                    break;
                }
            }
        }

        return answer;
    }
}