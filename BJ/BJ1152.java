package BJ;

import java.util.Scanner;

public class BJ1152 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String s = sc.nextLine().trim();

        sc.close();

        if (s.isEmpty()) {
            System.out.println(0);
        } else {

            String[] str = s.split(" ");

            System.out.println(str.length);
        }
    }
}