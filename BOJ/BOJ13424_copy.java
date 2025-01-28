package boj;

import java.io.*;
import java.util.*;

/**
 * 비밀 모임
 */
public class BOJ13424_copy {

    static final int INF = 50_000;
    static List<TNode>[] map;
    static int[] distance;
    static boolean[] visited;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            map = new ArrayList[n + 1];
            distance = new int[n + 1];
            visited = new boolean[n + 1];
            for (int i = 1; i < map.length; i++) {
                map[i] = new ArrayList<>();
            }

            while (m-- > 0) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());

                map[a].add(new TNode(b, c));
                map[b].add(new TNode(a, c));
            }
            int k = Integer.parseInt(br.readLine());
            int[] position = new int[k];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < position.length; i++) {
                position[i] = Integer.parseInt(st.nextToken());
            }
            int answer = dijkstra(position);
            bw.write(answer + "\n");
        }
        br.close();
        bw.flush();
        bw.close();
    }

    static int dijkstra(int[] position) {
        int[] answerArr = new int[distance.length];
        PriorityQueue<TNode> pq = new PriorityQueue<>();

        for (int i = 0; i < position.length; i++) {
            int start = position[i];
            for (int j = 1; j < distance.length; j++) {
                distance[j] = INF;
                visited[j] = false;
            }
            distance[start] = 0;
            pq.offer(new TNode(start, 0));
            while (!pq.isEmpty()) {
                TNode current = pq.poll();
                visited[current.node] = true;
                List<TNode> adjList = map[current.node];
                for (int j = 0, size = adjList.size(); j < size; j++) {
                    TNode nextNode = adjList.get(j);
                    if (!visited[nextNode.node]
                            && distance[nextNode.node] > distance[current.node] + nextNode.cost) {
                        distance[nextNode.node] = distance[current.node] + nextNode.cost;
                        pq.add(new TNode(nextNode.node, distance[nextNode.node]));
                    }
                }
            }
            for (int j = 1; j < answerArr.length; j++) {
                answerArr[j] += distance[j];
            }
        }

        int answer = 1;
        int roomDistance = answerArr[1];
        for (int i = 2; i < answerArr.length; i++) {
            if (roomDistance > answerArr[i]) {
                answer = i;
                roomDistance = answerArr[i];
            }
        }
        return answer;
    }
}


class TNode implements Comparable<TNode> {
    int node;
    int cost;

    public TNode(int node, int cost) {
        this.node = node;
        this.cost = cost;
    }

    @Override
    public int compareTo(TNode o) {
        return this.cost - o.cost;
    }

}
