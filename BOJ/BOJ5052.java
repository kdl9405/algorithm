package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;

/* 
    전화번호 목록

    배열 이용
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

class Node {
    int depth;
    char num;
    boolean isLast;
    HashMap<Character, Node> children;
}

class Trie {
    public Node root;

    Trie() {
        this.root = new Node();
    }

    public boolean insertCheck(String number) {
        Node node = this.root;

        for (int i = 0; i < number.length(); i++) {
            if (!node.children.containsKey(number.charAt(i))) {
                node.children.put(number.charAt(i), new Node());
            }
            node = node.children.get(number.charAt(i));
            if (node.isLast) {
                return false;
            }
        }
        node.isLast = true;

        return true;
    }
}