package boj;

import java.io.*;
import java.util.*;

/*
 * 회전 초밥
 * 
 * 1060ms
 */
public class BOJ15961_copy {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int[] plate = new int[n];
        HashMap<Integer, Integer> choice = new HashMap<>();
        for (int i = 0; i < n - (k - 1); i++) {
            plate[i] = Integer.parseInt(br.readLine());
        }
        choice.put(plate[0], 1);

        for (int i = n - (k - 1); i < n; i++) {
            plate[i] = Integer.parseInt(br.readLine());
            choice.put(plate[i], choice.getOrDefault(plate[i], 0) + 1);
        }

        int l = n - (k - 1);
        int r = 0;

        int count = choice.size();

        while (r < n) {

            if (choice.size() >= count) {
                count = choice.size();
                if (!choice.containsKey(c)) {
                    count++;
                    if (count == k + 1) {
                        break;
                    }
                }
            }

            if (choice.get(plate[l]) == 1) {
                choice.remove(plate[l]);
            } else {
                choice.put(plate[l], choice.get(plate[l]) - 1);
            }

            l++;
            if (l == n) {
                l = 0;
            }
            r++;
            if (r == n) {
                break;
            }
            choice.put(plate[r], choice.getOrDefault(plate[r], 0) + 1);
        }

        System.out.println(count);

    }
}
