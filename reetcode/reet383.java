package reetcode;

import java.util.*;

public class reet383 {

    public static void main(String[] args) {

    }

    public static boolean canConstruct(String ransomNote, String magazine) {

        Map<Character, Integer> magazineCharCount = new HashMap<>();
        for (char c : magazine.toCharArray()) {
            magazineCharCount.put(c, magazineCharCount.getOrDefault(c, 0) + 1);
        }

        for (char c : ransomNote.toCharArray()) {
            if (!magazineCharCount.containsKey(c) || magazineCharCount.get(c) == 0) {
                return false;
            }
            magazineCharCount.put(c, magazineCharCount.get(c) - 1);
        }

        return true;
    }
}
