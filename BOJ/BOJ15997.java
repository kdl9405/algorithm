package BOJ;

import java.io.*;
import java.util.*;

/* 
    승부 예측

    // 6경기에 대한 승무패를 모두 구하여 6^3 경우의 수에 대한 확률을 누적.
*/

public class BOJ15997 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        HashMap<String, Double> table = new HashMap<>();

        String Team = br.readLine();
        StringTokenizer st = new StringTokenizer(Team);

        for (int i = 0; i < 4; i++) {
            table.put(st.nextToken(), (double)0);
        }

        for (int i = 0; i < 6; i++) {
            st = new StringTokenizer(br.readLine());
            String A = st.nextToken();
            String B = st.nextToken();
            double w = Double.valueOf(st.nextToken());
            double d = Double.valueOf(st.nextToken());
            double l = Double.valueOf(st.nextToken());

            table.put(A, table.get(A)+(w*3)+(d));
            table.put(B, table.get(B)+(l*3)+(d));

        }

        HashMap<Double, Integer> pointT = new HashMap<>();

        for (String t : table.keySet()) {
            pointT.put(table.get(t), pointT.getOrDefault(table.get(t), 0) + 1);
        }

        HashMap<Double, Double> probability = new HashMap<>();
        int chance = 2;

        double[] points = pointT.keySet().stream().mapToDouble(i -> i).toArray();
        Arrays.sort(points);

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