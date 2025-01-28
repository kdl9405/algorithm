package boj;

/*
 * 멀티탭 스케줄링
 */

import java.io.*;
import java.util.*;

public class BOJ1700 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] tool = new int[K];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < K; i++) {
            tool[i] = Integer.parseInt(st.nextToken());
        }
        br.close();

        int change = 0;

        if (N == 1) {
            for (int i = 1; i < K; i++) {
                if (tool[i] != tool[i - 1]) {
                    change++;
                }
            }

        } else {
            HashSet<Integer> multitap = new HashSet<>();

            for (int i = 0; i < K; i++) {

                if (multitap.contains(tool[i])) {
                    continue;
                }

                if (multitap.size() < N) {
                    multitap.add(tool[i]);
                } else {
                    HashSet<Integer> temp = new HashSet<>(multitap);
                    for (int j = i + 1; j < K; j++) {
                        if (temp.contains(tool[j])) {
                            temp.remove(tool[j]);
                        }
                        if (temp.size() < 2) {
                            break;
                        }
                    }

                    multitap.remove(temp.iterator().next());
                    multitap.add(tool[i]);
                    change++;
                }
            }
        }

        System.out.println(change);

    }
}
