package boj;

import java.io.*;
import java.util.*;

/*
 * 행성 터널
 */

public class BOJ2887_copy {

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        int[][] arr = new int[n][4];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = i;
            arr[i][1] = Integer.parseInt(st.nextToken());
            arr[i][2] = Integer.parseInt(st.nextToken());
            arr[i][3] = Integer.parseInt(st.nextToken());
        }

        List<int[]> distance = new ArrayList<>();

        Arrays.sort(arr, (a, b) -> {
            return a[1] - b[1];
        });

        for (int i = 0; i < n - 1; i++) {
            distance.add(new int[] {arr[i][0], arr[i + 1][0], Math.abs(arr[i][1] - arr[i + 1][1])});
        }

        Arrays.sort(arr, (a, b) -> {
            return a[2] - b[2];
        });

        for (int i = 0; i < n - 1; i++) {
            distance.add(new int[] {arr[i][0], arr[i + 1][0], Math.abs(arr[i][2] - arr[i + 1][2])});
        }

        Arrays.sort(arr, (a, b) -> {
            return a[3] - b[3];
        });

        for (int i = 0; i < n - 1; i++) {
            distance.add(new int[] {arr[i][0], arr[i + 1][0], Math.abs(arr[i][3] - arr[i + 1][3])});
        }

        Collections.sort(distance, (a, b) -> {
            return Long.compare(a[2], b[2]);
        });

        group = new int[n + 1];
        Arrays.fill(group, -1);

        long sum = 0;
        int count = 0;
        for (int[] d : distance) {

            int a = findGroup(d[0]);
            int b = findGroup(d[1]);

            if (a != b) {
                group[b] = a;
                sum += d[2];
                count++;
                if (count == n - 1) {
                    break;
                }
            }
        }

        System.out.println(sum);
    }

    static int[] group;

    static int findGroup(int x) {

        if (group[x] == -1) {
            return group[x] = x;
        }
        if (group[x] == x) {
            return x;
        }

        return group[x] = findGroup(group[x]);
    }
}
