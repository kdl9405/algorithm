package gooorm;

import java.io.*;
import java.util.*;

/* 
    평행선

    // 두개의 그룹으로 나눔
    // 두 그룹의 직선 여부 확인
    // 두 그룹의 교차 여부 확인
    // 두 그룹의 직선이 동일성 확인
*/
public class g4 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int[] point = new int[n];

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                point[i] = Integer.parseInt(st.nextToken());

            }
        }
    }

    static boolean check(int[] p) {

        for (int i = 0; i < p.length - 1; i++) {
            for (int j = i + 1; j < p.length; j++) {
                double s = (j - i) / (double) (p[j] - p[i]);

                for (int a = 0; a < p.length; a++) {
                    if (a != i && a != j) {
                        boolean check = true;

                        for (int b = 0; b < p.length; b++) {
                            if (a != b && b != i && b != j) {
                                double ss = (b - a) / (double) (p[b] - p[a]);
                                if (s != ss) {
                                    check = false;
                                    br
                                }

                            }
                        }

                        break;
                    }
                }
            }
        }

        return false;
    }
}
