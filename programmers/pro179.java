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

        map = new char[N + 1][M + 1];
        hashMap = new HashMap<>();

        for (int i = 1; i <= N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j + 1] = line.charAt(j);
                if (!hashMap.containsKey(map[i][j + 1])) {
                    hashMap.put(map[i][j + 1], new ArrayList<>());
                }
                hashMap.get(map[i][j + 1]).add(new int[] { i, j + 1 });
            }
        }

        StringBuilder sb = new StringBuilder();
        dp = new int[26][26];
        while (K-- > 0) {
            sb.append(findCase(br.readLine())).append("\n");
        }

        System.out.println(sb.toString().trim());

    }

    static int N, M;
    static char[][] map;
    static HashMap<Character, List<int[]>> hashMap;
    static int[][] d = { { -1, -1 }, { -1, 0 }, { -1, 1 }, { 0, -1 }, { 0, 1 }, { 1, -1 }, { 1, 0 }, { 1, 1 } };
    static int[][] dp;

    static int findCase(String S){
        
        if (S.length() == 1) {
            if (!hashMap.containsKey(S.charAt(0))) {
                return 0;
            }else
            return hashMap.get(S.charAt(0)).size();
        }

        int count = 1;

        for(int i = 0; i<S.length()-1; i++){
            count *= AtoB(S.charAt(i), S.charAt(i+1));
        }

        return count;
    }

    static int AtoB(char A, char B) {

        if (!hashMap.containsKey(A)) {
            return 0;
        }

        if(dp[A-'a'][B-'a'] != 0){
            return dp[A-'a'][B-'a'];
        }

        Queue<int[]> queue = new LinkedList<>();
        for (int[] point : hashMap.get(A)) {
            queue.add(point);
        }

        Queue<int[]> temp = new LinkedList<>();

        while (!queue.isEmpty()) {
            int[] now = queue.poll();

            for (int j = 0; j < 8; j++) {
                int nx = now[0] + d[j][0];
                int ny = now[1] + d[j][1];

                if (nx == 0) {
                    nx = N;
                } else if (nx > N) {
                    nx = 1;
                }

                if (ny == 0) {
                    ny = M;
                } else if (ny > M) {
                    ny = 1;
                }

                if (B == map[nx][ny]) {
                    temp.add(new int[] { nx, ny });
                }

            }
        }

        if (temp.isEmpty()) {
            return 0;
        }

        queue.addAll(temp);

        return dp[A-'a'][B-'a'] = queue.size();
    }
}
