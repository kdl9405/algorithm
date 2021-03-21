package BOJ;

import java.io.*;
import java.util.*;

/* 
    전화번호 목록

*/
public class BOJ5052 {
    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        while (t-- > 0) {

            int n = Integer.parseInt(br.readLine());

            Trie trie = new Trie();
            boolean check = true;

            while (n-- > 0) {
                String number = br.readLine();
                if (!trie.insertCheck(number)){
                    check = false;
                    break;
                }
            }

            if (check) {
                sb.append("YES").append("\n");
            } else {
                sb.append("NO").append("\n");
            }

        }

        System.out.println(sb.toString().trim());

    }
}

class TrieNode {
    int count;
    char num;
    boolean isLast;
    HashMap<Character, TrieNode> children;

    public TrieNode(){
        this.count = 0;
        this.isLast = false;
        this.children = new HashMap<>();

    }
}

class Trie {
    public TrieNode root;

    Trie() {
        this.root = new TrieNode();
    }

    public boolean insertCheck(String number) {
        TrieNode node = this.root;

        for (int i = 0; i < number.length(); i++) {

            if (!node.children.containsKey(number.charAt(i))) {
                node.children.put(number.charAt(i), new TrieNode());
            }
            node = node.children.get(number.charAt(i));
            node.count++;

            if (node.isLast) {
                return false;
            }            
        }

        if (node.count > 1) {
            return false;
        }
        node.isLast = true;

        return true;
    }
}