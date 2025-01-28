package boj;

import java.io.*;
import java.util.*;

/*
 * 일곱 난쟁이
 */
public class BOJ2309 {

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] hobits = new int[9];
        int sum = 0;
        for (int i = 0; i < 9; i++) {
            hobits[i] = Integer.parseInt(br.readLine());
            sum += hobits[i];
        }

        Arrays.sort(hobits);

        StringBuilder sb = new StringBuilder();

        loop: for (int i = 0; i < 8; i++) {
            for (int j = i + 1; j < 9; j++) {
                if (sum - hobits[i] - hobits[j] == 100) {

                    for (int x = 0; x < 9; x++) {
                        if (x != i && x != j) {
                            sb.append(hobits[x] + "\n");
                        }
                    }
                    break loop;
                }
            }
        }

        System.out.println(sb.toString().trim());
    }

}
