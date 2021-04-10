import java.io.*;
import java.util.*;

/* 
    지름길

    Top-Down
*/
public class BOJ1446_copy {

    static int[] dp;
    static HashMap<Integer, List<int[]>> shortCut;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());

        shortCut = new HashMap<>();

        while (N-- > 0) {
            st = new StringTokenizer(br.readLine());

            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int dist = Integer.parseInt(st.nextToken());

            if(!shortCut.containsKey(to)){
                shortCut.put(to, new ArrayList<>());
            }
            shortCut.get(to).add(new int[]{from,dist});

        }

        dp = new int[D+1];

        System.out.println(findDP(D));
        
    }

    static int findDP(int n){

        if (n == 0) {
            return 0;
        }

        if (dp[n] != 0) {
            return dp[n];
        }

        int temp = findDP(n-1) + 1;

        if (shortCut.containsKey(n)) {
            for(int[] root : shortCut.get(n)){
                temp = Math.min(temp, findDP(root[0])+root[1]);
            }
        }

        dp[n] = temp;

        return dp[n];
    }

    
}
