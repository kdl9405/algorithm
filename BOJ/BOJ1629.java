package BOJ;


import java.util.*;
import java.io.*;

public class BOJ1629 {
    
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());
        long C = Long.parseLong(st.nextToken());

        System.out.println(mod(A, B, C));
    }

    static long mod(long a, long b, long c){

        if (b == 0) {
            return 1;
        }else if (b == 1) {
            return a%c;
        }else {

            long num = mod(a, b/2, c);

            if (b % 2 == 0) {
                return (num * num)%c;  
            }else{
                return ((num * num) %c * (a%c))%c;  
            }
        }
        
    }
}
