package BJ;

import java.util.Scanner;

public class BJ1929 {
    

    public static boolean primeN[];
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        int m = sc.nextInt();
        int n = sc.nextInt();

        sc.close();

        primeN = new boolean[n+1];

        check_prime();

        for(int i = m; i<=n; i++){
            if(primeN[i] == false){
                System.out.println(i);
            }
        }


    }

    public static void check_prime(){
        primeN[0] = true;
        primeN[1] = true;

        for(int i = 2; i<=Math.sqrt(primeN.length); i++){

            if(primeN[i]){
                continue;
            }

            for(int j = i*i; j<primeN.length; j+=i){
                primeN[j] = true;
            }
            
        }
    }
}