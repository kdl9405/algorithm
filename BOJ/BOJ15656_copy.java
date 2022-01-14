package BOJ;

/* 
    N과 M (7)
*/

import java.io.*;
import java.util.*;

public class BOJ15656_copy {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        br.close();

        Arrays.sort(arr);

        sequence = new String[M];
        backTracking(0);

        bw.flush();
        bw.close();

    }

    static int N, M;
    static int[] arr;
    static String[] sequence;
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static void backTracking(int count) throws IOException {
        if (count == M) {
            for (String s : sequence) {
                bw.write(s);
                bw.write(" ");
            }
            bw.write("\n");
            return;
        }

        for (int i = 0; i < N; i++) {
            sequence[count] = Integer.toString(arr[i]);
            backTracking(count + 1);
        }

    }
}