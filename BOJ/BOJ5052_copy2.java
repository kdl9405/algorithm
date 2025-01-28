package boj;

import java.io.*;
import java.util.*;

/*
 * 전화번호 목록
 * 
 */
public class BOJ5052_copy2 {
    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        while (t-- > 0) {

            int n = Integer.parseInt(br.readLine());

            Trie trie = new Trie();
            boolean possible = true;

            while (n-- > 0) {
                String number = br.readLine();

                if (!trie.insert(number)) {
                    possible = false;
                }

            }

            if (!possible) {
                sb.append("NO\n");
            } else {
                sb.append("YES\n");
            }

        }

        System.out.println(sb.toString().trim());

    }

    /**
     * Trie
     */
    private static class TrieNode {

        boolean isLast;
        HashMap<Character, TrieNode> children;

        public TrieNode() {
            isLast = false;
            children = new HashMap<>();
        }
    }

    private static class Trie {

        public TrieNode root;

        public Trie() {
            this.root = new TrieNode();
        }

        public boolean insert(String number) {

            TrieNode node = this.root;

            for (int i = 0; i < number.length() - 1; i++) {

                char c = number.charAt(i);
                if (!node.children.containsKey(c)) {
                    node.children.put(c, new TrieNode());
                }
                node = node.children.get(c);

                if (node.isLast) {
                    return false;
                }

            }

            if (node.children.containsKey(number.charAt(number.length() - 1))) {
                return false;
            }

            node.children.put(number.charAt(number.length() - 1), new TrieNode());
            node.children.get(number.charAt(number.length() - 1)).isLast = true;

            return true;

        }
    }
}
