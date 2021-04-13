package BOJ;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * BOJ1011
 */
public class BOJ1011 {

    static StringTokenizer st;
    public static void main(String[] args) throws NumberFormatException, IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());
        
        while (t--> 0){

            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int m = 0;
            int count =0;

            while(true) {
                m++;
                
                x += m;
                count++;                 
                if(x >= y) {
                    break;
                }
                
                y -= m;
                count++;  
                if(y <= x) {
                    break;
                }
                
            }

            
            bw.write(String.valueOf(count));
            bw.newLine();
        }
        bw.flush();
    }
    
}