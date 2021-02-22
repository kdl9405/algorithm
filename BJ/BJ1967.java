package BJ;

import java.io.*;
import java.util.*;

/* 
    트리의 지름
*/

public class BJ1967 {
    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        child = new ArrayList<ArrayList<Node>>();

        for(int i = 0; i<=n; i++){
            child.add(new ArrayList<>());
        }

        for(int i=1; i<n; i++){
            st = new StringTokenizer(br.readLine());

            int p = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            child.get(p).add(new Node(c,d));
        }

        dp = new int[n+1];
        
        int max = 0;
        for(int i = 1; i<=n; i++){
            if (child.get(i).isEmpty()) {
                continue;
            }
            Integer[] arr = new Integer[child.get(i).size()];
            int j = 0;
            for(Node node : child.get(i)){
                arr[j] = (findDP(node.num)+node.toParent);
                j++;
            }
            Arrays.sort(arr, Collections.reverseOrder());
            int sum = arr[0];
            if (arr.length>1) {
                sum+=arr[1];
            }

            max = Math.max(sum, max);
        }

        System.out.println(max);      
        
     
    }

    static int[] dp;
    static ArrayList<ArrayList<Node>> child;

    static int findDP(int n){

        if (dp[n] != 0) {
            return dp[n];
        }

        if (child.get(n).isEmpty()) {
            return 0;
        }

        for(Node c : child.get(n)){
            dp[n] = Math.max(dp[n], findDP(c.num)+c.toParent);
        }
        return dp[n];
    }

   
}

class Node {
    int num;
    int toParent;    

    public Node(int num, int toParent) {
        this.num = num;
        this.toParent = toParent;
    }
}