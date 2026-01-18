package programmers;

import java.util.Arrays;

/*
 * 코딩테스트 연습 2021 카카오 채용연계형 인턴십 시험장 나누기
 */

public class pro285 {


    public static void main(String[] args) {

    }

    public int solution(int k, int[] num, int[][] links) {

        int[] parents = findParent(links);

        int root = -1;
        int maxNum = 0;
        long total = 0;
        for (int i = 0; i < parents.length; i++) {
            if (parents[i] == -1) {
                root = i;
            }

            maxNum = Math.max(maxNum, num[i]);
            total += num[i];
        }

        long left = maxNum;
        long right = total;
        long answer = total;

        while (left <= right) {
            long mid = (left + right) / 2;

            groupCount = 0;
            check(root, num, links, mid);


            if (groupCount + 1 <= k) {
                answer = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }

        }

        return (int) answer;

    }

    private int groupCount;

    private int[] findParent(int[][] links) {

        int[] parents = new int[links.length];
        Arrays.fill(parents, -1);

        for (int i = 0; i < links.length; i++) {

            for (int child : links[i]) {
                if (child != -1) {
                    parents[child] = i;
                }
            }
        }

        return parents;
    }

    private int check(int root, int[] num, int[][] links, long limit) {

        int left = (links[root][0] != -1) ? check(links[root][0], num, links, limit) : 0;
        int right = (links[root][1] != -1) ? check(links[root][1], num, links, limit) : 0;

        if (left + right + num[root] <= limit) {
            return num[root] + left + right;
        }

        if (num[root] + Math.min(left, right) <= limit) {
            groupCount++;
            return num[root] + Math.min(left, right);
        }

        groupCount += 2;

        return num[root];
    }
}
