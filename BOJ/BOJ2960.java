package BOJ;

import java.util.Scanner;

/*
    에라토스테네스의 체
*/

public class BOJ2960 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        boolean[] arr = new boolean[n+1];

        loop:
        for(int i = 2; i<=n; i++){
            for(int j = 1; j*i<=n; j++){
                if (!arr[i*j]) {
                    arr[i*j] = true;
                    k--;
                    if (k == 0) {
                        System.out.println(i*j);
                        break loop;
                    }
                }
            }
        }
    }  
}
