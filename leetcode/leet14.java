package leetcode;

public class leet14 {

    public static void main(String[] args) {

    }

    public String longestCommonPrefix(String[] strs) {

        StringBuilder prefix = new StringBuilder();

        loop: for (int i = 0; i < strs[0].length(); i++) {

            char c = strs[0].charAt(i);

            for (int j = 1; j < strs.length; j++) {
                if (i >= strs[j].length() || c != strs[j].charAt(i)) {
                    break loop;
                }
            }

            prefix.append(c);
        }


        return prefix.toString();
    }
}
