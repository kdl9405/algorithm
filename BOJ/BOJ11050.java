package BOJ;

import java.io.IOException;
import java.util.Scanner;

/* 
    이항계수
*/
public class BOJ11050 {

    public static void main(String[] args) throws IOException {
        
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();

        System.out.println(nCr(N, K));

    }

    static int nCr (int N, int K){
        if (K == 1) {
            return N;
        }  
        if (N == 1 || N == K || K == 0) {
            return 1;
        }

        return nCr(N-1, K-1) + nCr(N-1, K);
    } 
}
