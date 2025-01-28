package boj;

/*
 * 비슷한 단어
 */

import java.io.*;
import java.util.*;

public class BOJ2607 {

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Map<Character, Integer> origin = new HashMap<>();
        Map<Character, Integer> temp = new HashMap<>();
        String originWord = br.readLine();
        for (char c : originWord.toCharArray()) {
            origin.put(c, origin.getOrDefault(c, 0) + 1);
            temp.put(c, 0);
        }

        int answer = 0;

        for (int i = 1; i < n; i++) {
            String targetWord = br.readLine();

            if (Math.abs(targetWord.length() - originWord.length()) > 1) {
                continue;
            }

            Map<Character, Integer> target = new HashMap<>(temp);
            for (char c : targetWord.toCharArray()) {
                target.put(c, target.getOrDefault(c, 0) + 1);
            }

            int distance = 0;
            for (char c : target.keySet()) {
                if (origin.containsKey(c)) {
                    distance += (Math.abs(origin.get(c) - target.get(c)));
                } else {
                    distance += (target.get(c));
                }
            }

            if (distance <= 2) {
                answer++;
            }
        }

        System.out.println(answer);

    }
}
