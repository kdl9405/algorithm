package Line;

import java.io.*;
import java.util.*;

/* 
    코니 브라운 술래잡기
*/
public class practice {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int c = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        int time = 0;

        if (c != b) {

            int v = 1;
            Queue<Integer> brown = new LinkedList<>();
            brown.add(b);

            while (true) {

                time++;
                c += v;
                v++;

                if (c > 200000) {
                    time = -1;
                    break;
                }

                HashSet<Integer> temp = new HashSet<>();

                while (!brown.isEmpty()) {
                    int now = brown.poll();
                    if (now > 0) {
                        temp.add(now - 1);
                    }
                    if (now < 200000) {
                        temp.add(now + 1);
                    }
                    if (now * 2 <= 200000) {
                        temp.add(now * 2);
                    }
                }

                if (temp.contains(c)) {
                    break;
                }

                brown.addAll(temp);

            }
        }

        System.out.println(time);

    }

}
