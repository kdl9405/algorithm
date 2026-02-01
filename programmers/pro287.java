package programmers;

import java.util.ArrayList;
import java.util.List;

/*
 * 코딩테스트 연습 연습문제 등대
 */
public class pro287 {

    public int solution(int n, int[][] lighthouse) {

        links = new ArrayList[n + 1];

        for (int i = 1; i <= n; i++) {
            links[i] = new ArrayList<>();
        }

        for (int[] light : lighthouse) {
            links[light[0]].add(light[1]);
            links[light[1]].add(light[0]);
        }

        isChildOn(1, 0);

        return answer;
    }

    private List<Integer>[] links;
    private int answer = 0;

    private boolean isChildOn(int now, int parent) {
        if (links[now].size() == 1 && links[now].get(0) == parent) {
            return false;
        }

        boolean needOn = false;
        for (int child : links[now]) {
            if (child == parent)
                continue;

            if (!isChildOn(child, now)) {
                needOn = true;
            }
        }

        if (needOn) {
            answer++;
            return true;
        }

        return false;
    }

}
