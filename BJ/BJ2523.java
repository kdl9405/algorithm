package BJ;

import java.util.Scanner;

public class BJ2523 {
    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        sc.close();
        
        String star = "*";

        for(int i=0; i<N; i++){
           
            System.out.println(star);

            star = star+"*";
        }

        for(int i = N-1; i>0; i--){

            System.out.println(star.substring(0, i));

        }
    }
}