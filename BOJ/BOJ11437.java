package BOJ;

/* 
    LCA
*/

import java.io.*;
import java.util.*;

public class BOJ11437 {

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        links = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            links.add(new ArrayList<>());
        }

        StringTokenizer st;
        for (int i = 1; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            links.get(a).add(b);
            links.get(b).add(a);
        }

        parent = new int[N + 1];
        parent[1] = 1;

        defineParent(1);

        int M = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        while (M-- > 0) {

            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            parentSet = new BitSet();
            findParent(a);

            sb.append(commonAcestor(b)).append("\n");
        }

        System.out.println(sb.toString().trim());

    }

    static List<List<Integer>> links;
    static int[] parent;
    static BitSet parentSet;

    static void defineParent(int p){

        for(int c : links.get(p)){
            if (parent[c] != 0) {
                continue;
            }
            parent[c] = p;

            defineParent(c);
        }
    }

    static void findParent(int a) {

        parentSet.set(a);

        if (a == 1) {
            return;
        }


        findParent(parent[a]);

    }

    static int commonAcestor(int b) {

        if (parentSet.get(b)) {
            return b;
        }

        return commonAcestor(parent[b]);
    }
}
