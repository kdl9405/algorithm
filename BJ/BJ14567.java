package BJ;

import java.io.*;
import java.util.*;

/* 
    선수과목 (Prerequisite)
    
*/

public class BJ14567 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        beforeList = new ArrayList<>();
        for(int i = 0; i<=n; i++){
            beforeList.add(new ArrayList<>());
        }

        while (m-- > 0) {
            st = new StringTokenizer(br.readLine());
            int before = Integer.parseInt(st.nextToken()); 
            int next = Integer.parseInt(st.nextToken());

            beforeList.get(next).add(before);
        }

        dp = new int[n+1];

        StringBuilder sb = new StringBuilder();
        for(int i = 1; i<=n; i++){
            sb.append(findDP(i)).append(" ");
        }

        System.out.println(sb.toString().trim());

        
    }

    static ArrayList<ArrayList<Integer>> beforeList;
    static int[] dp;

    static int findDP(int n){
        
        if (dp[n] != 0) {
            return dp[n];
        }

        ArrayList<Integer> bList = beforeList.get(n); 
        
        if (bList.isEmpty()) {
            return 1;
        }

        int max = 0;
        
        for(Integer b : bList){
            max = Math.max(max, findDP(b));
        }
        
        dp[n] = max+1;

        return dp[n];
    }
}
