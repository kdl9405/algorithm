package BOJ;

import java.io.*;
import java.util.*;

/*
    회사 문화 1

    java 11: 740ms
*/
public class BOJ14267_copy2 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        junior = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            junior.add(new ArrayList<>());
        }

        st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= n; i++) {
            int b = Integer.parseInt(st.nextToken());
            if (i == 1) {
                continue;
            }
            junior.get(b).add(i);
        }

        point = new int[n + 1];

        while (m-- > 0) {
            st = new StringTokenizer(br.readLine());

            int i = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            point[i] += w;            
        }

        sumPoint(1);

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            sb.append(point[i] + " ");
        }

        System.out.println(sb.toString());

    }

    static List<List<Integer>> junior;
    static int[] point;

    static void sumPoint(int boss){

        for(Integer j : junior.get(boss)){
            point[j]+= point[boss];
            sumPoint(j);
        }
        return;
    }

}
