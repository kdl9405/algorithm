package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
 * 전화번호 목록
 * 
 * 배열 이용
 */
public class BOJ5052_copy {
    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        while (t-- > 0) {

            int n = Integer.parseInt(br.readLine());

            String[] number = new String[n];

            for (int i = 0; i < n; i++) {
                number[i] = br.readLine();
            }

            Arrays.sort(number);

            boolean check = true;

            for (int i = 0; i < n - 1; i++) {

                if (number[i].length() > number[i + 1].length()) {
                    continue;
                }

                if (number[i + 1].substring(0, number[i].length()).contains(number[i])) {
                    check = false;
                    break;
                }
            }

            if (check) {
                sb.append("YES").append("\n");
            } else {
                sb.append("NO").append("\n");
            }

        }

        System.out.println(sb.toString().trim());

    }
}
