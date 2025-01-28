package boj;

import java.io.*;
import java.util.*;

/*
 * 왕위 계승
 */
public class BOJ5021 {

    static HashMap<String, Double> bloods;
    static HashMap<String, List<String>> parents;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        String king = br.readLine();

        parents = new HashMap<>();

        while (N-- > 0) {
            String[] input = br.readLine().split(" ");

            parents.put(input[0], new ArrayList<>());
            parents.get(input[0]).add(input[1]);
            parents.get(input[0]).add(input[2]);

        }

        bloods = new HashMap<>();
        bloods.put(king, 1.0);

        String nextKing = "";
        double max = -1;

        while (M-- > 0) {
            String name = br.readLine();
            double blood = findKing(name);
            if (blood > max) {
                max = blood;
                nextKing = name;
            }

        }

        System.out.println(nextKing + " " + findKing(nextKing));


        for (String s : bloods.keySet()) {
            System.out.println(s + " " + findKing(s));
        }
    }

    static double findKing(String child) {

        if (bloods.containsKey(child)) {
            return bloods.get(child);
        }

        if (!parents.containsKey(child)) {
            return 0;
        }

        double blood = 0;

        for (String parent : parents.get(child)) {

            blood += (findKing(parent) / 2.0);
        }

        bloods.put(child, blood);

        return blood;

    }
}
