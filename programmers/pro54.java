package programmers;

import java.util.*;

/**
 * 땅따먹기
 */
public class pro54 {

    public static void main(String[] args) {

        int[][] land = { { 1, 2, 3, 5 }, { 5, 6, 7, 8 }, { 4, 3, 2, 1 } };

        System.out.println(solution(land));
    }

    static int solution(int[][] land) {
        int answer = 0;

        int[][] map = land.clone();

        for(int i = 1; i<land.length; i++){
            for(int j = 0; j<4; j++){
                int temp = 0;
                for(int x = 0; x<4; x++){
                    if (x != j && temp<map[i-1][x]) {
                        temp = map[i-1][x];
                    }
                }
                map[i][j] += temp;
            }
        }

        for(int val : map[land.length-1]){
            answer = Math.max(answer, val);
        }

        return answer;
    }

}