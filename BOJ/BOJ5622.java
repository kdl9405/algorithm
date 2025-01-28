package boj;

import java.util.*;

public class BOJ5622 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String str = sc.nextLine();

        sc.close();

        int sum = 0;

        for (int i = 0; i < str.length(); i++) {

            switch (str.charAt(i)) {
                case 'A':
                case 'B':
                case 'C':
                    sum = sum + 3;
                    break;

                case 'D':
                case 'E':
                case 'F':
                    sum = sum + 4;
                    break;

                case 'G':
                case 'H':
                case 'I':
                    sum = sum + 5;
                    break;

                case 'J':
                case 'K':
                case 'L':
                    sum = sum + 6;
                    break;

                case 'M':
                case 'N':
                case 'O':
                    sum = sum + 7;
                    break;

                case 'P':
                case 'Q':
                case 'R':
                case 'S':
                    sum = sum + 8;
                    break;

                case 'T':
                case 'U':
                case 'V':
                    sum = sum + 9;
                    break;

                case 'W':
                case 'X':
                case 'Y':
                case 'Z':
                    sum = sum + 10;
                    break;
            }
        }

        System.out.println(sum);
    }
}
