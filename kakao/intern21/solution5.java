package kakao.intern21;

import java.util.Arrays;

public class solution5 {

    public static void main(String[] args) {

        int k = 4;
        int[] num = { 6, 9, 7, 5 };
        int[][] links = { { -1, -1 }, { -1, -1 }, { -1, 0 }, { 2, 1 } };

        System.out.println(solution(k, num, links));
    }

    public static int solution(int k, int[] num, int[][] links) {

        link = links.clone();
        number = num.clone();

        parent = new int[num.length];
        sum = new int[num.length][2];

        for (int i = 0; i < num.length; i++) {
            parent[i] = i;
            sum[i][0] = i;
        }

        for (int i = 0; i < num.length; i++) {
            if (links[i][0] != -1) {
                parent[links[i][0]] = i;
            }
            if (links[i][1] != -1) {
                parent[links[i][1]] = i;
            }
        }

        for (int i = 0; i < num.length; i++) {
            findSum(i);
        }

       


        Arrays.sort(sum, (s1, s2) -> {
            return s2[1] - s1[1];
        });

        while (k-- > 1) {

            for (int i = 0; i < num.length; i++) {
                System.out.print(sum[i][1]+" ");
            }System.out.println("");


            int x = Integer.MIN_VALUE;
            int y = Integer.MIN_VALUE;

            if (link[sum[0][0]][0] != -1) {
                x = findSum(link[sum[0][0]][0]);
            }

            if (link[sum[0][0]][1] != -1) {
                y = findSum(link[sum[0][0]][1]);
            }

            if (x >= y) {
                link[sum[0][0]][0] = -1;
                sum[0][1] -= x;
            } else {
                link[sum[0][0]][1] = -1;
                sum[0][1] -= y;
            }

            Arrays.sort(sum, (s1, s2) -> {
                return s2[1] - s1[1];
            });

        }


        for (int i = 0; i < num.length; i++) {
            System.out.print(sum[i][1]+" ");
        }System.out.println("");

        return sum[0][1];
    }

    static int[] number;
    static int[][] link;
    static int[] parent;
    static int[][] sum;

    static int findSum(int x) {

        if (sum[x][1] != 0) {
            return sum[x][1];
        }

        sum[x][1] = number[x];

        if (link[x][0] != -1) {
            sum[x][1] += findSum(link[x][0]);
        }
        if (link[x][1] != -1) {
            sum[x][1] += findSum(link[x][1]);
        }

        return sum[x][1];

    }
}
