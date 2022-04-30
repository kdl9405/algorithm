package BOJ;

/* 
    효율적인 해킹

*/

import java.io.*;
import java.util.*;

public class BOJ1325_copy3 {

    static int n,m;
	static ArrayList<Integer>[] adj;
	static boolean[] visited;
	static int[] visitedCnt;
	
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		adj = new ArrayList[n+1];
		for(int i=1;i<=n;i++) {
			adj[i] = new ArrayList<Integer>();
		}
		
		for(int i=0;i<m;i++) {
			st = new StringTokenizer(br.readLine());
			
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			
			adj[v].add(u);//u v 신뢰 관계 : v->u 순으로 탐색 진행
		}
		
		visitedCnt = new int[n+1];//n개의 노드마다 방문한 노드 갯수를 저장!
		for(int i=1;i<=n;i++) {

            System.out.println("시작점 : " + i);
			visited = new boolean[n+1];
			visited[i] = true;
			visitedCnt[i] = dfs(i);
		}
        
		StringBuilder sb = new StringBuilder();
        int max = 0;

        for (int i = 1; i <= n; i++) {
            if (max == visitedCnt[i]) {
                sb.append(i + " ");
            } else if (max < visitedCnt[i]) {
                max = visitedCnt[i];
                sb = new StringBuilder();
                sb.append(i + " ");
            }
        }

        System.out.println(sb.toString());
	}
	
	static int dfs(int idx) {

        System.out.println(idx);
        
        visited[idx] = true;
        int cnt = 1;
        
		for(int next:adj[idx]) {
			if(visited[next]) continue;
			cnt+=dfs(next);
		}
        
        return cnt;
	}
}


