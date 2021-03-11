import java.util.*;

public class pro34_copy {

    // 여행경로
    public static void main(String[] args) {

        String[][] tickets = { { "ICN", "SFO" }, { "ICN", "ATL" }, { "SFO", "ATL" }, { "ATL", "ICN" },
                { "ATL", "SFO" } };

        String[] course = solution(tickets);

        for (String s : course) {
            System.out.print(s+" ");
        }

    }

    static boolean[] visit;
    static ArrayList<String> answers;

    static String[] solution(String[][] tickets) {

        visit = new boolean[tickets.length];
        answers = new ArrayList<String>();

        int count = 0;
        dfs(count, "ICN", "ICN", tickets);


        Collections.sort(answers);


        String[] answer = answers.get(0).split(" ");

        return answer;        
    }

    static void dfs(int count, String start, String answer ,String[][] tickets) {
        if (count == tickets.length) {
            answers.add(answer);
            return;
        }
        for(int i = 0; i<tickets.length; i++){
            if (!visit[i] && start.equals(tickets[i][0])) {
                visit[i] = true;
                dfs(count+1, tickets[i][1], answer +" "+tickets[i][1], tickets);
                visit[i] = false;
            }
        }
    }
}
