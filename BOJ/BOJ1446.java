import java.io.*;
import java.util.*;

/* 
    지름길

    bottom-up 
*/
public class BOJ1446 {

    static int[] dist;
    static HashMap<Integer, List<int[]>> shortCut;


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());

        shortCut = new HashMap<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int distance = Integer.parseInt(st.nextToken());

            if (!shortCut.containsKey(to)) {
                shortCut.put(to, new ArrayList<>());
            }
            shortCut.get(to).add(new int[]{from,distance});
        }

        dist = new int[D+1];

        for(int i = 1; i<=D; i++){
            int d = dist[i-1]+1;

            if (shortCut.containsKey(i)) {
                for(int[] root : shortCut.get(i)){
                   
                    d = Math.min(d, dist[root[0]]+root[1]);
                }
            }

            dist[i] = d;            
        }

        System.out.println(dist[D]);

    }
}
