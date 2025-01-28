package boj;

/*
 * 카드
 */

import java.io.*;
import java.util.*;

public class BOJ11652_copy {

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        HashMap<Long, Integer> cards = new HashMap<>();

        for (int i = 0; i < N; i++) {
            long card = Long.parseLong(br.readLine());

            cards.put(card, cards.getOrDefault(card, 0) + 1);
        }

        int max = 0;
        long x = 0;
        for (long card : cards.keySet()) {
            if (max < cards.get(card)) {
                max = cards.get(card);
                x = card;
            } else if (max == cards.get(card)) {
                x = Math.min(x, card);
            }
        }

        System.out.println(x);

    }
}
