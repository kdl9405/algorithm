package BOJ;

import java.io.*;
import java.util.*;

/* 
    MST 게임

    1092 ms
*/
public class BOJ16202_copy {

    static int N, M;
    static boolean[] closedLine;
    static boolean[] visitLine;
    static ArrayList<ArrayList<int[]>> lines;
    static int[][] lineDetail;
    static HashSet<Integer> group;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        lineDetail = new int[M + 1][2];

        lines = new ArrayList<>();

        for (int i = 0; i <= N; i++) {
            lines.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            lineDetail[i + 1][0] = a;
            lineDetail[i + 1][1] = b;

            lines.get(a).add(new int[] { b, i + 1 });
            lines.get(b).add(new int[] { a, i + 1 });
        }

        closedLine = new boolean[M + 1];

        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= K; i++) {

            visitLine = closedLine.clone();

            // 계산
            group = new HashSet<>();

            int sum = findMST(i);

            if (sum == 0) {
                for (int j = i; j <= K; j++) {
                    sb.append(0 + " ");
                }
                break;
            } else {
                sb.append(sum + " ");
            }

            closedLine[i] = true;

        }

        System.out.println(sb.toString());
    }

    static int findMST(int start) {

        int sum = start;
        visitLine[start] = true;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            return a[1] - b[1];
        });

        group.add(lineDetail[start][0]);
        group.add(lineDetail[start][1]);

        for (int node : group) {
            for (int[] e : lines.get(node)) {
                if (!visitLine[e[1]]) {
                    pq.add(e);
                }
            }
        }

        while (!pq.isEmpty()) {

            if (group.size() == N) {
                break; // 합계 리턴 해야함
            }

            int[] link = pq.poll();

            if (group.contains(link[0]) || visitLine[link[1]]) {
                continue;
            }

            group.add(link[0]);
            sum += link[1];
            visitLine[link[1]] = true;

            for (int[] e : lines.get(link[0])) {
                if (!group.contains(e[0]) && !visitLine[e[1]]) {
                    pq.add(e);
                }
            }
        }

        if (group.size() < N) {
            return 0;
        } else {
            return sum;
        }
    }

    // i 간선부터 시작해서 연결된 노드가 가진 최소 간선을 연결
    // static void findMST(int start, int s) {

    // if (group.size() == N) {
    // sum = Math.min(sum, s);
    // return;
    // }

    // if (start >= M || s >= sum) {
    // return;
    // }

    // List<int[]> list = new ArrayList<>();

    // for(int node : group){
    // for(int[] edge : lines.get(node)){

    // if (visitLine[edge[1]] || group.contains(edge[0])) {
    // continue;
    // }

    // list.add(edge);

    // }
    // }

    // Collections.sort(list, (a,b)->{
    // return a[1] - b[1];
    // } );

    // for(int[] link : list){

    // group.add(link[0]);
    // visitLine[link[1]] = true;

    // findMST(link[1] + 1, s + link[1] + 1);

    // visitLine[link[1]] = false;
    // group.remove(link[0]);
    // }
    // }
}
