import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ10814_copy {

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        StringBuilder[] sb = new StringBuilder[201];

        for(int i=0; i<sb.length; i++){
            sb[i] = new StringBuilder();
        }
        
        for (int i = 0; i < n; i++) {

            st = new StringTokenizer(br.readLine()," ");

            int age = Integer.parseInt(st.nextToken());
            String name = st.nextToken();

            sb[age].append(age+" "+name+"\n");
            
        }

        StringBuilder result = new StringBuilder();
        for(int i=0; i<sb.length; i++){
            
            if(sb[i].length() != 0){
                result.append(sb[i]);
            }
        }

        System.out.println(result);
    }
}