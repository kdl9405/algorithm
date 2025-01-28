package boj;

/*
 * 벡터 매칭
 */

import java.io.*;
import java.util.*;

public class BOJ1007 {

    public static void main(String[] args) throws NumberFormatException, IOException {

        new BOJ1007().solution();
    }

    void solution() throws NumberFormatException, IOException {

        br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {

            init();

            bruteforce(0, 0);
            sb.append(answer).append("\n");
        }

        System.out.println(sb.toString().trim());

    }

    BufferedReader br;
    StringTokenizer st;
    int N;
    List<Point> pointList;
    boolean[] isStart;
    double answer;

    private class Point {
        int x;
        int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    void init() throws NumberFormatException, IOException {

        pointList = new ArrayList<>();

        N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            pointList.add(new Point(x, y));
        }

        isStart = new boolean[N];
        answer = Double.MAX_VALUE;
    }

    void bruteforce(int index, int count) {

        if (count == N / 2) {
            answer = Math.min(answer, getDistance());

            return;
        }

        for (int i = index; i < N; i++) {
            isStart[i] = true;
            bruteforce(i + 1, count + 1);
            isStart[i] = false;
        }

    }

    double getDistance() {

        int x = 0;
        int y = 0;

        for (int i = 0; i < N; i++) {
            if (isStart[i]) {
                x -= pointList.get(i).x;
                y -= pointList.get(i).y;
            } else {
                x += pointList.get(i).x;
                y += pointList.get(i).y;
            }
        }

        return Math.sqrt((Math.pow(x, 2) + Math.pow(y, 2)));
    }

}
