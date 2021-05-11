package BOJ;

import java.io.*;
import java.util.*;

/* 
    마인크래프트
*/

public class BOJ18111 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        HashMap<Integer, Integer> map = new HashMap<>();

        int total = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                int h = Integer.parseInt(st.nextToken());
                map.put(h, map.getOrDefault(h, 0) + 1);

                total += h;
            }
        }


        int h = 0;
        int min = total * 2;
        int inven = B + total;

        
        int checkd = 0;
        if (map.containsKey(0)) {
            checkd = map.get(0);
        }

        int temp = min;

        for (int i = 1; i <=256; i++) {

            int count = N*M-checkd;

            // System.out.println(count);

            // 제거했던 행위 취소
            inven -= (count);
            temp -= (count * 2);

            // 모자른 부분 추가
            inven -= (checkd);
            temp += (checkd);

            if (map.containsKey(i)) {
                checkd+=map.get(i);
            }

            if (inven < 0) {
                break;
            }

            if (temp <= min) {
                min = temp;
                h = i;
            }

            // System.out.println(height[i]  +" "+ temp );
        }

        System.out.println(min + " " + h);
    }
}
