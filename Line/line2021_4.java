package Line;

import java.util.*;

public class line2021_4 {

    public static void main(String[] args) {
        String[] data = { "1 BROWN 0", "2 CONY 0", "3 DOLL 1", "4 DOLL 2", "5 LARGE-BROWN 3", "6 SMALL-BROWN 3",
                "7 BLACK-CONY 4", "8 BROWN-CONY 4" };
        String word = "BROWN";

        String[] result = solution(data, word);
        for (String s : result) {
            System.out.println(s);
        }

    }

    public static String[] solution(String[] data, String word) {
        Trie trie = new Trie();

        for(int i = 0; i<data.length; i++){
            String[] detail = data[i].split(" ");
            System.out.println(" !!!!!  " + i);
            trie.insert(Integer.parseInt(detail[0]), detail[1], Integer.parseInt(detail[2]));
        }

        List<TrieNode> leaf = trie.findLeaf();

        for(TrieNode child : leaf){
            if (child.name.contains(word)) {
                list.add(child);
            }
        }
        List<TrieNode> list = new ArrayList<>();
        Collections.sort(lsit, (l1,l2)->{
            String name1 = l1.name.replaceAll(word,"*").replaceAll("[^*]","");
            String name2 = l2.name.replaceAll(word,"*").replaceAll("[^*]","");
            if(name1.length() == name2.lenght()){
                name1 = l1.name.replaceAll(word,"*");
                name2 = l2.name.replaceAll(word,"*");
                int x = 0;
                int y = 0;
                while(!l1.charAt(x) == '*'){
                    x++
                }
                while(!l2.charAt(x) == '*'){
                    y++
                }
                return x-y;
            }
            return name1.length() - name2.lenght();
        })
        

        String[] answer = {};
        return answer;
    }
}

class TrieNode {
    int id;
    String name;
    boolean isLast;
    TrieNode parent;
    List<TrieNode> children;
}

class Trie {
    public TrieNode root;

    Trie() {
        this.root = new TrieNode();
        root.children = new LinkedList<>();
    }

    public void insert(int id, String name, int parent) {
        TrieNode node = this.root;

        if (node.id != parent) {
            Queue<TrieNode> queue = new LinkedList<>();
            queue.offer(node);

            loop:
            while (true) {
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    TrieNode temp = queue.poll();
                    for(TrieNode child : temp.children){
                        if (child.id == parent) {
                            node = child;
                            break loop;
                        }
                        queue.offer(child);
                    }
                }
            }            
        }
        
        TrieNode child = new TrieNode();
        child.id = id;
        child.name = name;
        child.parent = node;
        child.children = new LinkedList<>();
        child.isLast = true;
        node.children.add(child);
        node.isLast = false;

    }

    public List<TrieNode> findLeaf(){
        List<TrieNode> list = new ArrayList<>();

        Queue<TrieNode> queue = new LinkedList<>();
        queue.offer(this.root);

        while (!queue.isEmpty()) {
            
            TrieNode node = queue.poll();
            if (node.isLast) {
                list.add(node);
            }else{
                queue.addAll(node.children);
            }           
        }
        return list;
    }   
    
}
