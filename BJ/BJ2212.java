package BJ;

import java.io.*;
import java.util.*;

/* 
    센서 
*/
public class BJ2212 {
    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());

        HashSet<Integer> set = new HashSet<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        while (n-- > 0) {
            set.add(Integer.parseInt(st.nextToken()));
        }

        if (set.size() <= k) {
            System.out.println(0);
        } else {

            int[] arr = set.stream().mapToInt(i -> i).toArray();

            Arrays.sort(arr);

            List<Integer> gap = new ArrayList<>();

            for (int i = 1; i < arr.length; i++) {
                gap.add(arr[i] - arr[i - 1]);
            }

            Collections.sort(gap, Collections.reverseOrder());

            int sum = 0;

            for (int i = k - 1; i < gap.size(); i++) {
                sum += gap.get(i);
            }

            System.out.println(sum);

        }

    }
}
