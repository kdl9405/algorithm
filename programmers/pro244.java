package programmers;

import java.util.*;

public class pro244 {

    public int solution(String[] words) {
        int answer = 0;

        Trie trie = new Trie();

        for (String word : words) {
            trie.insert(word);
        }

        for (String word : words) {
            answer += trie.countTyping(word);
        }

        return answer;
    }

}

class TrieNode {
    Map<Character, TrieNode> children = new HashMap<>();
    int count = 0;
}

class Trie {
    private final TrieNode root = new TrieNode();

    public void insert(String word) {
        TrieNode node = root;

        for (char ch : word.toCharArray()) {
            node.count++;
            node = node.children.computeIfAbsent(ch, c -> new TrieNode());
        }
        node.count++;
    }

    public int countTyping(String word) {
        TrieNode node = root;
        int count = 0;

        for (char ch : word.toCharArray()) {
            count++;
            node = node.children.get(ch);
            if (node.count == 1)
                break;
        }

        return count;
    }

}
