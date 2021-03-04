package BJ;

import java.io.*;
import java.util.*;


/* 
    ACM Craft
*/
public class BJ1005 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            times = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            
            dp = new int[n+1]; // i번 건물을 완성하는 시간
            Arrays.fill(dp, -1);
            before = new HashMap<>();

            while (k-- > 0) {
                st = new StringTokenizer(br.readLine());

                int b = Integer.parseInt(st.nextToken());
                int build = Integer.parseInt(st.nextToken());

                ArrayList<Integer> bList = new ArrayList<>();
                if (before.containsKey(build)) {
                    bList = before.get(build);
                }
                bList.add(b);
                before.put(build, bList);

            }

            int w = Integer.parseInt(br.readLine());

            sb.append(findDP(w)).append("\n");

        }

        System.out.println(sb.toString().trim());

    }

    static int[] times;
    static int[] dp;
    static HashMap<Integer, ArrayList<Integer>> before;

    static int findDP(int n){
        if (dp[n] != -1) {
            return dp[n];
        }

        if (!before.containsKey(n)) {
            return times[n-1];
        }

        for(Integer e : before.get(n)){
            dp[n] = Math.max(dp[n], findDP(e));
        }

        dp[n] += times[n-1];
        return dp[n];
    }
}
