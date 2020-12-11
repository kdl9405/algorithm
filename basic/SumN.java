package basic;

import java.util.*;

public class SumN {
    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        System.out.println(sumN(n));

    }

    static int sumN (int n) {
        int sum = 0;

        while (n>0) {
            sum += (n%10);
            n /= 10;
        }

        return sum;
    }
}
