package BOJ;

import java.io.*;
import java.util.*;

/* 
    승부 예측
    틀림... 확률처리???
*/

public class BOJ15997_copy {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        HashMap<String, Integer> table = new HashMap<>();

        String Team = br.readLine();
        StringTokenizer st = new StringTokenizer(Team);

        for (int i = 0; i < 4; i++) {
            table.put(st.nextToken(), 0);
        }

        for (int i = 0; i < 6; i++) {
            st = new StringTokenizer(br.readLine());
            String A = st.nextToken();
            String B = st.nextToken();
            double w = Double.valueOf(st.nextToken());
            double d = Double.valueOf(st.nextToken());
            double l = Double.valueOf(st.nextToken());

            if (w == l || (d > w && d > l)) {
                table.put(A, table.get(A) + 1);
                table.put(B, table.get(B) + 1);
            } else if (w > l) {
                table.put(A, table.get(A) + 3);
            } else if (l > w) {
                table.put(B, table.get(B) + 3);
            }
        }

        HashMap<Integer, Integer> pointT = new HashMap<>();

        for (String t : table.keySet()) {
            pointT.put(table.get(t), pointT.getOrDefault(table.get(t), 0) + 1);
        }

        HashMap<Integer, Double> probability = new HashMap<>();
        int chance = 2;

        int[] points = pointT.keySet().stream().mapToInt(i -> i).toArray();

        for (int i = points.length - 1; i >= 0; i--) {

            if (chance >= pointT.get(points[i])) {
                probability.put(points[i], (double) 1);
                chance -= pointT.get(points[i]);
            } else if (chance == 0) {
                probability.put(points[i], (double) 0);
            } else {
                probability.put(points[i], (double) chance / (double) pointT.get(points[i]));
                chance = 0;
            }
        }

        StringBuilder sb = new StringBuilder();
        st = new StringTokenizer(Team);
        for (int i = 0; i < 4; i++) {

            double p = probability.get(table.get(st.nextToken()));

            sb.append(String.format("%.10f", p)).append("\n");
        }

        System.out.println(sb.toString());

    }
}