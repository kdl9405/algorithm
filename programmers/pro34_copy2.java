package programmers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class pro34_copy2 {

    public static void main(String[] args) {
        String[][] tickets = { {"ICN","A"},{"A","B"},{"B","A"},{"A","ICN"},{"ICN","A"} };

        String[] course = solution(tickets);

        for(int i = 0; i<course.length; i++){
            System.out.print(course[i]+" ");
        }
    }

    static Map<String, List<Ticket>> ticketMap = new HashMap<>();
    static Map<String, Boolean> visited = new HashMap<>();
    static String[] answer;
    static String[] A;
    static boolean isSolved = false;

    public static String[] solution(String[][] tickets) {

        for (String[] s : tickets) {
            List<Ticket> nextList = ticketMap.getOrDefault(s[0], new ArrayList<>());
            nextList.add(new Ticket(s[1], false));
            ticketMap.put(s[0], nextList);
        }

        for (String key : ticketMap.keySet()) {
            List<Ticket> nextList = ticketMap.get(key);
            Collections.sort(nextList);
        }
        answer = new String[tickets.length + 1];
        answer[0] = "ICN";

        A = new String[tickets.length + 1];
        A[0] = "ICN";

        dfs(answer[0], 1);
        return A;
    }

    static void dfs(String current, int index) {
        if (index == answer.length) {

            for(int i = 0; i<index; i++){
                A[i] = answer[i];
            }
            isSolved = true;
            return;
        }

        List<Ticket> nextList = ticketMap.get(current);
        for (Ticket ticket : nextList) {
            if (!ticket.isUsed) {
                ticket.isUsed = true;
                answer[index] = ticket.next;
                dfs(ticket.next, index+1);
                if (isSolved) {
                    return;
                }
                ticket.isUsed = false;
            }
        }
    }
}

class Ticket implements Comparable<Ticket> {
    String next;
    boolean isUsed;

    public Ticket(String next, boolean isUsed) {
        this.next = next;
        this.isUsed = isUsed;
    }

    @Override
    public int compareTo(Ticket o) {
        return this.next.compareTo(o.next);
    }

}