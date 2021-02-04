package programmers;

import java.util.LinkedList;
import java.util.List;

/* 
    브라이언의 고민

*/
public class pro123 {
    public static void main(String[] args) {

        String sentence = "xAyAyAxBzCzBzC";

        System.out.println(solution(sentence));
    }

    static String solution(String sentence) {
        String answer = "invalid";

        if (sentence.contains(" ")) {
            return answer;
        }

        lowerAlphabet = new int[26];
        usedAlphabet = new boolean[26];

        for (int i = 0; i < sentence.length(); i++) {
            char c = sentence.charAt(i);
            if (Character.isLowerCase(c)) {
                lowerAlphabet[c - 'a']++;
            }
        }

        List<String> words = new LinkedList<>();

        int startIdx = 0;

        while (startIdx < sentence.length()) {

            if (Character.isLowerCase(sentence.charAt(startIdx))) {
                for (int i = startIdx + 1; i < sentence.length(); i++) {
                    if (sentence.charAt(i) == sentence.charAt(startIdx)) {
                        words.add(sentence.substring(startIdx, i+1));
                        startIdx = i + 1;
                        break;
                    }
                }
            } else {
                System.out.println("!!!!!!!" + sentence.charAt(startIdx));
                if (startIdx == sentence.length()-1) {
                    words.add(sentence.substring(startIdx, sentence.length()));
                    break;
                }else{

                    char c = sentence.charAt(startIdx+1);

                    if (Character.isLowerCase(c)) {
                        for(int i = startIdx; i<sentence.length(); i+=2){

                            if (startIdx+1 < sentence.length() && sentence.charAt(startIdx+1) == c) {
                                continue;
                            }
                            words.add(sentence.substring(startIdx, i+1));
                            startIdx = i+1;
                        }

                    }
                }

            }
        }

        // for (int i = 0; i < sentence.length(); i++) {
        // char c = sentence.charAt(i);
        // if (Character.isLowerCase(c)) {
        // lowerAlphabet[c - 'a']++;
        // }

        // if (i != 0) {
        // if (Character.isLowerCase(c) && Character.isLowerCase(sentence.charAt(i -
        // 1))) {
        // words.add(sentence.substring(startIdx, i));
        // startIdx = i;
        // } else if (Character.isUpperCase(c) &&
        // Character.isUpperCase(sentence.charAt(i - 1))) {
        // words.add(sentence.substring(startIdx, i));
        // startIdx = i;
        // }
        // }
        // if (i == sentence.length() - 1) {
        // words.add(sentence.substring(startIdx, i + 1));
        // }
        // }

        for (String s : words) {
            System.out.println(s);
        }

        StringBuilder sb = new StringBuilder();
        // for (String s : words) {
        // ruleTwo = false;
        // String word = wordCheck(s);
        // if (word.equals("0")) {
        // return answer;
        // } else {
        // sb.append(word + " ");
        // }
        // }

        answer = sb.toString().trim();

        return answer;
    }

    static int[] lowerAlphabet;
    static boolean[] usedAlphabet;
    static boolean ruleTwo;

    static String wordCheck(String word) {

        // 시작이 대문자
        if (Character.isUpperCase(word.charAt(0))) {

            // 규칙1 체크 후 성립하면 제거
            if (word.length() > 2) {
                if (Character.isLowerCase(word.charAt(1))) {
                    char c = word.charAt(1);

                    if (usedAlphabet[c - 'a']) {
                        return "0";
                    }

                    for (int i = 1; i < word.length(); i += 2) {
                        if (word.charAt(i) != c) {
                            return "0";
                        }
                        lowerAlphabet[c - 'a']--;
                        if (lowerAlphabet[c - 'a'] < 0) {
                            return "0";
                        }
                    }
                    word = word.replaceAll(Character.toString(c), "");
                    usedAlphabet[c - 'a'] = true;
                }
            }

        } else { // 시작이 소문자

            char c = word.charAt(0);

            if (usedAlphabet[c - 'a'] || lowerAlphabet[c - 'a'] != 2) {
                return "0";
            }

            for (int i = 1; i < word.length(); i++) {
                if (word.charAt(i) == c) {

                }
            }

        }

        // 소문자가 있으면 wrong;
        for (int i = 0; i < word.length(); i++) {
            if (Character.isLowerCase(word.charAt(i))) {
                return "0";
            }
        }

        return word;
    }
}
