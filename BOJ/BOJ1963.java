package BOJ;

import java.io.*;
import java.util.*;

/* 
    소수 경로


    좋진 않음....  리팩토링 필요.
*/
public class BOJ1963 {

    public static void main(String[] args) throws NumberFormatException, IOException {

        new BOJ1963().solution();
    }

    private void solution() throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder answer = new StringBuilder();

        findPrimeNumber();

        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());
            String A = st.nextToken();
            String B = st.nextToken();

            answer.append(findCount(A, B)).append("\n");
        }

        System.out.println(answer.toString().trim());
    }

    List<String> primeNumber;

    void findPrimeNumber() {

        boolean[] number = new boolean[10000];
        for (int i = 2; i <= 9999; i++) {
            if (number[i]) {
                continue;
            }
            for (int j = 2; i * j <= 9999; j++) {
                number[i * j] = true;
            }
        }

        primeNumber = new ArrayList<>();
        for (int i = 1000; i <= 9999; i++) {
            if (!number[i]) {
                primeNumber.add(Integer.toString(i));
            }
        }
    }

    int findCount(String A, String B) {

        boolean[] visit = new boolean[primeNumber.size()];
        Queue<String> queue = new LinkedList<>();
        queue.add(A);

        int count = 0;
        while (!queue.isEmpty()) {

            int size = queue.size();

            while (size-- > 0) {
                String a = queue.poll();

                if (a.equals(B)) {
                    return count;
                }

                for (int i = 0; i < primeNumber.size(); i++) {
                    if (visit[i]) {
                        continue;
                    }

                    int dif = 0;
                    for (int j = 0; j < 4; j++) {
                        if (a.charAt(j) != primeNumber.get(i).charAt(j)) {
                            dif++;
                        }
                    }

                    if (dif == 1) {
                        visit[i] = true;
                        queue.add(primeNumber.get(i));
                    }
                }
            }
            count++;
        }

        return -1;
    }

}
