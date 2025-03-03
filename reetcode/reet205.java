package reetcode;

import java.util.*;

public class reet205 {

    public static void main(String[] args) {
        var s = "badc";
        var t = "baba";

        System.out.println(isIsomorphic(s, t)); // true
    }

    public static boolean isIsomorphic(String s, String t) {

        Map<Character, Character> alphabetMap = new HashMap<Character, Character>();
        Set<Character> usedAlphabet = new HashSet<>();

        for (int i = 0; i < s.length(); i++) {
            char sChar = s.charAt(i);
            char tChar = t.charAt(i);

            if (alphabetMap.containsKey(sChar)) {
                if (alphabetMap.get(sChar) != tChar) {
                    return false;
                }
            } else if (usedAlphabet.contains(tChar)) {
                return false;
            } else {
                alphabetMap.put(sChar, tChar);
                usedAlphabet.add(tChar);
            }
        }

        return true;
    }
}
