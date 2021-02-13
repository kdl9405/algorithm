package BJ;

import java.io.*;

/* 
    양팔저울     

    시간초과
*/

public class BJ2629_copy {
    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] weight = new int[Integer.parseInt(br.readLine())];
        String[] weights = br.readLine().split(" ");
        for (int i = 0; i < weight.length; i++) {
            weight[i] = Integer.parseInt(weights[i]);
        }

        int[] test = new int[Integer.parseInt(br.readLine())];
        String[] tests = br.readLine().split(" ");
        for (int i = 0; i < test.length; i++) {
            test[i] = Integer.parseInt(tests[i]);
        }

        possible = new boolean[15001];

        for (int i = 0; i < weight.length; i++) {
            if ((2 * i) > weight.length) {
                break;
            }
            for (int j = i; i + j <= weight.length; j++) {
                // System.out.println(i+" "+ j);
                if (i != 0 || j!= 0) {
                    visit = new boolean[weight.length];
                    arrA = new int[i];
                    dfs(weight, i, j, 0, 0);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int t : test){
            if (possible[t]) {
                sb.append("Y ");
            }else{
                sb.append("N ");
            }
        }

        System.out.println(sb.toString().trim());

    }

    static boolean[] possible;
    static int[] arrA;
    static int[] arrB;
    static boolean[] visit;

    static void dfs(int[] weight, int a, int b, int depth, int x) {

        if (a == 0) {
            arrB = new int[b];
            dfs2(weight, 0, b, 0, 0);

            return;
        }

        if (depth == a) {
            int A = 0;
            for (int n : arrA) {
                A += n;
            }
            arrB = new int[b];
            dfs2(weight, A, b, 0, 0);

            return;
        }

        for (int i = x; i < weight.length; i++) {
            if (!visit[i]) {
                visit[i] = true;
                arrA[depth] = weight[i];
                dfs(weight, a, b, depth + 1, i + 1);
                visit[i] = false;
            }
        }

    }

    static void dfs2(int[] weight, int A, int b, int depth, int x) {

        if (b == 0) {
            possible[A] = true;
            return;
        }

        if (depth == b) {
            int B = 0;
            for(int n : arrB){
                B+=n;
            }
            possible[Math.abs(A-B)] = true;

            return;
        }

        for (int i = x; i < weight.length; i++) {
            if (!visit[i]) {
                visit[i] = true;
                arrB[depth] = weight[i];
                dfs2(weight, A, b, depth + 1, i + 1);
                visit[i] = false;
            }
        }
    }    
}
