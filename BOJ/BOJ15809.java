package BOJ;

import java.io.*;
import java.util.*;

/**
 * 전국시대
 * 
 * 1) root로 그룹을 묶어서 표현 2) root을 찾은 후 전투 및 병력 계산.
 * 
 * 
 *  정렬 시 PQ 활용
 *      java 8 : 568ms
 *      java 11 : 556ms
 */
public class BOJ15809 {

    static int[] militaly;
    static int[] root;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        root = new int[N + 1];
        militaly = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            root[i] = i;
            militaly[i] = Integer.parseInt(br.readLine());
        }

        int P, Q;
        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());

            String O = st.nextToken();
            P = findRoot(Integer.parseInt(st.nextToken()));
            Q = findRoot(Integer.parseInt(st.nextToken()));

            if (O.equals("1")) { // 동맹

                root[Q] = P;
                militaly[P] += militaly[Q];
                militaly[Q] = -1;

            } else { // 전투
                if (militaly[P] == militaly[Q]) {
                    root[P] = 0;
                    root[Q] = 0;
                    militaly[P] = -1;
                    militaly[Q] = -1;

                } else if (militaly[P] > militaly[Q]) {
                    militaly[P] -= militaly[Q];
                    root[Q] = P;
                    militaly[Q] = -1;

                } else {
                    militaly[Q] -= militaly[P];
                    root[P] = Q;
                    militaly[P] = -1;
                }
            }
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i = 1; i<=N; i++){
            if (militaly[i] != -1) {
                pq.add(militaly[i]);
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(pq.size()+"\n");

        while (!pq.isEmpty()) {
            sb.append(pq.poll()+" ");
        }
        
        System.out.println(sb.toString());
    }

    static int findRoot(int n) {
        if (root[n] == n) {
            return n;
        }
        return root[n] = findRoot(root[n]);
    }

}