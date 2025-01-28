package boj;

/*
 * 스위치 켜고 끄기
 */

import java.io.*;
import java.util.*;

public class BOJ1244_copy {

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] isOn = new int[N + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= N; i++) {
            isOn[i] = Integer.parseInt(st.nextToken());
        }

        int M = Integer.parseInt(br.readLine());

        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());

            String student = st.nextToken();
            int num = Integer.parseInt(st.nextToken());

            if (student.equals("1")) {

                for (int i = 1; i * num <= N; i++) {
                    reverseSwitch(isOn, num * i);
                }

            } else {

                reverseSwitch(isOn, num);

                int index = 1;
                while (num - index >= 1 && num + index <= N) {

                    if (isOn[num - index] != isOn[num + index]) {
                        break;
                    }
                    reverseSwitch(isOn, num - index);
                    reverseSwitch(isOn, num + index);

                    index++;
                }

            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {

            sb.append(isOn[i]);

            if (i >= 20 && i % 20 == 0) {
                sb.append("\n");
            } else {
                sb.append(" ");
            }
        }

        System.out.println(sb.toString().trim());

    }

    private static void reverseSwitch(int[] isOn, int num) {

        if (isOn[num] == 1) {
            isOn[num] = 0;
        } else {
            isOn[num] = 1;
        }

    }
}
