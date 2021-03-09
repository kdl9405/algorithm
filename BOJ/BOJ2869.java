import java.io.*;
import java.util.*;

public class BJ2869 {

    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());
        

        int d = (V - A) / (A - B) + 1;

        if((V - A) % (A - B) != 0){
            d++;
        }
        

        System.out.println(d);

        
    }
}