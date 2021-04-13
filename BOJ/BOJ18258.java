import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * BOJ18258
 */
public class BOJ18258 {

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        Queue<Integer> queue = new LinkedList<>();

        int n = Integer.parseInt(br.readLine());
        int last = 0;

        while (n-- > 0) {
            st = new StringTokenizer(br.readLine());

            switch (st.nextToken()) {
                case "push":
                    last = Integer.parseInt(st.nextToken());
                    queue.offer(last);
                    break;
                case "pop":
                    if (queue.isEmpty()) {
                        sb.append("-1" + "\n");
                    } else {
                        sb.append(queue.poll() + "\n");
                    }
                    break;
                case "size":
                    sb.append(queue.size() + "\n");
                    break;
                case "empty":
                    if (queue.isEmpty()) {
                        sb.append("1" + "\n");
                    } else {
                        sb.append("0" + "\n");
                    }
                    break;
                case "front":
                    if (queue.isEmpty()) {
                        sb.append("-1" + "\n");
                    } else {
                        sb.append(queue.peek() + "\n");
                    }
                    break;
                case "back":
                    if (queue.isEmpty()) {
                        sb.append("-1" + "\n");
                    } else {
                        sb.append(last + "\n");
                    }
                    break;
            }
        }

        System.out.println(sb);
    }
}