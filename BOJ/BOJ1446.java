package BOJ;

import java.io.*;
import java.util.*;

/* 
    지름길

    bottom-up 
*/
public class BOJ1446 {

    static int[] dist; // 위치가 n일 때의 최소 이동거리 
    static HashMap<Integer, List<int[]>> shortCut; // key : 도착지점, value : (출발지점,이동거리)리스트 형식의 지름길 정보

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

        dist = new int[D+1]; // dist 초기화

        for(int i = 1; i<=D; i++){  // 위치 1부터 시작하여 D위치까지 최소 이동거리를 채움
            int d = dist[i-1]+1; // 기본값 : (현재 위치-1)에서의 최소 이동거리 + 1

            if (shortCut.containsKey(i)) {
                for(int[] root : shortCut.get(i)){
                    // 도착위치가 i인 지름길을 조회해서 최소 이동거리 갱신
                    d = Math.min(d, dist[root[0]]+root[1]);
                }
            }

            dist[i] = d;            
        }

        System.out.println(dist[D]);
    }
}
