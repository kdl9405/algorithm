package boj;

/*
 * 시리얼 번호
 * 
 */

import java.io.*;
import java.util.*;

public class BOJ1431 {

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        Guitar[] guitars = new Guitar[N];
        for (int i = 0; i < N; i++) {
            String serial = br.readLine();
            int length = serial.length();
            int sum = 0;
            for (int j = 0; j < length; j++) {
                if (Character.isDigit(serial.charAt(j))) {
                    sum += (serial.charAt(j) - '0');
                }
            }

            guitars[i] = new Guitar(serial, length, sum);
        }

        Arrays.sort(guitars);

        StringBuilder answer = new StringBuilder();
        for (Guitar g : guitars) {
            answer.append(g.serial).append("\n");
        }

        System.out.println(answer.toString().trim());

    }

    private static class Guitar implements Comparable<Guitar> {

        String serial;
        int length;
        int sum;

        public Guitar(String serial, int length, int sum) {
            this.serial = serial;
            this.length = length;
            this.sum = sum;
        }

        @Override
        public int compareTo(Guitar o) {
            if (length == o.length) {

                if (sum == o.sum) {
                    return serial.compareTo(o.serial);
                }

                return sum - o.sum;
            }

            return length - o.length;
        }
    }
}
