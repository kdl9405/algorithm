package programmers.month2104;

import java.util.*;

//  런타임 에러 3개

public class so3_test {

    public static void main(String[] args) {

        // Garbage Collection으로 메모리 초기화
        System.gc();

        // 실행전 메모리 사용량 조회
        long before = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();

        // 측정하고싶은 코드

        int[] a = { -1, 1, -1, 1, -1, 1, -1, 1, -1, 1, -1, 1, -1, 1, -1, 1, -1, 1, -1, 1, -1, 1, -1, 1, -1, 1, -1, 1,
                -1, 1, -1, 1, -1, 1, -1, 1, -1, 1, -1, 1, -1, 1, -1, 1, -1, 1, -1, 1, -1, 1, -1, 1, -1, 1, -1, 1, -1, 1,
                -1, 1, -1, 1, -1, 1, -1, 1, -1, 1, -1, 1, -1, 1, -1, 1, -1, 1, -1, 1, -1, 1, -1, 1, -1, 1, -1, 1, -1, 1,
                -1, 1, -1, 1, -1, 1, -1, 1, -1, 1, -1, 1 };
        // int[][] edges = { { 0, 1 }, { 3, 4 }, { 2, 3 }, { 0, 3 } };
        int[][] edges = new int[99][2];
        for (int i = 0; i < 99; i++) {
            edges[i][0] = i;
            edges[i][1] = i + 1;
        }

        System.out.println(solution(a, edges));

        // Garbage Collection으로 메모리 정리
        System.gc();

        // 실행 후 메모리 사용량 조회
        long after = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();

        // 메모리 사용량 측정
        long usedMemory = (before - after) / 1024;

        System.out.println("Used Memory : " + usedMemory);

        // 애플리케이션에 할당돈 힙메모리 사이즈. 이 사이즈를 넘어서면 OOM발생
        long heapSize = Runtime.getRuntime().maxMemory();
        System.out.println(heapSize / 1024 / 1024);

    }

    static ArrayList<Integer>[] tree;
    static long[] w;
    static long[] dp;

    public static long solution(int[] a, int[][] edges) {
        // 각 노드 가중치의 합이 0이 아니면 -1
        if (Arrays.stream(a).sum() != 0) {
            return -1;
        }
        dp = new long[a.length];
        w = new long[a.length];
        for (int i = 0; i < a.length; i++) {
            w[i] = a[i];
        }
        tree = new ArrayList[w.length];
        for (int i = 0; i < w.length; i++) {
            tree[i] = new ArrayList<>();
        }
        // 양방향 간선 추가
        for (int i = 0; i < edges.length; i++) {
            tree[edges[i][0]].add(edges[i][1]);
            tree[edges[i][1]].add(edges[i][0]);
        }

        // 간선이 총 1개면(노드가 총 2개면)
        if (edges.length == 1) {
            return Math.abs(w[0]);
        }

        // 간선이 2개 이상인 노드를 루트노드로 함
        int root = 0;
        for (int i = 0; i < w.length; i++) {
            if (tree[i].size() >= 2) {
                root = i;
                break;
            }
        }
        long ans = buildTree(root, -1);
        return ans;
    }

    // 트리를 구성
    static long buildTree(int cur, int parent) {
        // 리프노드면
        if (tree[cur].size() == 1) {
            w[parent] += w[cur];
            return dp[cur] = Math.abs(w[cur]);
        }

        for (int i = 0; i < tree[cur].size(); i++) {
            int child = tree[cur].get(i);
            if (parent != child) {
                dp[cur] += buildTree(child, cur);
            }
        }

        // for (Integer child : tree[cur]) {
        // if (parent != child) { // 부모를 제외한 간선들
        // dp[cur] += buildTree(child, cur);
        // }
        // }
        // 현재 노드의 가중치가 0이 아니면 부모 노드에 가중치를 반영
        if (w[cur] != 0) {
            w[parent] += w[cur];
            dp[cur] += Math.abs(w[cur]);
        }
        return dp[cur];
    }

}