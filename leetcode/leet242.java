package leetcode;

import java.util.*;

public class leet242 {

    public static void main(String[] args) {

        String s = "anagram";
        String t = "nagaram";

        System.out.println(isAnagram(s, t));
    }

    public static boolean isAnagram(String s, String t) {

        if (s.length() != t.length())
            return false;

        Map<Character, Integer> alphabets = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char sChar = s.charAt(i);
            char tChar = t.charAt(i);

            alphabets.put(sChar, alphabets.getOrDefault(sChar, 0) + 1);
            alphabets.put(tChar, alphabets.getOrDefault(tChar, 0) - 1);
        }

        for (char alphabet : alphabets.keySet()) {
            if (alphabets.get(alphabet) != 0)
                return false;
        }

        return true;
    }
}
