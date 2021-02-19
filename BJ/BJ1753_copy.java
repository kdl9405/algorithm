package BJ;

import java.io.*;
import java.util.*;

/* 
    최단경로 

    다익스트라 순서...
    
*/

public class BJ1753_copy {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());

        int start = Integer.parseInt(br.readLine());

        List<ArrayList<cost>> road = new ArrayList<>();
        for (int i = 0; i <= v; i++) {
            road.add(new ArrayList<cost>());
        }

        while (e-- > 0) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            // road.get(from).add(to);
            road.get(from).add(new cost(from, to, weight));
        }

        int[] route = new int[v + 1];
        Arrays.fill(route, 1000000);
        route[start] = 0;

        for (cost cost : road.get(start)) {
            route[cost.to] = cost.weight;
        }

        boolean[] visit = new boolean[v + 1];
        visit[start] = true;

        for (int i = 0; i < v - 1; i++) {
            int min = 1000000;
            int from = 0;
            for (int j = 1; j <= v; j++) {
                if (!visit[j] && route[j] < min) {
                    from = j;
                    min = route[j];
                }
            }

            visit[from] = true;

            for(cost cost : road.get(from)){
                if (!visit[cost.to]) {
                    if (route[cost.to] > min+cost.weight) {
                        route[cost.to] = min+cost.weight;
                    }
                }
            }
        
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= v; i++) {
            if (route[i] == 1000000) {
                sb.append("INF").append("\n");
            } else {
                sb.append(route[i]).append("\n");
            }
        }

        System.out.println(sb.toString());
    }
}

class cost {
    int from;
    int to;
    int weight;

    public cost(int from, int to, int weight) {
        this.from = from;
        this.to = to;
        this.weight = weight;
    }
}
