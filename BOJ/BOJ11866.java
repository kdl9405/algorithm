import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ11866 {

    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        Queue<Integer> queue = new LinkedList<>();

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        for(int i =1; i<=n; i++){
            queue.offer(i);
        }

        sb.append("<");

        while (queue.size()>0) {
            
            for(int i = 0; i<k-1; i++){
                queue.offer(queue.poll());
            }
            sb.append(queue.poll()+", ");

        }
        sb.delete(sb.length()-2, sb.length());
        sb.append(">");

        System.out.println(sb);
    }
    
}
