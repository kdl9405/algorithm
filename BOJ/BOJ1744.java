package BOJ;

import java.io.*;
import java.util.*;

/* 
    수 묶기
*/
public class BOJ1744 {

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        List<Integer> negative = new ArrayList<>();
        int[] zeroAndOne = new int[2];
        List<Integer> positive = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            int x = Integer.parseInt(br.readLine());

            if (x < 0) {
                negative.add(x);
            } else if (x > 1) {
                positive.add(x);
            } else {
                zeroAndOne[x]++;
            }
        }

        Collections.sort(negative);
        Collections.sort(positive, Collections.reverseOrder());

        long sum = 0;

        if (negative.size() > 1) {
            for (int i = 0; i <negative.size()-1; i+=2) {
                sum += (negative.get(i) * negative.get(i + 1));
            }
        }

        if (negative.size() % 2 == 1 && zeroAndOne[0] == 0) {
            sum += negative.get(negative.size() - 1);
        }

        if (positive.size() > 1) {
            for (int i = 0; i < positive.size()-1; i+=2) {
                System.out.println(positive.get(i)+ " "+positive.get(i+1));
                sum += (positive.get(i) * positive.get(i + 1));
            }
        }

        if (positive.size() % 2 == 1) {
            sum += positive.get(positive.size() - 1);
        }

        sum += zeroAndOne[1];

        System.out.println(sum);

    }
}
