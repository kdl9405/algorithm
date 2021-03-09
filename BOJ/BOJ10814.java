import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class BJ10814 {

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        String[][] arr = new String[n][2];

        for (int i = 0; i < n; i++) {

            st = new StringTokenizer(br.readLine());

            arr[i][0] = st.nextToken(); 
            arr[i][1] = st.nextToken();
        }

        Arrays.sort(arr, new Comparator<String[]>(){
            
            public int compare (String[] s1, String[] s2 ){
                return Integer.parseInt(s1[0]) - Integer.parseInt(s2[0]);
            }
        });

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i<n; i++){
            sb.append(arr[i][0] + " " + arr[i][1] +"\n");
        }

        System.out.println(sb);
    }
}