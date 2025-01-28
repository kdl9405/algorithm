package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
 * 감소하는 수
 * 
 * 1. 1자리부터 10자리까지 만들자.. 2. 자리수가 넘어갈때, 이전에 만들어놓은 것을 갖져와서 체크하고 뒤에 붙임. 3. 전체 인덱스가 N일때 멈추고 출력.
 */
public class BOJ1038 {

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        HashMap<Integer, List<Long>> num = new HashMap<>();
        num.put(1, new ArrayList<>());

        List<Long> total = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            num.get(1).add((long) i);
            total.add((long) i);
        }

        for (int i = 2; i <= 10; i++) {

            if (total.size() > N) {
                break;
            }

            num.put(i, new ArrayList<>());
            for (long b : num.get(i - 1)) {

                long x = (b / (int) Math.pow(10, i - 2)) + 1;
                if (x == 10) {
                    continue;
                }

                for (; x < 10; x++) {
                    long y = x * (int) Math.pow(10, i - 1) + b;
                    num.get(i).add(y);
                    total.add(y);
                }
            }
        }

        if (N > total.size() - 1) {
            System.out.println(-1);
        } else {
            Collections.sort(total);
            System.out.println(total.get(N));
        }

    }

}
