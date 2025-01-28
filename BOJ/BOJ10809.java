package boj;

import java.util.Scanner;

public class BOJ10809 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String s = sc.nextLine();

        sc.close();

        int[] alphabet = new int[26];

        for (int i = 0; i < s.length(); i++) {

            if (alphabet[s.charAt(i) - 97] == 0) {
                alphabet[s.charAt(i) - 97] = i + 1;
            }
        }

        for (int i = 0; i < 26; i++) {
            System.out.print(alphabet[i] - 1 + " ");
        }


    }
}
