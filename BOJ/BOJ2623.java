package BOJ;

/*
    음악프로그램 

*/

import java.io.*;
import java.util.*;

public class BOJ2623 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        afterNums = new HashMap<>();
        for (int i = 1; i <= N; i++) {
            afterNums.put(i, new ArrayList<>());
        }

        level = new int[N + 1];

        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());

            int c = Integer.parseInt(st.nextToken());
            int before = Integer.parseInt(st.nextToken());

            while (c-- > 1) {
                int after = Integer.parseInt(st.nextToken());

                afterNums.get(before).add(after);
                level[after]++;
                before = after;

            }

        }

        Queue<Integer> queue = new LinkedList<>();

        for(int i = 1; i<=N; i++){
            if (level[i]==0) {
                queue.offer(i);
            }
        }

        int count = 0;
        StringBuilder sb = new StringBuilder();
        while (!queue.isEmpty()) {
            int now = queue.poll();
            sb.append(now+"\n");
            count++;

            for(int a : afterNums.get(now)){
                level[a]--;

                if (level[a] == 0) {
                    queue.offer(a);
                }
            }
        }

        if (count!=N) {
            System.out.println(0+"\n");
        }else{            
            System.out.println(sb.toString());
        }

    }

    static int N, M;
    static HashMap<Integer, ArrayList<Integer>> afterNums;
    static int[] level;

}
