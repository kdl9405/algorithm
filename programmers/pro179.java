package programmers;

import java.io.*;
import java.util.*;

/* 
    문자열 지옥에 빠진 호석

*/
public class pro179 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        map = new char[N][M];
        hashMap = new HashMap<>();

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = line.charAt(j);
                if (!hashMap.containsKey(map[i][j]+"")) {
                    hashMap.put(map[i][j]+"", new ArrayList<>());
                }
                hashMap.get(map[i][j]+"").add(new int[] { i, j });
            }
        }

        StringBuilder sb = new StringBuilder();
        while (K-- > 0) {
            String S = br.readLine();
            if (!hashMap.containsKey(S)) {
                findCase(S);
            }
            int count = hashMap.get(S).size();
            sb.append(count).append("\n");
        }

        System.out.println(sb.toString().trim());     

    }

    static int N, M;
    static char[][] map;
    static HashMap<String, List<int[]>> hashMap;
    static int[][] d = { { -1, -1 }, { -1, 0 }, { -1, 1 }, { 0, -1 }, { 0, 1 }, { 1, -1 }, { 1, 0 }, { 1, 1 } };

    static List<int[]> findCase(String S){
        
        List<int[]> temp = new ArrayList<>();


        if (hashMap.containsKey(S)) {
            return hashMap.get(S);
        }else if(S.length() <= 1){
            hashMap.put(S, temp);
            return temp;            
        }       

        String subS = S.substring(0, S.length()-1);

        List<int[]> list = findCase(subS);

        if(list.isEmpty()){
            hashMap.put(S, temp);
            return temp;
        }

        char c = S.charAt(S.length()-1);

        for(int [] now : list){
            for(int i = 0; i<8; i++){
                int nx = now[0]+d[i][0];
                int ny = now[1]+d[i][1];

                if (nx == -1) {
                    nx = N-1;
                }else if(nx == N){
                    nx = 0;
                }

                if (ny == -1) {
                    ny = M-1;
                }else if(ny == M){
                    ny = 0;
                }

                if (map[nx][ny] == c) {
                    temp.add(new int[]{nx,ny});
                }
            }
        }

        hashMap.put(S, temp);

        return temp;
    }
}
