package BOJ;

/* 
    맥주 마시면서 걸어가기

*/

import java.io.*;
import java.util.*;

public class BOJ9205 {

    public static void main(String[] args) throws NumberFormatException, IOException {

        new BOJ9205().solution();
    }

    void solution() throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder answer = new StringBuilder();

        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {

            // input
            int n = Integer.parseInt(br.readLine());

            st = new StringTokenizer(br.readLine());
            int[] home = { Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()) };

            List<int[]> stores = new ArrayList<>();
            while (n-- > 0) {
                st = new StringTokenizer(br.readLine());
                stores.add(new int[] { Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()) });
            }

            st = new StringTokenizer(br.readLine());
            int[] festival = { Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()) };

            if (bfs(home, stores, festival)) {
                answer.append("happy\n");
            }else{
                answer.append("sad\n");
            }

        }

        System.out.println(answer.toString().trim());

    }

    boolean bfs(int[] home, List<int[]> stores, int[] festival) {

        int[] visit = new int[stores.size()];
        Arrays.fill(visit, -1);

        Queue<int[]> queue = new LinkedList<>();
        queue.add(home);

        while (!queue.isEmpty()) {
            int[] now = queue.poll();

            if (remaindBeer(now, festival) >= 0) {
                return true;
            }

            for (int i = 0; i < stores.size(); i++) {

                int b = remaindBeer(now, stores.get(i));

                if (visit[i] >= b) {
                    continue;
                }
                visit[i] = b;
                queue.add(new int[] { stores.get(i)[0], stores.get(i)[1] });
            }

        }

        return false;
    }

    int remaindBeer(int[] a, int[] b) {

        int distance = Math.abs(a[0] - b[0]) + Math.abs(a[1] - b[1]);
        int need = distance / 50;
        if (distance % 50 > 0) {
            need++;
        }

        return 20 - need;
    }

}
