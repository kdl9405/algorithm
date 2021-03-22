package BOJ;

import java.io.*;
import java.util.*;

/* 
    카카오머니 
*/
public class BOJ15988 {
    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        long budget = 0;
        long m = 0;

        long min = Long.MAX_VALUE;
        boolean impossible = false;

        StringTokenizer st;
        while (n-- > 0) {

            st = new StringTokenizer(br.readLine());

            long a = Long.parseLong(st.nextToken());
            long b = Long.parseLong(st.nextToken());

            if (budget + a >= 0) {
                budget += a;
                
            } else {

                long charge = (b-a)-budget;  // 충전금액 계산

                if (b != 0 && b < min) {
                    min = b;
                }

                if (m == 0) {
                    m = charge;    // m의 초기값은 첫 충전금액
                }else{
                    m = GCD(m, charge);   // m은 다음 충전금액과의 GCD
                }                

                if (m <= min) {
                    impossible = true;
                }
               
                budget = (budget+charge)+a;
              
            }  
            
            if (budget != b) {
                impossible = true;
            }
        }

        if (impossible) {
            m = -1;
        }else if(m == 0){
            m = 1;
        }

        System.out.println(m);

    }

    static long GCD(long a, long b) {

        if (a < b) {
            long temp = a;
            a = b;
            b = temp;
        }

        while (b != 0) {
            long n = a % b;
            a = b;
            b = n;
        }

        return a;
    }
}
