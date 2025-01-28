package boj;

import java.io.*;

/*
 * 회문
 */

public class BOJ17690 {

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        while (N-- > 0) {
            String s = br.readLine();

            sb.append(isPalindrome(s, 0, s.length() - 1));
        }

        System.out.println(sb.toString().trim());

    }

    static String isPalindrome(String s, int left, int right) {

        while (left <= right) {
            if (s.charAt(left) != s.charAt(right)) {

                if (isPseudoPalindrome(s, left + 1, right)
                        || isPseudoPalindrome(s, left, right - 1)) {
                    return "1\n";
                }
                return "2\n";
            }

            left++;
            right--;
        }

        return "0\n";
    }

    static boolean isPseudoPalindrome(String s, int left, int right) {

        while (left <= right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }

}
