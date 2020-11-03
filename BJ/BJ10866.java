import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BJ10866 {

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        Deque<Integer> deque = new LinkedList<>();

        int n = Integer.parseInt(br.readLine());

        while (n-- > 0) {
            st = new StringTokenizer(br.readLine());

            switch (st.nextToken()) {
                case "push_front":
                    deque.addFirst(Integer.parseInt(st.nextToken()));
                    break;
                case "push_back":
                    deque.addLast(Integer.parseInt(st.nextToken()));
                    break;
                case "pop_front":
                    if (deque.isEmpty()) {
                        sb.append("-1" + "\n");
                    } else {
                        sb.append(deque.pollFirst() + "\n");
                    }
                    break;
                case "pop_back":
                    if (deque.isEmpty()) {
                        sb.append("-1" + "\n");
                    } else {
                        sb.append(deque.pollLast() + "\n");
                    }
                    break;
                case "size":
                    sb.append(deque.size() + "\n");
                    break;
                case "empty":
                    if (deque.isEmpty()) {
                        sb.append("1" + "\n");
                    } else {
                        sb.append("0" + "\n");
                    }
                    break;
                case "front":
                    if (deque.isEmpty()) {
                        sb.append("-1" + "\n");
                    } else {
                        sb.append(deque.peekFirst() + "\n");
                    }
                    break;
                case "back":
                    if (deque.isEmpty()) {
                        sb.append("-1" + "\n");
                    } else {
                        sb.append(deque.peekLast() + "\n");
                    }
                    break;
            }
        }

        System.out.println(sb);
    }
}
