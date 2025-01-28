package boj;

/*
 * 부등호
 */

import java.io.*;
import java.util.*;

public class BOJ2529 {

    public static void main(String[] args) throws NumberFormatException, IOException {

        new BOJ2529().solution();

    }

    int k;
    String[] arr;
    int[] num;
    List<String> result;

    private void solution() throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        k = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        arr = new String[k];
        for (int i = 0; i < k; i++) {
            arr[i] = st.nextToken();
        }

        num = new int[k + 1];
        result = new ArrayList<>();

        backTracking(0, 0);

        System.out.println(result.get(result.size() - 1) + "\n" + result.get(0));

    }

    private void backTracking(int index, int bit) {
        if (index > k) {

            StringBuilder number = new StringBuilder();
            for (int i = 0; i <= k; i++) {
                number.append(num[i]);
            }
            result.add(number.toString());
            return;
        }

        if (index == 0) {
            for (int i = 0; i <= 9; i++) {
                num[0] = i;
                backTracking(1, bit ^ (1 << i));
            }
        } else {

            if (arr[index - 1].equals("<")) {
                for (int i = num[index - 1] + 1; i <= 9; i++) {
                    if ((bit | (1 << i)) == bit) {
                        continue;
                    }
                    num[index] = i;
                    backTracking(index + 1, bit ^ (1 << i));
                }
            } else {
                for (int i = 0; i < num[index - 1]; i++) {
                    if ((bit | (1 << i)) == bit) {
                        continue;
                    }
                    num[index] = i;
                    backTracking(index + 1, bit ^ (1 << i));
                }
            }

        }

    }

}
