package boj;

/*
 * 
 * 3의 배수
 * 
 */

import java.io.*;

public class BOJ1769 {

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String number = br.readLine();

        int count = 0;
        while (number.length() > 1) {
            count++;
            int num = 0;
            for (int i = 0; i < number.length(); i++) {
                num += (number.charAt(i) - '0');
            }
            number = Integer.toString(num);
        }

        StringBuilder sb = new StringBuilder();
        sb.append(count).append("\n");
        sb.append((Integer.parseInt(number) % 3 == 0) ? "YES" : "NO");

        System.out.println(sb.toString());
    }
}
