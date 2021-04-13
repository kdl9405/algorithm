package BOJ;

import java.util.Scanner;

/* 
    최대공약수와 최소공배수
*/

public class BOJ2609 {
    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int b = sc.nextInt();

        if (b>a) {
            int temp = a;
            a = b;
            b = temp;
        }

        int lcd = LCD(a, b);
        int gcb = (a*b)/lcd;


        System.out.println(lcd);
        System.out.println(gcb);

        
    }

    static int LCD(int a, int b){
        while (b!= 0) {
            int n = a%b;
            a = b;
            b = n;
        }
        return a;
    }


}
