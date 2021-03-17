package programmers;

import java.io.*;
import java.util.*;

/* 
    문자열 지옥에 빠진 호석

    시간초과
*/
public class pro179_copy2 {
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
        start = new HashMap<>();
        while (K-- > 0) {
            sb.append(findCase(br.readLine())).append("\n");
        }

        System.out.println(sb.toString().trim());

    }

    static int N, M;
    static char[][] map;
    static HashMap<Character, List<int[]>> hashMap;
    static int[][] d = { { -1, -1 }, { -1, 0 }, { -1, 1 }, { 0, -1 }, { 0, 1 }, { 1, -1 }, { 1, 0 }, { 1, 1 } };
    static HashMap<Character, HashMap<Character, List<int[]>>> start;

    static int findCase(String S) {

        if (S.length() == 1) {
            if (!hashMap.containsKey(S.charAt(0))) {
                return 0;
            } else
                return hashMap.get(S.charAt(0)).size();
        }

        List<int[]> list = hashMap.get(S.charAt(0));
        if (start.containsKey(S.charAt(0)) && start.get(S.charAt(0)).containsKey(S.charAt(1))) {
            list = start.get(S.charAt(0)).get(S.charAt(1));
        } else {
            list = AtoB(list, S.charAt(0), S.charAt(1));
            if (!start.containsKey(S.charAt(0))) {
                start.put(S.charAt(0), new HashMap<>());
            }
            start.get(S.charAt(0)).put(S.charAt(1), list);
        }

        for (int i = 1; i < S.length() - 1; i++) {

           list = AtoB(list, S.charAt(i), S.charAt(i + 1));
           if (list.isEmpty()) {
               break;
           }
         
        }

        return list.size();
    }

    static List<int[]> AtoB(List<int[]> list, char A, char B) {

        if (!hashMap.containsKey(A) || list.isEmpty()) {
            return new ArrayList<>();
        }

        Queue<int[]> queue = new LinkedList<>();
        for (int[] point : list) {
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
            return new ArrayList<>();
        }

        queue.addAll(temp);

        return list = new ArrayList<>(queue);
    }
}
