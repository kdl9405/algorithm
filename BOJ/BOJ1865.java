package BOJ;

import java.io.*;
import java.util.*;

/* 
    웜홀 
*/

public class BOJ1865 {
    
    public static void main(String[] args) throws NumberFormatException, IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            roads = new ArrayList<>();
            for(int i = 0; i<=n; i++){
                roads.add(new ArrayList<>());
            }

            while (m-- > 0) {
                st = new StringTokenizer(br.readLine());

                int s = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());
                int t = Integer.parseInt(st.nextToken());

                roads.get(s).add(new Road(e,t));
                roads.get(e).add(new Road(s,t));
            }

            while (w--> 0) {
                st = new StringTokenizer(br.readLine());

                int s = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());
                int t = Integer.parseInt(st.nextToken());

                roads.get(s).add(new Road(e,-t));

            }
            

            if (bellmanFord(n)) {
                sb.append("YES").append("\n");
            }else{
                sb.append("NO").append("\n");
            }

        }

        System.out.println(sb.toString());

    }

    static List<ArrayList<Road>> roads;
    static int[] times;
    static int INF = 9000000;

    static boolean bellmanFord(int n){

        times = new int[n+1];
        Arrays.fill(times, INF);

        times[1] = 0;
        boolean update = false;

        for(int i = 1; i<n; i++){
            update = false;

            for(int j = 1; j<=n; j++){
                for(Road road : roads.get(j)){
                    if (times[road.to] > times[j]+road.time) {
                        times[road.to] = times[j]+road.time;
                        update = true;
                    }
                }
            }

            if (!update) {
               break;
            }
        }

        if (update) {
            for(int i = 1; i<=n; i++){
                for(Road road : roads.get(i)){
                    if (times[road.to] > times[i]+road.time) {
                        return true;
                    }
                }
            }
        }

        return false;
    }
}


class Road{
    int to;
    int time;

    public Road(int to, int time){
        this.to = to;
        this.time = time;
    }
}