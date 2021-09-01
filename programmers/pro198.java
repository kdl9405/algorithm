package programmers;

import java.util.HashMap;

public class pro198 {

    public static void main(String[] args) {

        String[] words = {"frodo", "front", "frost", "frozen", "frame", "kakao"};
        String[] queries = {"fro??", "????o", "fr???", "fro???", "pro?"};

        solution(words, queries);

    }

    public static int[] solution(String[] words, String[] queries) {
        int[] answer = new int[queries.length];

        Trie trie = new Trie();
        Trie reverse = new Trie();

        for(String word : words){
            trie.insert(word);
            reverse.insert(new StringBuilder(word).reverse().toString());
        }

        for(int i = 0; i<queries.length; i++){
            if (queries[i].charAt(0) == '?') {
                answer[i] = reverse.find(new StringBuilder(queries[i]).reverse().toString(), 0);
            }else{
                answer[i] = trie.find(queries[i], 0);
            }
        }
        

        return answer;
    }

    /**
     * Innerpro198
     */
    static class Trie {

        HashMap<Integer, Integer> lengthWord = new HashMap<>();
        Trie[] child = new Trie[26];

        void insert(String s) {
            Trie node = this;
            int len = s.length();
            lengthWord.put(len, lengthWord.getOrDefault(len, 0) + 1);

            for (char c : s.toCharArray()) {
                int i = c - 'a';
                if (node.child[i] == null) {
                    node.child[i] = new Trie();
                }

                node = node.child[i];
                node.lengthWord.put(len, node.lengthWord.getOrDefault(len, 0) + 1);
            }
        }



        int find(String s, int i) {
            if (s.charAt(i) == '?') {

                return lengthWord.getOrDefault(s.length(), 0);
            }

            int c = s.charAt(i) - 'a';

            if (child[c] == null) {

                return 0;
            }else {
                return child[c].find(s, i+1);
            }
        }

      
    }

}
