import java.util.*;
import java.io.*;

public class BJ10816 {
    
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        HashMap<String,Integer> map = new HashMap<>();
        while (n-- >0) {
            String s = st.nextToken();
            map.put(s, map.getOrDefault(s, 0) +1);
        }

        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        StringBuilder sb = new StringBuilder();

        while (m-- >0) {
            String s = st.nextToken();
            if (map.containsKey(s)) {
                sb.append(map.get(s)+" ");
            }else{
                sb.append(0+" ");
            }
        }

        System.out.println(sb);

    }
}
