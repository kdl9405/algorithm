package boj;

import java.math.BigInteger;
import java.util.Scanner;

/*
 * 큰 수 A+B
 */

public class BOJ10757 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        BigInteger a = sc.nextBigInteger();
        BigInteger b = sc.nextBigInteger();

        BigInteger c = a.add(b);

        System.out.println(c);

    }

}
