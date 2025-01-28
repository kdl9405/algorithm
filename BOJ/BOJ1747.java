package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 소수&팰린드롬
 * 
 * 1. 에라토스테네스의 체를 통해 소수를 판별 2. 소수를 판별하는 과정 중에서, 펠린드롬 수도 같이 판별 3. N부터 조회해가면서, 해당하는 값을 찾음
 */
public class BOJ1747 {

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int answer = 2000000;

        number = new boolean[2000001];

        for (int i = 2; i < 2000001; i++) {
            if (number[i]) {
                continue;
            }

            if (i >= n && check(i)) {
                answer = i;
                break;
            }

            for (int j = 2; i * j <= 2000000; j++) {

                number[i * j] = true;

            }
        }

        System.out.println(answer);

    }

    static boolean[] number;

    static boolean check(int x) {
        String s = Integer.toString(x);

        for (int i = 0; i <= s.length() / 2; i++) {
            if (s.charAt(i) != s.charAt(s.length() - 1 - i)) {
                return false;
            }
        }

        return true;
    }


}
