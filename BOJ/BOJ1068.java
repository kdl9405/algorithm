package BOJ;

/* 
    트리
*/

import java.io.*;
import java.util.*;

public class BOJ1068 {

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        children = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            children.add(new ArrayList<>());
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int parent = Integer.parseInt(st.nextToken());
            if (parent != -1) {
                children.get(parent).add(i);
            }
        }

        removed = new boolean[N];

        int x = Integer.parseInt(br.readLine());

        removeNode(x);

        int count = 0;
        for (int i = 0; i < N; i++) {
            if (removed[i]) {
                continue;
            }

            if (children.get(i).isEmpty()||(children.get(i).size() == 1 && removed[children.get(i).get(0)])) {
                count++;
            }

        }

        System.out.println(count);

    }

    static List<List<Integer>> children;
    static boolean[] removed;

    static void removeNode(int x) {

        removed[x] = true;

        for (int child : children.get(x)) {
            removeNode(child);
        }
    }
}
