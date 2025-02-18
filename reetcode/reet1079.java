package reetcode;

import java.io.*;

public class reet1079 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String tiles = br.readLine();

        System.out.println(numTilePossibilities(tiles));
    }

    public static int numTilePossibilities(String tiles) {

        int[] alphabets = new int[26];
        for (char c : tiles.toCharArray()) {
            alphabets[c - 'A']++;
        }

        return findSubSequencesCount(alphabets);
    }


    private static int findSubSequencesCount(int[] alphabets) {

        int count = 0;

        for (int i = 0; i < 26; i++) {
            if (alphabets[i] == 0)
                continue;

            alphabets[i]--;
            count += 1 + findSubSequencesCount(alphabets);
            alphabets[i]++;
        }

        return count;
    }



    // 개선 전..
    /*
     * public static Set<String> wordsSet;
     * 
     * public static int numTilePossibilities(String tiles) {
     * 
     * boolean[] usedChars = new boolean[tiles.length()]; char[] word = new char[tiles.length()];
     * Arrays.fill(word, ' ');
     * 
     * wordsSet = new HashSet<>(); backtracking(tiles, usedChars, word, 0);
     * 
     * return wordsSet.size() - 1; }
     * 
     * public static void backtracking(String tiles, boolean[] usedChars, char[] word, int index) {
     * 
     * wordsSet.add(Arrays.toString(word));
     * 
     * if (index == tiles.length()) { return; }
     * 
     * for (int i = 0; i < tiles.length(); i++) { if (usedChars[i]) continue;
     * 
     * usedChars[i] = true; word[index] = tiles.charAt(i); backtracking(tiles, usedChars, word,
     * index + 1);
     * 
     * usedChars[i] = false; word[index] = ' '; } }
     */
}
