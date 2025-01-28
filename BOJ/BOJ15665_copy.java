package boj;

import java.io.*;
import java.util.*;

/*
 * N과 M (11)
 * 
 * 772ms
 */
public class BOJ15665_copy {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        HashSet<Integer> num = new HashSet<>();

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            num.add(Integer.parseInt(st.nextToken()));
        }

        int[] numbers = num.stream().mapToInt(i -> i).toArray();
        Arrays.sort(numbers);

        if (m == 1) {
            StringBuffer sf = new StringBuffer();
            for (int t : numbers) {
                sf.append(t).append("\n");
            }
            System.out.println(sf.toString().trim());
        } else {
            Queue<String> queue = new LinkedList<>();
            for (int i = 0; i < numbers.length; i++) {
                queue.add(numbers[i] + " ");
            }

            int size = 1;
            while (size < m) {

                LinkedHashSet<String> temp = new LinkedHashSet<>();
                while (!queue.isEmpty()) {
                    String s = queue.poll();

                    for (int x : numbers) {
                        temp.add(s + x + " ");
                    }
                }

                size++;

                if (size == m) {
                    StringBuffer sf = new StringBuffer();
                    for (String t : temp) {
                        sf.append(t).append("\n");
                    }
                    System.out.println(sf.toString().trim());
                    break;
                } else {
                    queue.addAll(temp);
                }
            }
        }

    }

}
