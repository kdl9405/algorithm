package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

/* 
    폰 호석만
*/
public class BOJ21275 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        String num1 = st.nextToken();
        String num2 = st.nextToken();

        String max = Long.toString(Long.MAX_VALUE);
        if (num1.length() > max.length() || (num1.length() == max.length() && num1.compareTo(max) > 0)) {
            System.out.println("Impossible");
            return;
        }

        if (num2.length() > max.length() || (num2.length() == max.length() && num2.compareTo(max) > 0)) {
            System.out.println("Impossible");
            return;
        }
        int minA = 2;
        int minB = 2;

        for (char c : num1.toCharArray()) {
            if (Character.isLowerCase(c)) {
                minA = Math.max(minA, c - 'a' + 11);
            } else {
                minA = Math.max(minA, c - '0' + 1);
            }
        }

        for (char c : num2.toCharArray()) {
            if (Character.isLowerCase(c)) {
                minB = Math.max(minB, c - 'a' + 11);
            } else {
                minB = Math.max(minB, c - '0' + 1);
            }
        }

        HashSet<Long[]> X = new HashSet<>();

        for (int i = minA; i <= 36; i++) {

            for (int j = minB; j <= 36; j++) {

                long a = Long.parseLong(num1, i);
                long b = Long.parseLong(num2, j);

                if (a == b && i != j) {
                    X.add(new Long[] { a, (long) i, (long) j });
                }
            }
        }

        if (X.isEmpty()) {
            System.out.println("Impossible");
        } else if (X.size() > 1) {
            System.out.println("Multiple");
        } else {
            for (Long[] x : X) {
                System.out.println(x[0] + " " + x[1] + " " + x[2]);
            }
        }

    }

}
