package boj;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * BOJ11399
 */
public class BOJ11399 {

    public static void main(String[] args) throws NumberFormatException, IOException {


        
        int n = Integer.parseInt(b

        
        StringTokenizer st = new StringTokenizer(br.readLine());
    
        for(int i = 0; i<n; i++){
            person[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(person);

        int time = 0;
    
        for(int i = 0; i<n; i++){  
            time += person[i] * (n-i);
        }

        System.out.println(time);

 
   }
}