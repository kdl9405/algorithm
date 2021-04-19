package programmers.month2104;

import java.util.*;

//  DFS  => 통과

public class so3_copy_fin {

    public static void main(String[] args) {

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

        // Garbage Collection으로 메모리 초기화
        System.gc();

        // 실행전 메모리 사용량 조회
        long before = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();

        System.out.println(solution(a, edges));

        // Garbage Collection으로 메모리 정리
        System.gc();

        // 실행 후 메모리 사용량 조회
        long after = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();

        // 메모리 사용량 측정
        long usedMemory = (before - after);

        System.out.println("Used Memory : " + usedMemory);

        // 애플리케이션에 할당돈 힙메모리 사이즈. 이 사이즈를 넘어서면 OOM발생
        long heapSize = Runtime.getRuntime().maxMemory();
        System.out.println(heapSize / 1024 / 1024);

    }

    static ArrayList<ArrayList<Integer>> line;
    static long[] w;

    public static long solution(int[] a, int[][] edges) {

        long answer = 0;

        w = new long[a.length];
        for (int i = 0; i < a.length; i++) {
            w[i] += a[i];
            answer += a[i];
        }

        if (answer != 0) {
            return -1;
        }

        line = new ArrayList<>();
        for (int i = 0; i < a.length; i++) {
            line.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            line.get(edge[0]).add(edge[1]);
            line.get(edge[1]).add(edge[0]);
        }

        answer = dfs(0, -1);

        return answer;
    }

    static long dfs(int n, int parent) {

        long temp = 0;

        for (int next : line.get(n)) {
            if (next != parent) {
                temp += dfs(next, n);
            }
        }

        // for (int i = 0; i < line.get(n).size(); i++) {
        //     int next = line.get(n).get(i);
        //     if (next != parent) {
        //         temp += dfs(next, n);
        //     }
        // }

        if (parent != -1) {
            w[parent] += w[n];
        }

        return temp + Math.abs(w[n]);

    }

}