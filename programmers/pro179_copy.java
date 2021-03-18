package programmers;

import java.io.*;
import java.util.*;

/* 
    문자열 지옥에 빠진 호석

    
*/
public class pro179_copy {
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
        HashMap<String, Integer> result = new HashMap<>();
        while (K-- > 0) {
            String S = br.readLine();
            int c = 0;
            if (result.containsKey(S)) {
                c = result.get(S);
            } else {
                c = findCase(S);
                result.put(S, c);
            }
            sb.append(c).append("\n");
        }

        System.out.println(sb.toString().trim());

    }

    static int N, M;
    static char[][] map;
    static HashMap<Character, List<int[]>> hashMap;
    static int[][] d = { { -1, -1 }, { -1, 0 }, { -1, 1 }, { 0, -1 }, { 0, 1 }, { 1, -1 }, { 1, 0 }, { 1, 1 } };

    static int findCase(String S) {
        int count = 0;

        if (!hashMap.containsKey(S.charAt(0))) {
            return 0;
        }

        Queue<int[]> queue = new LinkedList<>();
        for (int[] point : hashMap.get(S.charAt(0))) {
            queue.add(point);
        }

        for (int i = 1; i < S.length(); i++) {

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

                    if (S.charAt(i) == map[nx][ny]) {
                        temp.add(new int[] { nx, ny });
                    }

                }
            }

            if (temp.isEmpty()) {
                return 0;
            }

            queue.addAll(temp);
        }

        count = queue.size();

        return count;
    }
}
