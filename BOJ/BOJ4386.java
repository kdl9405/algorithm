package boj;

import java.io.*;
import java.util.*;

/*
 * 별자리 만들기
 */
public class BOJ4386 {

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());

        LinkedList<double[]> stars = new LinkedList<>();

        for (int i = 0; i < n; i++) {

            st = new StringTokenizer(br.readLine());
            double x = Double.parseDouble(st.nextToken());
            double y = Double.parseDouble(st.nextToken());

            stars.add(new double[] {x, y});
        }

        Collections.sort(stars, (a, b) -> {

            return Double.compare(Math.abs(a[0] + a[1]), Math.abs(b[0] + b[1]));
        });

        double cost = 0;

        HashSet<double[]> set = new HashSet<>();
        set.add(stars.get(0));
        stars.remove(0);

        while (!stars.isEmpty()) {

            double min = INF;
            int index = 0;

            for (int i = 0; i < stars.size(); i++) {

                for (double[] star : set) {
                    double x = Math.pow(stars.get(i)[0] - star[0], 2);
                    double y = Math.pow(stars.get(i)[1] - star[1], 2);

                    double d = Math.sqrt(x + y);

                    if (d < min) {
                        min = d;
                        index = i;
                    }
                }
            }

            cost += min;
            set.add(stars.get(index));
            stars.remove(index);

        }


        System.out.println(String.format("%.2f", cost));

    }

    static double INF = Math.sqrt(8000000);

}
