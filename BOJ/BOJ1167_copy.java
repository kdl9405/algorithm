package BOJ;

import java.io.*;
import java.util.*;

/* 
    트리의 지름

    시간초과
*/
public class BOJ1167 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int V = Integer.parseInt(br.readLine());
        
        nodes = new ArrayList<>();
        for(int i = 0; i<=V; i++){
            nodes.add(new ArrayList<>());
        }
        

        for(int i = 0; i<V; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());

            while (true) {
                int y = Integer.parseInt(st.nextToken());

                if (y == -1) {
                    break;
                }
                int d = Integer.parseInt(st.nextToken());

                nodes.get(x).add(new Node(y,d));
            }           
        }


        dp = new int[V+1];
        visit = new boolean[V+1];
        int max = 0;
       
        for(int i = 1; i<=V; i++){
            dp = new int[V+1];
            max = Math.max(max, findDP(i));
        }

        System.out.println(max);
            
    }

    static ArrayList<ArrayList<Node>> nodes;
    static int[] dp;
    static boolean[] visit;

    static int findDP(int n){   

        if (dp[n] != 0) {
            return dp[n];
        }

        if (nodes.get(n).isEmpty()) {
            return 0;
        }

        visit[n] = true;
        for(Node child : nodes.get(n)){
            if (!visit[child.num]) {
                visit[child.num] = true;
                dp[n] = Math.max(dp[n], findDP(child.num)+child.toParent);
                visit[child.num] = false;
            }
        }
        visit[n] = false;

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
