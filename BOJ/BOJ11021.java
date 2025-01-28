package boj;

import java.io.*;
import java.util.*;

/**
 * InnerBOJ8394
 * 
 * 
 */
public class BOJ11021 {

    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        int result[] = new int[T];

        int a = 0, b = 0;

        for (int i = 0; i < T; i++) {

            a = sc.nextInt();
            b = sc.nextInt();

            result[i] = a + b;

        }

        sc.close();

        for (int j = 0; j < T; j++) {

            System.out.println("Case #" + (j + 1) + ": " + result[j]);
        }


    }
}
