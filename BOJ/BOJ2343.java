package BOJ;

/**
기타 레슨
*/

import java.io.*;
import java.util.*;

public class BOJ2343 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        lecture = new int[N];

        int left = 0;
        int right = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            lecture[i] = Integer.parseInt(st.nextToken());
            left = Math.max(left, lecture[i]);
            right += lecture[i];
        }

        while (left <= right) {
            int mid = (left + right) / 2;

            if (isPossible(mid)) {
                answer = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        System.out.println(answer);

    }

    static int N, M, answer;
    static int[] lecture;

    static boolean isPossible(int size) {

        int section = lecture[0];
        int cnt = 1;
        for (int i = 1; i < N; i++) {
            if (section + lecture[i] > size) {
                cnt++;
                if (cnt > M) {
                    return false;
                }
                section = lecture[i];
            } else {
                section += lecture[i];
            }
        }

        return true;
    }

}