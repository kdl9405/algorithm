package boj;

/*
 * 
 * 베스트셀러
 * 
 */

import java.io.*;
import java.util.*;

public class BOJ1302 {

    public static void main(String[] args) throws NumberFormatException, IOException {

        new BOJ1302().solution();
    }

    void solution() throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        Map<String, Integer> bestselller = new HashMap<>();
        while (N-- > 0) {

            String book = br.readLine();

            bestselller.put(book, bestselller.getOrDefault(book, 0) + 1);
        }

        int cnt = 0;
        String max = "";
        for (String b : bestselller.keySet()) {
            if (cnt < bestselller.get(b)) {
                cnt = bestselller.get(b);
                max = b;
            } else if (cnt == bestselller.get(b)) {
                if (max.compareTo(b) > 0) {
                    max = b;
                }
            }
        }

        System.out.println(max);
    }

}
