package BJ;

import java.util.Scanner;

public class BJ2446 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        sc.close();

        String zero = " ";
        String star = "*";

        // for(int i=0; i<N; i++){
        // System.out.println(zero.repeat(i)+star.repeat(2*(N-i)-1)+zero.repeat(i));
        // }

        // for(int i=N-2; i>=0; i--){
        // System.out.println(zero.repeat(i)+star.repeat(2*(N-i)-1)+zero.repeat(i));
        // }

        for(int i=0; i<N; i++){
         
            for(int j=0; j<i; j++){
                System.out.print(" "); 
            }
            for(int j=0; j<(2*(N-i)-1); j++){
                System.out.print("*"); 
            }

            System.out.println();
         }

         for(int i=1; i<N; i++){
         
            for(int j=i; j<N-1; j++){
                System.out.print(" "); 
            }
            for(int j=0; j<(2*i)+1; j++){
                System.out.print("*"); 
            }

            System.out.println();
         }

    }
}