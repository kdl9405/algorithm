import java.util.*;

/**
 * [3차] 압축
 * 
 */
public class pro75 {

    public static void main(String[] args) {

        String msg = "K";

        int[] ans = solution(msg);

        for (int i : ans) {
            System.out.print(i + " ");
        }

    }

    static int[] solution(String msg) {
        int[] answer;

        HashMap<String, Integer> map = new HashMap<>();
        List<Integer> list = new LinkedList<>();

        for (int i = 0; i < 26; i++) {
            char c = (char) ('A' + i);
            map.put(String.valueOf(c), i + 1);
        }

        int i = 0;
        int index = 27;
        String w = ""+msg.charAt(0);
        String c = "";

        while (i < msg.length()) {

            if (i == msg.length() - 1) {
                if (w.length() == 1) {
                    list.add(map.get(Character.toString(msg.charAt(i))));
                }
                break;
            }

            c = "";

            while (true) {
                c += msg.charAt(++i);
                if (!map.containsKey(w + c)) {
                    map.put(w + c, index++);
                    break;
                }
                w = w + c;
                c = "";

                if (i == msg.length() - 1) {
                    break;
                }
            }

            list.add(map.get(w));
            w = c;

        }

        answer = new int[list.size()];

        for (int j = 0; j < list.size(); j++) {
            answer[j] = list.get(j);
        }

        return answer;
    }
}