package BOJ;

import java.io.*;
import java.util.*;

/*  
    DSLR 

    2016ms
*/
public class BOJ9019 {

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {

            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            sb.append(BFS(a, b)+"\n");
        }

        System.out.println(sb.toString());
    }

    static String BFS(int a, int b) {

        int[] parent = new int[10000];
        Arrays.fill(parent, -1);
        char[] process = new char[10000];

        Queue<Integer> queue = new LinkedList<>();
        queue.add(a);

        while (!queue.isEmpty()) {
            int now = queue.poll();

                if (parent[b] != -1) {
                    break;
                }

            int x = now * 2;
            if (x > 9999) {
                x %= 10000;
            }
            if (parent[x] == -1) {
                parent[x] = now;
                process[x] = 'D';
                queue.add(x);
            }

            x = now - 1;
            if (x == -1) {
                x = 9999;
            }
            if (parent[x] == -1) {
                parent[x] = now;
                process[x] = 'S';
                queue.add(x);
            }

            x = now % 1000;
            x *= 10;
            x += now / 1000;
            if (parent[x] == -1) {
                parent[x] = now;
                process[x] = 'L';
                queue.add(x);
            }

            x = now / 10;
            x += ((now % 10) * 1000);
            if (parent[x] == -1) {
                parent[x] = now;
                process[x] = 'R';
                queue.add(x);
            }
        }

        StringBuilder sb = new StringBuilder();
        
        while (b != a) {

            sb.append(process[b]); 
            b = parent[b];
        }


        return sb.reverse().toString();

    }
}
