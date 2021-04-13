import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ15655 {

    static int n, m;
    static int[] number, arr;
    static boolean[] visit;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        number = new int[n];
        visit = new boolean[n];
        arr = new int[m];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i<n; i++){
            number[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(number);

        dfs(1, 0);

        System.out.println(sb);
    }

    public static void dfs(int x, int depth){

        if(depth == m){

            for(int val : arr){
                sb.append(val +" ");
            }
            sb.append("\n");
        }

        for(int i=0; i<n; i++){

            if(!visit[i]){
                visit[i] = true;
                arr[depth] = number[i];
                dfs(i+x, depth + 1);
                visit[i] = false;
            }
        }
    }
}