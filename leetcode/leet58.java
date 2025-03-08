package leetcode;

public class leet58 {

    public static void main(String[] args) {

    }

    public int lengthOfLastWord(String s) {

        String[] words = s.split(" ");

        return words[words.length - 1].length();
    }
}
