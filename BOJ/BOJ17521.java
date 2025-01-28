package boj;

import java.io.*;
import java.util.*;

/*
 * Byte Coin
 */
public class BOJ17521 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int[] value = new int[input[0]];

        for (int i = 0; i < input[0]; i++) {
            value[i] = Integer.parseInt(br.readLine());
        }

        long money = input[1];
        long coin = 0;

        int day = 0;
        while (day < input[0]) {

            int now = value[day];

            while (day < input[0] && now >= value[day]) {
                now = value[day];
                day++;
            }

            coin = money / now;
            money %= now;

            while (day < input[0] && now <= value[day]) {

                now = value[day];
                day++;
            }

            money += (coin * now);
        }

        System.out.println(money);

    }

}
