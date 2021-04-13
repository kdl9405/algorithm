import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ6603 {

    static int k;
    static int[] s, arr; 
    static boolean[] visit;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        arr = new int[6];

        while (true) {
            st = new StringTokenizer(br.readLine());

            k = Integer.parseInt(st.nextToken());

            if (k == 0) {
                break;
            }

            s = new int[k];
            visit = new boolean[k];

            for (int i = 0; i < k; i++) {
                s[i] = Integer.parseInt(st.nextToken());
            }

            dfs(0,0);

            sb.append("\n");

        }
        System.out.println(sb);

    }

    public static void dfs(int x, int depth){

        if(depth == 6){
            for(int val : arr){
                sb.append(val+" ");
            }
            sb.append("\n");
            return;
        }

        for(int i = x; i<k; i++){

            if(!visit[i]){
                visit[i] = true;
                arr[depth] = s[i];
                dfs(i + 1, depth + 1);
                visit[i] = false;
            }
        }
    }
}