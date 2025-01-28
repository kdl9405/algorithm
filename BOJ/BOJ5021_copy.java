package boj;

import java.io.*;
import java.util.*;

/*
 * 왕위 계승
 */
public class BOJ5021_copy {

    static Map<String, List<String>> tree = new HashMap<>();
    static Map<String, Boolean> visited = new HashMap<>();
    static Map<String, Double> priority = new HashMap<>();
    static int index = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String answer = "";
        double temp = 0.0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        String root = br.readLine();

        while (n-- > 0) {
            st = new StringTokenizer(br.readLine());
            String child = st.nextToken();
            String parent1 = st.nextToken();
            String parent2 = st.nextToken();

            tree.put(parent1, tree.getOrDefault(parent1, new ArrayList<>()));
            tree.put(parent2, tree.getOrDefault(parent2, new ArrayList<>()));
            tree.put(child, tree.getOrDefault(child, new ArrayList<>()));
            tree.get(child).add(parent1);
            tree.get(child).add(parent2);

        }

        Set<String> keySet = tree.keySet();

        for (String s : keySet) {
            priority.put(s, 0.0);
        }
        priority.put(root, 1.0);

        while (m-- > 0) {
            String candidate = br.readLine();
            temp = dfs(candidate);
            if (answer.isBlank()) {
                answer = candidate;
            } else {
                answer = priority.get(answer) > temp ? answer : candidate;
            }
        }

        // for(String name : priority.keySet()){
        // System.out.println("!! "+ name +" "+priority.get(name));
        // }

        System.out.println(answer);
    }

    static double dfs(String name) {

        // System.out.println((index++) +" "+ name);

        if (!tree.containsKey(name)) {
            return 0.0;
        }

        if (tree.get(name).isEmpty()) {
            // System.out.println("empty!" + name + " " + priority.get(name));
            return priority.get(name);
        }

        double blood = 0;

        for (String parent : tree.get(name)) {

            blood += (dfs(parent) / 2.0);
        }

        priority.put(name, blood);

        return priority.get(name);
    }
}
