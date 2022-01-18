package BOJ;

/* 
    결혼식 
*/

import java.io.*;
import java.util.*;

public class BOJ5567_copy {

    public static void main(String[] args) throws NumberFormatException, IOException {

        new BOJ5567_copy().solution();
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

        Queue<Integer> invited = new LinkedList<>();
        invited.add(1);
        isChecked[1] = true;

        for (int d = 0; d < 2; d++) {

            int size = invited.size();
            while (size-- > 0) {
                int f = invited.poll();

                for (int ff : friends.get(f)) {
                    if (isChecked[ff]) {
                        continue;
                    }
                    isChecked[ff] = true;
                    invited.add(ff);
                    count++;
                }
            }

        }

        System.out.println(count);

    }

}
