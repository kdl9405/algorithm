package naver.cloud;

import java.util.Arrays;

public class t4_copy {

    public static void main(String[] args) {

        int[][] info = { { 2, 3 }, { 2, 5 }, { 3, 3 }, { 2, 2 } };

        System.out.println(solution(info));

    }

    public static int[] solution(int[][] info) {
        int[] answer = {};

        Arrays.sort(info, (a, b) -> {

            if (a[0] == b[0]) {
                return a[1] - b[1];
            }

            return a[0] - b[0];
        });

        int[][] time = new int[86400][2];
        for (int i = 0; i < 86400; i++) {
            time[i][0] = i;
        }

        int count = 0;
        int s = info[0][0];
        int e = info[0][1];

        while (s < info.length) {

            int start = info[s][0];

            for (; s < info.length; s++) {
                if (info[s][0] == start) {
                    count++;
                } else {
                    break;
                }
            }

            for (; e < s; e++) {

                System.out.println(e + " " + s);

                if (s <= info.length) {
                    if (info[e][1] < info[s][0]) {
                        time[info[e][1]][1] = count;
                        count--;
                    } else {
                        break;
                    }

                } else {

                }
            }
        }

        for (int i = 0; i < 6; i++) {
            System.out.println(time[i][1]);
        }

        return answer;
    }
}
