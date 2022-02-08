package BOJ;

/* 
    이차원 배열과 연산
 */

import java.io.*;
import java.util.*;

public class BOJ17140 {

    public static void main(String[] args) throws IOException {

        new BOJ17140().solution();

    }

    void print(int time){

        System.out.println("----- " + time+" -----");

        for(int i = 0; i<arr.length; i++){
            for(int j = 0; j<arr[0].length; j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    }

    void solution() throws IOException {

        init();

        int time = 0;

        while (time <= 100) {

            if (isFinish()) {
                break;
            }

            if (arr.length >= arr[0].length) {
                operR();
            } else {
                operC();
            }

            time++;
        }

        if (time == 101) {
            time = -1;
        }

        System.out.println(time);

    }

    int r, c, k;
    int[][] arr;

    void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken()) - 1;
        c = Integer.parseInt(st.nextToken()) - 1;
        k = Integer.parseInt(st.nextToken());

        arr = new int[3][3];

        for (int i = 0; i < 3; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }

    boolean isFinish() {

        if (arr.length <= r || arr[0].length <= c || arr[r][c] != k) {
            return false;
        }

        return true;
    }

    void operR() {

        List<Map<Integer, Integer>> temp = new ArrayList<>();
        int len = 0;
        for (int i = 0; i < arr.length; i++) {

            temp.add(new HashMap<>());
            for (int j = 0; j < arr[0].length; j++) {
                if (arr[i][j] != 0) {
                    temp.get(i).put(arr[i][j], temp.get(i).getOrDefault(arr[i][j], 0) + 1);
                }
            }
            len = Math.max(len, temp.get(i).size());
        }

        len = Math.min(len * 2, 100);
        arr = new int[arr.length][len];
        PriorityQueue<Number> pq;
        for (int i = 0; i < arr.length; i++) {
            pq = new PriorityQueue<>();
            for (int num : temp.get(i).keySet()) {
                pq.add(new Number(num, temp.get(i).get(num)));
            }
            int j = 0;
            while (!pq.isEmpty() && j < len) {
                Number n = pq.poll();
                arr[i][j] = n.num;
                arr[i][j + 1] = n.count;
                j += 2;
            }
        }

    }

    void operC() {

        List<Map<Integer, Integer>> temp = new ArrayList<>();
        int len = 0;
        for (int j = 0; j < arr[0].length; j++) {

            temp.add(new HashMap<>());
            for (int i = 0; i < arr.length; i++) {
                if (arr[i][j] != 0) {
                    temp.get(j).put(arr[i][j], temp.get(j).getOrDefault(arr[i][j], 0) + 1);
                }
            }
            len = Math.max(len, temp.get(j).size());
        }

        len = Math.min(len * 2, 100);
        arr = new int[len][arr[0].length];
        PriorityQueue<Number> pq;
        for (int j = 0; j < arr[0].length; j++) {
            pq = new PriorityQueue<>();
            for (int num : temp.get(j).keySet()) {
                pq.add(new Number(num, temp.get(j).get(num)));
            }
            int i = 0;
            while (!pq.isEmpty() && i < len) {
                Number n = pq.poll();
                arr[i][j] = n.num;
                arr[i + 1][j] = n.count;
                i += 2;
            }
        }

    }

    private class Number implements Comparable<Number> {

        int num;
        int count;

        Number(int num, int count) {
            this.num = num;
            this.count = count;
        }

        @Override
        public int compareTo(Number o) {
            if (count == o.count) {
                return num - o.num;
            }
            return count - o.count;
        }
    }

}
