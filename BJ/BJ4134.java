package BJ;

import java.math.BigInteger;
import java.util.Scanner;

/* 
    다음 소수
*/
public class BJ4134 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        StringBuffer sb = new StringBuffer();

        int t = Integer.parseInt(sc.nextLine());

        while (t-- > 0) {
            // int n = Integer.parseInt(sc.nextLine());

            BigInteger n = new BigInteger(sc.nextLine());
            if (n.isProbablePrime(100)) {
                sb.append(n).append("\n");
            } else {
                sb.append(n.nextProbablePrime()).append("\n");
            }
        }

        System.out.println(sb.toString().trim());
    }
}
