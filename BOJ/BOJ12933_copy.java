package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
    오리

    실패.. = > 예외조건 !!  
                1. 입력이 5로 나누어져야함.
                2. 오리의 개수가 0보다 커야함
                3. 모든 입력을 방문해야함
 */

public class BOJ12933_copy {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String duck = br.readLine();

        if (duck.length() % 5 != 0) {
            System.out.println(-1);
        } else {
            int[] arr = new int[5];

            int max = 0;

            for (char c : duck.toCharArray()) {

                int i = charToInt(c);
                if (i == 0) {
                    arr[i]++;
                    max = Math.max(max, arr[i]);
                } else {
                    if (arr[i - 1] > arr[i]) {
                        arr[i]++;

                        if (i == 4) {
                            arr[0]--;
                            arr[1]--;
                            arr[2]--;
                            arr[3]--;
                            arr[4]--;
                        }

                    } else {
                        max = -1;
                        break;
                    }
                }
            }

            System.out.println(max);
        }

    }

    static int charToInt(char c) {

        int i = 0;

        switch (c) {
        case 'q':
            i = 0;
            break;
        case 'u':
            i = 1;
            break;
        case 'a':
            i = 2;
            break;
        case 'c':
            i = 3;
            break;
        case 'k':
            i = 4;
            break;

        }

        return i;
    }
}
