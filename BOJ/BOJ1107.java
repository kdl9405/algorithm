package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 리모컨
 */
public class BOJ1107 {

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int m = Integer.parseInt(br.readLine());

        num = new boolean[10];
        if (m != 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            while (m-- > 0) {
                num[Integer.parseInt(st.nextToken())] = true;
            }
        }


        int count = Math.abs(n - 100);

        if (!num[0]) {
            count = Math.min(count, n + 1);
        }

        if (possible(Integer.toString(n))) {
            count = Math.min(count, Integer.toString(n).length());
        } else {

            int target = n;
            // up
            while (true) {
                target++;

                if (Integer.toString(target).length() + (target - n) >= count) {
                    break;
                }

                if (possible(Integer.toString(target))) {
                    count = Integer.toString(target).length() + (target - n);
                    break;
                }
            }

            System.out.println("2222222222  " + target + " " + count);

            target = n;
            // down
            while (true) {
                target--;

                if (target <= 0) {
                    break;
                }

                if (Integer.toString(target).length() + (n - target) >= count) {
                    break;
                }

                if (possible(Integer.toString(target))) {
                    count = Integer.toString(target).length() + (n - target);
                    break;
                }
            }


            System.out.println("33333333333  " + target + " " + count);

        }

        System.out.println(count);

    }

    static boolean[] num;

    static boolean possible(String n) {

        for (int i = 0; i < n.length(); i++) {
            if (num[Integer.parseInt(Character.toString(n.charAt(i)))]) {
                return false;
            }
        }

        return true;
    }
}
