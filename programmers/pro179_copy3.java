package programmers;

import java.io.*;
import java.util.*;

/* 
    문자열 지옥에 빠진 호석

    트라이.....ㅜㅜ
*/
public class pro179_copy3 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        map = new char[N + 1][M + 1];

        Trie trie = new Trie();

        Queue<int[]> queue = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j + 1] = line.charAt(j);
                queue.add(new int[] { i, j + 1 });
                trie.insert(1, ' ', line.charAt(j));
            }
        }

        for (int i = 2; i <= 5; i++) {
            Queue<int[]> temp = new LinkedList<>();

            while (!queue.isEmpty()) {
                int[] now = queue.poll();

                for (int j = 0; j < 8; j++) {
                    int nx = now[0] + d[j][0];
                    int ny = now[1] + d[j][1];

                    if (nx == 0) {
                        nx = N;
                    } else if (nx > N) {
                        nx = 1;
                    }
                    if (ny == 0) {
                        ny = M;
                    } else if (ny > M) {
                        ny = 1;
                    }

                    trie.insert(i, map[now[0]][now[1]], map[nx][ny]);
                    temp.add(new int[] { nx, ny });

                }
            }

            queue.addAll(temp);
        }

        StringBuilder sb = new StringBuilder();
        while (K-- > 0) {
            sb.append(trie.findCount(br.readLine())).append("\n");
        }

        System.out.println(sb.toString().trim());

    }

    static int N, M;
    static char[][] map;
    static HashMap<Character, List<int[]>> hashMap;
    static int[][] d = { { -1, -1 }, { -1, 0 }, { -1, 1 }, { 0, -1 }, { 0, 1 }, { 1, -1 }, { 1, 0 }, { 1, 1 } };
    static HashMap<Character, HashMap<Character, List<int[]>>> start;

}

class TrieNode {

    char c;
    int depth;
    int count;
    List<TrieNode> children;

    public TrieNode(int depth, char c) {
        this.depth = depth;
        this.c = c;
        this.children = new ArrayList<>();
    }

}

class Trie {

    public TrieNode root;

    public Trie() {
        this.root = new TrieNode(0, ' ');
    }

    public void insert(int depth, char p, char c) {
        List<TrieNode> parents = find(depth - 1, p);

        for (TrieNode parent : parents) {
            if (!contains(parent, c)) {
                parent.children.add(new TrieNode(depth, c));
            }
            for (TrieNode child : parent.children) {
                if (child.c == c) {
                    child.count++;
                    break;
                }
            }
        }
    }

    public List<TrieNode> find(int depth, char p) { // depth == depth고 charcter = p인 노드 리스트
        List<TrieNode> list = new ArrayList<>();

        if (depth == 0) {
            list.add(root);
            return list;
        }

        Queue<TrieNode> queue = new LinkedList<>();
        queue.add(root);
        int d = 0;

        while (d++ < depth) {

            Queue<TrieNode> temp = new LinkedList<>();

            while (!queue.isEmpty()) {
                TrieNode now = queue.poll();

                temp.addAll(now.children);
            }

            queue.addAll(temp);
        }

        for (TrieNode q : queue) {
            if (q.c == p) {
                list.add(q);
            }
        }

        return list;
    }

    public boolean contains(TrieNode parent, char c) {
        for (TrieNode child : parent.children) {
            if (child.c == c) {
                return true;
            }
        }
        return false;
    }

    public int findCount(String S) {

        TrieNode parent = root;

        for (int i = 0; i < S.length(); i++) {

            if (!contains(parent, S.charAt(i))) {
                return 0;
            }
            for (TrieNode p : parent.children) {
                if (p.c == S.charAt(i)) {
                    parent = p;
                    break;
                }
            }

            System.out.println("i = " +i +"  count = "+ parent.count);

        }
       
        return parent.count;
    }
}
