package BOJ;

/*
    음악프로그램 


    메모리초과
*/

import java.io.*;
import java.util.*;

public class BOJ2623_copy1 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        afterNums = new HashMap<>();
        for (int i = 1; i <= N; i++) {
            afterNums.put(i, new HashSet<>());
        }

        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());
            int c = Integer.parseInt(st.nextToken());

            int before = Integer.parseInt(st.nextToken());

            while (c-- > 1) {
                int after = Integer.parseInt(st.nextToken());

                afterNums.get(before).add(after);
                before = after;

            }
        }

        PriorityQueue<Integer> pq =new PriorityQueue<>((a,b)->{
            return afterNums.get(b).size() - afterNums.get(a).size();
        });

        for(int i = 1; i<=N; i++){
            findAfter(i, i);
            pq.add(i);
        }

        if (impossible) {
            System.out.println(0);
        }else{
            StringBuilder sb = new StringBuilder();
            while (!pq.isEmpty()) {
                sb.append(pq.poll()+"\n");
            }
            System.out.println(sb.toString().trim());
        }

    }

    static int N, M;
    static HashMap<Integer, HashSet<Integer>> afterNums;
    static boolean impossible;

    static void findAfter(int now, int from) {

        for (int a : afterNums.get(now)) {

            if (afterNums.get(a).contains(from)) {
                impossible = true;
            }
            afterNums.get(from).add(a);
            findAfter(a, from);
        }

        return;
    }
}
