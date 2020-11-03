package BJ;



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class BJ1920 {
    
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        HashSet<String> set = new HashSet<>();

        while (n-- >0) {
            set.add(st.nextToken());
        }

        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
           
        while (m-- >0) {
            if (set.contains(st.nextToken())) {
                sb.append(1+"\n");
            }else{
                sb.append(0+"\n");
            }
        }

        System.out.println(sb);
 
    }
}
