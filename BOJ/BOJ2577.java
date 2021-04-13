package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * BOJ2577
 * 
 *
 */
class BOJ22577 {

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] count;
        count = new int[10];
                
        int A = Integer.parseInt(br.readLine());
        int B = Integer.parseInt(br.readLine());
        int C = Integer.parseInt(br.readLine());

      //  int N = A*B*C;
        String N = Integer.toString(A*B*C);
        String[] number = N.split("");

        for(int i = 0; i< number.length; i++){

          

            int temp = Integer.parseInt(number[i]);

            count[temp] += 1;
            

        }

        for(int j = 0; j < 10; j++){

            System.out.println(count[j]);
        }

        
    }

    
}