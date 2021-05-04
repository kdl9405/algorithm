package BOJ;

import java.io.*;
import java.util.*;

/* 
    숨바꼭질 4

    시간초과
*/
public class BOJ13913_copy {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        boolean[] visit = new boolean[100001];
        visit[N] = true;

        Queue<root> queue = new LinkedList<>();
        queue.add(new root(N, new StringBuilder()));

        int count = 0;

        loop:
        while (true) {            
            int size = queue.size();

            while (size-- > 0) {
                
                root n = queue.poll();

                StringBuilder sb = new StringBuilder();
                sb.append(n.before+""+n.now+" ");

                if (n.now == K) {
                    System.out.println(count+"\n"+sb.toString());
                    break loop;
                }

                int[] next = {n.now-1,n.now+1,n.now*2};

                for(int x : next){
                    if (x <= 100000 && !visit[x]) {                        
                        visit[x] = true;
                        queue.add(new root(x,sb));
                    }
                }                
            }

            count++;
        }
    }
}

class root{

    int now;
    StringBuilder before;

    public root(int now, StringBuilder before){
        this.now = now;
        this.before = before; 
    }
}
