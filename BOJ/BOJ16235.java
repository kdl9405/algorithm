package BOJ;

import java.io.*;
import java.util.*;

/* 
    나무 재테크
*/
public class BOJ16235 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        map = new int[N+1][N+1][2];
        tree = new HashMap<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j][0] = 5;
                map[i][j][1] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            String point = st.nextToken() + " " + st.nextToken();
            int age = Integer.parseInt(st.nextToken());

            System.out.println(point);
            if (!tree.containsKey(point)) {
                tree.put(point, new PriorityQueue<>());
            }
            tree.get(point).add(age);
        }

        while (K-- > 0) {

            plant();

            for(String s : tree.keySet()){
                System.out.println("!!!!!" + s);
            }

            System.out.println(map[1][1][0] +" "+ tree.get("1 1").peek());

            reproduct();
            System.out.println(map[1][1][0] +" "+ tree.get("1"+" "+"1").peek());

            addA();
            System.out.println(map[1][1][0] +" "+ tree.get(1+" "+1).peek());


        }

        int answer = 0;
        for(String point : tree.keySet()){
            answer += tree.get(point).size();
        }

        System.out.println(answer);

    }

    static int N;
    static int[][][] map;
    static HashMap<String, PriorityQueue<Integer>> tree;
    static int[][] d = { { -1, -1 }, { -1, 0 }, { -1, 1 }, { 0, -1 }, { 0, 1 }, { 1, -1 }, { 1, 0 }, { 1, 1 } };

    static void plant() {

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                String point = i + " " + j;
                if (tree.containsKey(point)) {
                    int size = tree.get(point).size();
                    int p = map[i][j][0];
                    int addP = 0;
                    Queue<Integer> temp = new LinkedList<>();
                    for (int x = 0; x < size; x++) {
                        int t = tree.get(point).poll();
                        if (p >= t) {
                            p -= t;
                            temp.add(t + 1);
                        } else {
                            addP += (t / 2);
                        }
                    }
                    tree.get(point).addAll(temp);
                    map[i][j][0] = p + addP;
                }
            }
        }
        return;
    }

    static void reproduct() {
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                String point = i+" "+j;
                if (tree.containsKey(point)) {
                    int count = 0;
                    int size = tree.get(point).size();
                    for(int x = 0; x<size;x++){
                        int t = tree.get(point).poll();
                        if (t % 5 != 0) {
                            tree.get(point).offer(t);
                        }else {
                            count++;
                        }
                    }   
                    
                    for(int x = 0; x<8; x++){
                        int nx = i+d[x][0];
                        int ny = j+d[x][1];

                        if (nx>=1 && nx<=N && ny>=1 && ny<=N) {
                            tree.get(nx+" "+ny).add(count);
                        }
                    }
                }
            }
        }
    }

    static void addA() {
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                map[i][j][0] += map[i][j][1];
            }
        }
    }
}
