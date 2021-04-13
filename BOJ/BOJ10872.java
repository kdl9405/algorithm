package BOJ;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ10872 {

    public static void main(String[] args) throws NumberFormatException, IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        
        int result = facN(n);
        System.out.println(result);
    }

    public static int facN(int n){
        if ( n <= 1){
            return 1;
        }
        return n* facN(n-1);
    }
}