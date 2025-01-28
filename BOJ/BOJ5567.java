package boj;

/*
 * 결혼식
 */

import java.io.*;
import java.util.*;

public class BOJ5567 {

    public static void main(String[] args) throws NumberFormatException, IOException {

        new BOJ5567().solution();
    }

    private void solution() throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        List<List<Integer>> friends = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            friends.add(new ArrayList<>());
        }

        while (m-- > 0) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            friends.get(a).add(b);
            friends.get(b).add(a);
        }

        int count = 0;
        boolean[] isChecked = new boolean[n + 1];
        isChecked[1] = true;

        for (int f : friends.get(1)) {
            if (!isChecked[f]) {
                count++;
                isChecked[f] = true;
            }

            for (int ff : friends.get(f)) {
                if (isChecked[ff]) {
                    continue;
                }
                isChecked[ff] = true;
                count++;
            }
        }

        System.out.println(count);

    }

}
