package BOJ;

/* 
    숫자고르기
*/

import java.io.*;
import java.util.*;

public class BOJ2668 {

    public static void main(String[] args) throws NumberFormatException, IOException {

        new BOJ2668().solution();

    }

    void solution() throws NumberFormatException, IOException {

        init();

        for (int i = 1; i <= N; i++) {

            if(answer.contains(i)){
                continue;
            }

            isVisited[i] = true;
            dfs(i, i);
            isVisited[i] = false;
        }


        StringBuilder sb = new StringBuilder();
        sb.append(answer.size()).append("\n");
        for(int a : answer){
            sb.append(a).append("\n");
        }

        System.out.println(sb.toString().trim());

    }

    int N;
    int[] num;
    boolean[] isVisited;
    Set<Integer> answer;

    void init() throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        num = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            num[i] = Integer.parseInt(br.readLine());
        }

        isVisited = new boolean[N + 1];
        answer = new TreeSet<>();

    }

    void dfs(int start, int now) {

        if (!isVisited[num[now]]) {
            isVisited[num[now]] = true;
            dfs(start, num[now]);
            isVisited[num[now]] = false;
        }

        if (num[now] == start) {
            answer.add(start);
        }

    }
}
