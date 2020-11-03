import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class BJ5430 {

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            String oper = br.readLine();

            int n = Integer.parseInt(br.readLine());
            List<String> list = new ArrayList<>();

            String s = br.readLine();

            s = s.substring(1, s.length() - 1);

            String[] str = s.split(",");

            Deque<String> deque = new LinkedList<>();

            for (int i = 0; i < n; i++) {
                deque.offer(str[i]);
            }
            boolean reverse = false;
            boolean error = false;

            loop: for (int i = 0; i < oper.length(); i++) {

                switch (oper.charAt(i)) {
                    case 'R':
                        reverse = !reverse;
                        break;
                    case 'D':
                        if (deque.isEmpty()) {
                            error = true;
                            break loop;
                        } else {
                            if (!reverse) {
                                deque.pollFirst();
                            } else {
                                deque.pollLast();
                            }
                        }
                        break;
                }
            }

            if (error) {
                sb.append("error" + "\n");
            } else {

                if (reverse) {
                    while (!deque.isEmpty()) {
                        list.add(deque.pollLast());
                    }
                } else {
                    while (!deque.isEmpty()) {
                        list.add(deque.pollFirst());
                    }
                }
                if (list.isEmpty()) {
                    sb.append("[]" + "\n");
                } else {
                    sb.append("[");
                    for (int i = 0; i < list.size(); i++) {
                        sb.append(list.get(i) + ",");
                    }
                    sb.deleteCharAt(sb.length() - 1);
                    sb.append("]" + "\n");
                }

            }

        }

        System.out.println(sb);
    }
}
