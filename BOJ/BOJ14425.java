package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class BOJ14425 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        HashSet<String> hashSet = new HashSet<>();

        while (n-- > 0) {
            hashSet.add(br.readLine());
        }

        int count = 0;

        while (m-- > 0) {
            String temp = br.readLine();
            if (hashSet.contains(temp)) {
                count++;
            }
        }

        System.out.println(count);
    }
}
