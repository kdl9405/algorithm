package BOJ;

import java.math.*;
import java.util.*;

/* 
    엄청난 부자2

*/
public class BOJ1271 {
    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        BigInteger n = sc.nextBigInteger();
        BigInteger m = sc.nextBigInteger();

        System.out.println(n.divide(m));
        System.out.println(n.remainder(m));
    }
}
