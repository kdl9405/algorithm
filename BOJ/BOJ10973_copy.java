package BOJ;

import java.io.*;
import java.util.*;

/* 
    이전 순열
*/
public class BOJ10973_copy {

    public static void main(String[] args) throws NumberFormatException, IOException {

        new BOJ10973_copy().solution();
    }

    int N;
    Integer[] num;

    void solution() throws NumberFormatException, IOException {

        init();

        printPrevious();

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

    void printPrevious() {

        int i = N - 1;

        while (i > 0 && num[i - 1] < num[i]) {
            i--;
        }

        if (i == 0) {
            System.out.println(-1);
            return;
        }

        int j = N - 1;

        while (num[j] >= num[i - 1]) {
            j--;
        }

        int temp = num[i - 1];
        num[i - 1] = num[j];
        num[j] = temp;

        StringBuilder answer = new StringBuilder();
        for(int idx = 0; idx <i; idx++){
            answer.append(num[idx]).append(" ");
        }

        for(int idx = N-1; idx>=i; idx--){
            answer.append(num[idx]).append(" ");
        }

        System.out.println(answer.toString().trim());
    }
    
}
