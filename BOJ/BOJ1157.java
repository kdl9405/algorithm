package BJ;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * BJ1157
 */
public class BJ1157 {
    public static void main(final String[] args) throws IOException {
        // A-a = 32 , A = 65, Z=90

        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final String[] str = br.readLine().split("");

        int[] count;
        count = new int[27];
        int max = 0;

        char result='?';

        for (int i = 0; i < str.length; i++) {

            int n = str[i].charAt(0);

            if (n > 90) {
                n = n - 32;
            }

            count[n - 64] += 1;          

        }

        for (int j = 1; j <= 26; j++) {

            if (max < count[j]) {
                max = count[j];
                result = (char)(j+64);
            }
            else if( max == count[j]){
                result = '?';
            }

        }

        System.out.println(result);

      
    }

}