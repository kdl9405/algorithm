package BOJ;

import java.util.Scanner;

/* 
    진법 변환
*/
public class BOJ2745 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String num = sc.next();
        int b = sc.nextInt();

        int result = 0;
        int x = 1;
        for(int i = num.length()-1; i>=0; i--){
            char c = num.charAt(i);

            int n = 0;
            if (c >= 'A' && c <= 'Z') {
                n = c-'A'+10;
            }else{
                n = Integer.parseInt(Character.toString(c));
            } 

            result += (n*x);
            x*=b;
        }

        System.out.println(result);
    }
}
