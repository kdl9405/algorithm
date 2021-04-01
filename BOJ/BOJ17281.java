package BOJ;

import java.io.*;
import java.util.Arrays;

/* 
    ⚾ 
 */

// 이닝과 타자의 득점은 배열로 구현
// 순열은 다음순열을 구하는 함수로 구함  .. 순열을 어떤 자료구조에 담을 것인가
// 이닝 진행하여 득점 계산..
// => 다음 순열을 구하는 함수에서 순열 복사 부분을 바꾸면 리펙토링 가능!

public class BOJ17281 {

    static int[][] points;
    static boolean last;
    static int[] lineUp;
    static int N, max;

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        points = new int[N][9];

        for (int i = 0; i < N; i++) {
            points[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        lineUp = new int[] { 2, 3, 4, 1, 5, 6, 7, 8, 9 };
        last = false;
        max = Integer.MIN_VALUE;

        while (!last) {

            play();
            nextLineup();

        }

        System.out.println(max);

    }

    static void play() {

        int point = 0;

        int player = 0;
        for (int i = 0; i < N; i++) { // 게임 시작
            int out = 0;
            boolean[] position = new boolean[4];

            while (out < 3) {

                switch (points[i][lineUp[player] - 1]) {
                case 0:
                    out++;
                    break;
                case 1:
                    if (position[3]) {
                        point++;
                        position[3] = false;
                    }
                    for (int p = 2; p >= 1; p--) {
                        if (position[p]) {
                            position[p + 1] = true;
                            position[p] = false;
                        }
                    }
                    position[1] = true;
                    break;
                case 2:
                    if (position[3]) {
                        position[3] = false;
                        point++;
                    }
                    if (position[2]) {
                        position[2] = false;
                        point++;
                    }
                    if (position[1]) {
                        position[1] = false;
                        position[3] = true;
                    }
                    position[2] = true;
                    break;
                case 3:
                    for (int p = 3; p >= 1; p--) {
                        if (position[p]) {
                            position[p] = false;
                            point++;
                        }
                    }
                    position[3] = true;

                    break;
                case 4:
                    for (int p = 3; p >= 1; p--) {
                        if (position[p]) {
                            position[p] = false;
                            point++;
                        }
                    }
                    point++;
                    break;

                }

                player++;

                if (player == 9) {
                    player = 0;
                }
            }

        }
       
        max = Math.max(max, point);

    }

    static void nextLineup() {

        int[] temp = new int[8];
        for (int i = 0; i < 3; i++) {
            temp[i] = lineUp[i];
        }
        for (int i = 3; i < 8; i++) {
            temp[i] = lineUp[i + 1];
        }

        int idx = -1;
        for (int i = 0; i < 7; i++) {
            if (temp[i] < temp[i + 1]) {
                idx = i;
            }
        }

        if (idx < 0) {
            last = true;
            return;
        }

        for (int i = 7; i > idx; i--) {
            if (temp[idx] < temp[i]) {
                int t = temp[idx];
                temp[idx] = temp[i];
                temp[i] = t;
                break;
            }
        }

        Arrays.sort(temp, idx + 1, 8);

        for (int i = 0; i < 3; i++) {
            lineUp[i] = temp[i];
        }
        for (int i = 4; i < 9; i++) {
            lineUp[i] = temp[i - 1];
        }

        return;
    }
}
