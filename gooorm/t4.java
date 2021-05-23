package gooorm;

import java.io.*;
import java.util.*;

public class t4 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        road = new boolean[2][n + 1][n + 1]; // 0:정방향 1 : 역방향 

        node = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            node.add(new ArrayList<>());
        }

        while (m-- > 0) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            node.get(a).add(b);
            node.get(b).add(a);

            road[0][a][b] = true;
            road[1][b][a] = true;
        }

        index = 0;
        max = 0;

        for(int i = 1; i<=n; i++){
            BFS(i);
        }

        System.out.println(index+" "+max);


    }

    static int n,index;
    static int max;
    static boolean[][][] road; 
    static List<List<Integer>> node;

    static void BFS(int x){

        int count = 1;
        int[] visit = new int[n+1];
        visit[x] = 1;

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x,0});

        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            
            for(Integer next : node.get(now[0])){
                if (road[now[1]][now[0]][next]) {
                    if (visit[next] > node.get(next).size()) {
                        continue;
                    }
                    if (visit[next] == 0) {
                        count++;                        
                    }
                    visit[next]++;
                    queue.add(new int[]{next,(now[1]+1)%2});
                }
            }
        }

        if (count>max) {
            max = count;
            index = x;
        }

    }
}
