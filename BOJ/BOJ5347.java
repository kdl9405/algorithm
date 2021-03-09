package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* 
    LCM
*/
public class BJ5347 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        
        BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuffer sb = new StringBuffer();
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            sb.append(lcm(a, b)).append("\n");
        }
        System.out.println(sb.toString().trim());
    }

    static long gcd(int num1, int num2){
        
        long a = num1;
        long b = num2;

        if (a < b) {
            long temp = a;
            a = b;
            b = temp;
        }

        while (b != 0) {
            long n = a%b;
            a = b;
            b = n;
        }

        return a;
    }

    static long lcm (int a, int b){
        long d = gcd(a, b);
        long n = (long)a*(long)b;
        return n/d;
    }
}
