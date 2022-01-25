package programmers;

import java.util.*;

/* 
    양궁대회
*/
public class pro232_copy1 {

    public static void main(String[] args) {

        new pro232_copy1().test();
    }

    void test() {
        int n = 5;
        int[] info = { 2, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0 };

        int[] A = solution(n, info);
        for (int a : A) {
            System.out.print(a + " ");
        }
    }

    public int[] solution(int n, int[] info) {

        estimateCost(info);

        answer = new int[11];
        result = false;

        backTracking(n, 0, 0, 0);

        
        if (!result) {
            answer = new int[] { -1 };
        } else {
            answer[10] = n;
            for (int i = 0; i < 10; i++) {
                answer[10] -= answer[i];
            }
        }

        return answer;
    }

    int[] answer;
    double[][] cost;
    boolean result;

    void estimateCost(int[] info) {

        cost = new double[10][3]; // 점수, 어피치의 화살개수, 효율

        for (int i = 0; i < 10; i++) {
            cost[i][0] = 10 - i;
            cost[i][1] = info[i];
            if (info[i] == 0) {
                cost[i][2] = 10 - i;
            } else {
                cost[i][2] = (10 - i) * 2 / (double) (info[i] + 1);
            }

        }

        Arrays.sort(cost, (a, b) -> {

            if (a[2] == b[2]) {
                return (int) (a[1] - b[1]);
            }

            return (b[2] - a[2]) > 0 ? 1 : -1;
        });

    }

    void backTracking(int arrow, int apeach, int ryan, int index) {

        if (result) {
            return;
        }

        if (arrow >= 0 && index == 10) {

            if (ryan > apeach) {
                result = true;
            }

            return;
        }

        int point = (int) cost[index][0];

        if (arrow > cost[index][1]) {
            answer[10 - point] = (int) cost[index][1] + 1;
            backTracking(arrow - answer[10 - point], apeach, ryan + point, index + 1);
        }

        if (cost[index][1] == 0) {
            backTracking(arrow, apeach, ryan, index + 1);
        } else {
            backTracking(arrow, apeach + point, ryan, index + 1);
        }

    }

}
