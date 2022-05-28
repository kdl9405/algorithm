package BOJ;

/**
 * 좋은 구간
 */

import java.io.*;
import java.util.*;

public class BOJ1059 {

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int L = Integer.parseInt(br.readLine());
        List<Integer> S = new ArrayList<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < L; i++) {
            S.add(Integer.parseInt(st.nextToken()));
        }

        int n = Integer.parseInt(br.readLine());

        Collections.sort(S);

        int min = 0;

        int i = 0;
        for (; i < L; i++) {
            if (S.get(i) < n) {
                min = S.get(i);
            } else {
                break;
            }
        }

        if (S.get(i) == n) {
            System.out.println(0);
            return;
        }

        int max = S.get(i);

        int ans = (n-min)*(max-n)-1;

        System.out.println(ans);
    }
}