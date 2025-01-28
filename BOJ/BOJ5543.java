package boj;

import java.io.*;

public class BOJ5543 {

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] burger = new int[3];
        int[] drink = new int[2];

        int minBurger = 2000;
        int minDrink = 2000;

        for (int i = 0; i < 3; i++) {
            burger[i] = Integer.parseInt(br.readLine());

            if (minBurger >= burger[i]) {
                minBurger = burger[i];
            }
        }

        for (int i = 0; i < 2; i++) {
            drink[i] = Integer.parseInt(br.readLine());

            if (minDrink >= drink[i]) {
                minDrink = drink[i];
            }
        }

        System.out.println(minBurger + minDrink - 50);
    }

}
