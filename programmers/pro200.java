package programmers;

import java.util.Arrays;

/* 
    6주차 복서 정렬하기
*/
public class pro200 {

    public static void main(String[] args) {

    }

    public static int[] solution(int[] weights, String[] head2head) {
        int[] answer = new int[weights.length];

        double[][] winning = new double[weights.length][4]; // 인덱스 / 게임 수 / 승률 / 자기보다 높은 몸무게 선수를 이긴 수

        for(int i = 0; i<head2head.length; i++){
            
            double game = 0;
            double win = 0;
            double winOver = 0;

            char[] result = head2head[i].toCharArray();

            for(int j = 0; j<result.length; j++){
                if (result[j] != 'N') {
                    game++;

                    if (result[j] == 'W') {
                        win++;
                        if(weights[i] < weights[j]){
                            winOver++;
                        }
                    }
                }
            }

            winning[i][0] = i;
            winning[i][1] = game;
            winning[i][2] = win;
            
            if(game != 0){
                game *= 100;
                win *= 100;
                winning[i][2] = win/game;
            }
            winning[i][3] = winOver;

            
        }


        Arrays.sort(winning, (w1,w2)->{

            if (w2[2] == w1[2]) {
                
                if (w2[3] == w1[3]) {

                    if (weights[(int)w2[0]] == weights[(int)w1[0]]) {
                        return (int)(w1[0] - w2[0]);
                    }

                    return weights[(int)w2[0]] - weights[(int)w1[0]];
                }

                return (int)(w2[3] - w1[3]);

            }
           return w2[2] - w1[2] > 0 ? 1 : -1;
        });


       
        for(int i = 0; i<answer.length; i++){
            answer[i] = (int)winning[i][0]+1;
        }

        return answer;
    }
}
