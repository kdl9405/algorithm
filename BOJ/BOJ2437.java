package BOJ;

/* 
    저울
*/

import java.io.*;
import java.util.*;

public class BOJ2437 {
    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] num = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(num);

        int weight = 1;

        for (int i = 0; i < N; i++) {
            if (weight < num[i]) {
                break;
            }
            weight += num[i];
        }

        System.out.println(weight);
    }

}
