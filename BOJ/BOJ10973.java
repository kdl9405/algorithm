package BOJ;

import java.io.*;
import java.util.*;

/* 
    이전 순열
*/
public class BOJ10973 {

    public static void main(String[] args) throws NumberFormatException, IOException {

        new BOJ10973().solution();
    }

    int N;
    Integer[] num;

    void solution() throws NumberFormatException, IOException {

        init();

        findPrevious();

        print();
    }

    void init() throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        num = new Integer[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }
    }

    void findPrevious() {

        for (int i = N - 1; i > 0; i--) {
            if (num[i - 1] > num[i]) {

                for (int j = N - 1; j >= 0 ; j--) {
                    if (num[j] < num[i - 1]) {
                        int temp = num[i - 1];
                        num[i - 1] = num[j];
                        num[j] = temp;

                        Arrays.sort(num, i, N, Comparator.reverseOrder());
                        return;
                    }
                }

            }
        }

        num = new Integer[] { -1 };
    }

    void print() {
        if (num.length > 1) {
            StringBuilder sb = new StringBuilder();
            for (Integer n : num) {
                sb.append(n).append(" ");
            }

            System.out.println(sb.toString().trim());
        } else {
            System.out.println(-1);
        }

    }
}
