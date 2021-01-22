package programmers;

import java.util.Arrays;

//실패율

public class pro116 {
    public static void main(String[] args) {
        int N = 9;
        int[] stages = { 4, 4, 4, 4, 4 };

        int[] ans = solution(N, stages);

        for (int n : ans) {
            System.out.println(n);
        }

    }

    static int[] solution(int N, int[] stages) {
        int[] answer = new int[N];

        int[] count = new int[N];
        for (int s : stages) {
            if (s > N) {
                continue;
            }
            count[s - 1]++;
        }

        double[][] failer = new double[N][2];
        double user = stages.length;
        for (int i = 0; i < N; i++) {

            failer[i][0] = i + 1;
            failer[i][1] = count[i] / user;

            if (user == 0) {
                failer[i][1] = 0;
            }

            user -= count[i];
        }

        for (int i = 0; i < N; i++) {

            System.out.println(failer[i][0] + " = " + failer[i][1]);
        }

        Arrays.sort(failer, (f1, f2) -> {
            if (f1[1] == f2[1]) {
                return (int) f1[0] - (int) f2[0];
            } else {
                return Double.compare(f2[1], f1[1]);
            }
        });

        for (int i = 0; i < N; i++) {
            answer[i] = (int) failer[i][0];
        }

        return answer;
    }
}