package BOJ;

/*
    종이자르기
*/

import java.io.*;
import java.util.*;

public class BOJ2628 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int C = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        int N = Integer.parseInt(br.readLine());

        List<Integer> row = new ArrayList<>();
        List<Integer> col = new ArrayList<>();

        while (N-- > 0) {
            st = new StringTokenizer(br.readLine());

            if (Integer.parseInt(st.nextToken()) == 0) {
                row.add(Integer.parseInt(st.nextToken()));
            } else {
                col.add(Integer.parseInt(st.nextToken()));
            }
        }

        row.add(R);
        col.add(C);

        int maxR = R;
        int maxC = C;
        if (!row.isEmpty()) {
            Collections.sort(row);
            maxR = row.get(0);
            for (int i = 1; i < row.size(); i++) {
                maxR = Math.max(maxR, row.get(i) - row.get(i-1));
            }
        }

        if (!col.isEmpty()) {
            Collections.sort(col);
            maxC = col.get(0);
            for (int i = 1; i < col.size(); i++) {
                maxC = Math.max(maxC, col.get(i) - col.get(i-1));
            }
        }

        System.out.println(maxR*maxC);

    }
}