package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;

/*
 * 듣보잡
 */
public class BOJ1764 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        StringBuilder sb = new StringBuilder();
        // HashMap<Character, HashSet<String>> dictionary = new HashMap<>();
        HashSet<String> set = new HashSet<>();

        for (int i = 0; i < n; i++) {
            String name = br.readLine();
            set.add(name);
        }

        HashSet<String> duplication = new HashSet<>();

        for (int i = 0; i < m; i++) {
            String name = br.readLine();
            if (set.contains(name)) {
                duplication.add(name);
            }
        }

        OBOJect[] result = duplication.toArray();
        Arrays.sort(result);

        sb.append(result.length);
        for (OBOJect o : result) {
            sb.append("\n").append(o);
        }

        System.out.println(sb.toString());
    }
}
