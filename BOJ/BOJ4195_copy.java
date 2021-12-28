package BOJ;

/* 
    친구 네트워크
*/

import java.io.*;
import java.util.*;

public class BOJ4195_copy {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            int F = Integer.parseInt(br.readLine());

            friendsId = new HashMap<>();
            id = 0;
            root = new ArrayList<>();
            group = new HashMap<>();

            while (F-- > 0) {

                st = new StringTokenizer(br.readLine());
                int a = getID(st.nextToken());
                int b = getID(st.nextToken());

                a = findRoot(a);
                b = findRoot(b);

                if (a != b) {
                    root.set(b, a);
                    group.put(a, group.getOrDefault(a, 1) + group.getOrDefault(b, 1));
                }

                sb.append(group.get(a)).append("\n");

            }
        }

        System.out.println(sb.toString());
    }

    static HashMap<String, Integer> friendsId;
    static List<Integer> root;
    static HashMap<Integer, Integer> group;
    static int id;

    static int getID(String a) {
        if (!friendsId.containsKey(a)) {
            friendsId.put(a, id);
            root.add(id);
            id++;
        }

        return friendsId.get(a);

    }

    static int findRoot(int a) {
        if (root.get(a) == a) {
            return a;
        }

        root.set(a, findRoot(root.get(a)));

        return root.get(a);
    }

}