package BOJ;

import java.io.*;
import java.util.*;

/* 
    지름길

    Top-Down
*/
public class BOJ1446_copy {

    static int[] dp; // 위치가 n일 때의 최소 이동거리
    static HashMap<Integer, List<int[]>> shortCut; // key : 도착지점, value : (출발지점,이동거리)리스트 형식의 지름길 정보

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());

        shortCut = new HashMap<>();

        while (N-- > 0) { // 지름길 정보를 shortCut에 저장
            st = new StringTokenizer(br.readLine());

            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int dist = Integer.parseInt(st.nextToken());

            if(!shortCut.containsKey(to)){
                shortCut.put(to, new ArrayList<>());
            }
            shortCut.get(to).add(new int[]{from,dist}); // 지름길의 도착 위치를 Key값으로 지정

        }

        dp = new int[D+1]; // dp 초기화

        System.out.println(findDP(D)); 
        
    }

    static int findDP(int n){

        if (n == 0) { // 위치지점이 0
            return 0;
        }

        if (dp[n] != 0) { // 이미 계산된 최소거리
            return dp[n];
        }

        int temp = findDP(n-1) + 1; // 기본값은 현재위치-1에서의 최소거리 + 1

        if (shortCut.containsKey(n)) {
            for(int[] root : shortCut.get(n)){
                temp = Math.min(temp, findDP(root[0])+root[1]);
            } 
            // 도착지점이 n인 지름길을 이용했을 경우를 조사하여, 최소값 갱신
        }

        dp[n] = temp;

        return dp[n];
    }

    
}
