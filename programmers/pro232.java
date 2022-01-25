package programmers;

import java.util.Arrays;

/* 
    양궁대회
*/
public class pro232 {

    public static void main(String[] args) {

    }

    public int[] solution(int n, int[] info) {

        estimateCost(info);

        answer = new int[11];

        return answer;
    }

    int[] answer;
    double[][] cost;

    void estimateCost(int[] info) {

        cost = new double[10][2];

        for (int i = 0; i < 10; i++) {
            cost[i][0] = 10 - i;
            cost[i][1] = (10 - i) / (double) (info[i] + 1);
        }

        Arrays.sort(cost, (a, b) -> {
            return (b[1] - a[1]) > 0 ? 1 : -1;
        });
    }

    void backTracking(int arrow, int sum, int index) {

        if (arrow == 0 || index == 10) {
            //check
        }

    }

}
