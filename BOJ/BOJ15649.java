package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * BOJ15649
 */
public class BOJ15649 {

    static boolean[] visit;
    static int[] arr;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        arr = new int[m];
        visit = new boolean[n];

        dfs(n, m, 0);

        System.out.println(sb);
        
    }

    public static void dfs(int n, int m, int depth){

        if(depth == m){
            for(int val : arr){
                sb.append(val+" ");
            }
            sb.append("\n");
            return;
        }

        for(int i=0; i<n; i++){
            if(!visit[i]){
                visit[i] = true;
                arr[depth] = i+1;
                dfs(n, m, depth+1);
                visit[i] = false;
            }
        }
    }
}