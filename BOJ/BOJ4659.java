package boj;

/*
 * 비밀번호 발음하기
 */

import java.io.*;
import java.util.*;

public class BOJ4659 {

    public static void main(String[] args) throws IOException {

        init();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder answer = new StringBuilder();

        while (true) {
            String password = br.readLine();
            if (password.equals("end")) {
                break;
            }

            answer.append("<").append(password).append(">");

            if (isPerfect(password)) {
                answer.append(PERFECT);
            } else {
                answer.append(INPERFECT);
            }
        }

        System.out.println(answer.toString().trim());
    }

    static final String PERFECT = " is acceptable.\n";
    static final String INPERFECT = " is not acceptable.\n";
    static Set<Character> vowels;

    static void init() {
        vowels = new HashSet<>();
        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');
    }

    static boolean isPerfect(String password) {

        Set<Character> set = new HashSet<>();

        int vowelCnt = 0;
        int consonantCnt = 0;

        for (int i = 0; i < password.length(); i++) {

            char p = password.charAt(i);

            if (i > 0 && p != 'e' && p != 'o' && password.charAt(i - 1) == p) {
                return false;
            }

            set.add(p);

            if (vowels.contains(p)) {
                if (consonantCnt != 0) {
                    consonantCnt = 0;
                }
                vowelCnt++;
            } else {
                if (vowelCnt != 0) {
                    vowelCnt = 0;
                }
                consonantCnt++;
            }

            if (vowelCnt >= 3 || consonantCnt >= 3) {
                return false;
            }
        }

        for (char v : vowels) {
            if (set.contains(v)) {
                return true;
            }
        }

        return false;
    }

}
