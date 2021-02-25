package BJ;

import java.io.*;
import java.util.*;

/* 
    최소공배수
*/
public class BJ1934 {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuffer sb = new StringBuffer();
    
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            sb.append(lcd(a, b)).append("\n");
        }    

        System.out.println(sb.toString().trim());
    }    

    static int gcd (int a, int b){
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

    static int lcd(int a, int b){
        int d = gcd(a, b);

        return (a*b)/d;
    }
}
