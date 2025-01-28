package boj;

/*
 * 팰린드롬
 */

import java.io.*;

public class BOJ8892 {

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        StringBuilder answer = new StringBuilder();

        loop: while (T-- > 0) {

            int k = Integer.parseInt(br.readLine());

            String[] str = new String[k];
            for (int i = 0; i < k; i++) {
                str[i] = br.readLine();
            }

            for (int i = 0; i < k - 1; i++) {
                for (int j = i + 1; j < k; j++) {
                    if (isPalindrome(str[i] + str[j])) {
                        answer.append(str[i]).append(str[j]).append("\n");
                        continue loop;
                    }

                    if (isPalindrome(str[j] + str[i])) {
                        answer.append(str[j]).append(str[i]).append("\n");
                        continue loop;
                    }
                }
            }

            answer.append("0\n");
        }

        System.out.println(answer.toString().trim());
    }

    public static boolean isPalindrome(String s) {

        int len = s.length();

        for (int i = 0; i <= len / 2; i++) {
            if (s.charAt(i) != s.charAt(len - 1 - i)) {
                return false;
            }
        }

        return true;
    }

}
