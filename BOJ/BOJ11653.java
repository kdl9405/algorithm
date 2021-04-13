package BOJ;

import java.util.Scanner;

public class BOJ11653 {
    

    public static void main(String[] args) {
         
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        if (n<2) {
            System.out.println("");
        }else{
            findPrime(n);

            while (n>1) {
                for(int i = 2; i<=n; i++){
                    if (primeN[i] && (n%i==0)) {
                        n/=i;
                        System.out.println(i);
                        break;
                    }
                }
            }
        }

    }

    static boolean[] primeN;

    static void findPrime(int n){

        primeN = new boolean[n+1];

        for(int i = 2; i<=n; i++){
            if (primeN[i]) {
                continue;
            }

            for(int j = 1; j*i<=n; j++){
                primeN[i*j] = true;
            }
        }
        
    }


}
