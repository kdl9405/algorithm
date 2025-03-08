package leetcode;

import java.util.*;

public class leet290 {

    public static void main(String[] args) {

    }

    public static boolean wordPattern(String pattern, String s) {

        Map<String, Character> wordMap = new HashMap<String, Character>();
        Set<Character> usedAlphabet = new HashSet<>();

        String[] words = s.split(" ");

        if (words.length != pattern.length()) {
            return false;
        }

        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            char c = pattern.charAt(i);

            if (wordMap.containsKey(word)) {
                if (!wordMap.get(word).equals(c)) {
                    return false;
                }
            } else if (usedAlphabet.contains(c)) {
                return false;
            } else {
                wordMap.put(word, c);
                usedAlphabet.add(c);
            }
        }

        return true;
    }
}
