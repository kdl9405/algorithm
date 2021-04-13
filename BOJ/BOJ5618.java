package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/* 
    공약수
*/
public class BOJ5618 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        int num = Integer.parseInt(st.nextToken());

        while (n--> 1) {
            num = gcd(num, Integer.parseInt(st.nextToken()));
        }

        for(int i = 1; i<=num; i++){
            if (num % i == 0) {
                System.out.println(i);
            }
        }
        
    }

    static int gcd(int a, int b){
        if (a < b) {
            int temp = a;
            a = b;
            b = temp;
        }

        while (b != 0) {
            int n = a%b;
            a = b;
            b = n;
        }

        return a;
    }
}
