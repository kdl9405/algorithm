package BOJ;

import java.io.*;
import java.util.*;

/* 
    상근이의 여행
*/

public class BOJ9372_copy {

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            List<List<Integer>> flight = new ArrayList<>();
            for(int i = 0 ;i<=N; i++){
                flight.add(new ArrayList<>());
            }

            while (M-- > 0) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                flight.get(a).add(b);
                flight.get(b).add(a);
            }

            boolean[] visit = new boolean[N + 1];

            sb.append(trip(flight, visit, 1)).append("\n");


        }

        System.out.println(sb.toString().trim());

    }

    static int trip(List<List<Integer>> flight, boolean[] visit, int now) {

        visit[now] = true;

        int fly = 0;

        for (int next : flight.get(now)) {
            if (visit[next]) {
                continue;
            }

            fly += (trip(flight, visit, next)+1);
        }

        return fly;
    }
}
