package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

/*
 * 선물
 */

public class BOJ1166 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        long N = Long.parseLong(st.nextToken());
        long L = Long.parseLong(st.nextToken());
        long W = Long.parseLong(st.nextToken());
        long H = Long.parseLong(st.nextToken());

        double min = 0;
        double max = Math.max(Math.max(L, W), H);

        HashMap<Double, Integer> duplicate = new HashMap<>();

        while (min <= max) {

            double mid = (min + max) / 2;

            if (duplicate.containsKey(mid) && duplicate.get(mid) >= 2) {
                System.out.println(mid);
                break;
            }
            duplicate.put(mid, duplicate.getOrDefault(mid, 0) + 1);

            // System.out.println(mid + " " + min + " " + max);

            if ((long) (L / mid) * (long) (W / mid) * (long) (H / mid) >= N) {
                min = mid;
            } else {
                max = mid;
            }
        }

        // System.out.println(max);

    }
}
