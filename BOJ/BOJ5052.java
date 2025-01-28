package boj;

import java.io.*;

/*
 * 전화번호 목록
 * 
 */
public class BOJ5052 {
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
        TrieNode[] children;

        public TrieNode(boolean isLast) {
            this.isLast = isLast;
            this.children = new TrieNode[10];
        }
    }

    private static class Trie {

        public TrieNode root;

        public Trie() {
            this.root = new TrieNode(false);
        }

        public boolean insert(String number) {

            TrieNode node = this.root;

            int i = 0;
            int c;
            for (; i < number.length() - 1; i++) {

                c = number.charAt(i) - '0';
                if (node.children[c] == null) {
                    node.children[c] = new TrieNode(false);
                }
                node = node.children[c];

                if (node.isLast) {
                    return false;
                }

            }

            c = number.charAt(i) - '0';
            if (node.children[c] != null) {
                return false;
            }

            node.children[c] = new TrieNode(true);
            return true;

        }
    }
}
