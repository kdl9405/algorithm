package BOJ;

import java.io.*;
import java.util.*;

/*  
    DSLR 

    4172ms
*/
public class BOJ9019_copy {

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

        String process = "";

        Queue<DSLR> queue = new LinkedList<>();
        queue.add(new DSLR(a, new StringBuilder()));
        boolean[] visit = new boolean[10000];
        visit[a] = true;

        while (!queue.isEmpty()) {
            DSLR now = queue.poll();

            if (now.num == b) {
                process = now.process.toString();
                break;
            }

            int x = now.num * 2;
            if (x > 9999) {
                x %= 10000;
            }
            if (!visit[x]) {
                visit[x] = true;
                queue.add(new DSLR(x, new StringBuilder().append(now.process).append("D")));
            }

            x = now.num - 1;
            if (x == -1) {
                x = 9999;
            }
            if (!visit[x]) {
                visit[x] = true;
                queue.add(new DSLR(x, new StringBuilder().append(now.process).append("S")));
            }

            x = now.num % 1000;
            x *= 10;
            x += now.num / 1000;
            if (!visit[x]) {
                visit[x] = true;
                queue.add(new DSLR(x, new StringBuilder().append(now.process).append("L")));
            }

            x = now.num / 10;
            x += ((now.num % 10) * 1000);
            if (!visit[x]) {
                visit[x] = true;
                queue.add(new DSLR(x, new StringBuilder().append(now.process).append("R")));
            }
        }

        return process;

    }
}

class DSLR {
    int num;
    StringBuilder process;

    public DSLR(int num, StringBuilder process) {
        this.num = num;
        this.process = process;
    }
}
