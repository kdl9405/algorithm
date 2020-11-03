import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class pro34 {

    static String[] city;
    static String[] arr;
    static boolean[] visit;


    // 여행경로    프로그래머스에서 계속 null값만 반환됨..........
    public static void main(String[] args) {

        String[][] tickets = { {"ICN", "JFK"}, {"HND", "IAD"}, {"JFK", "HND"} };

        String[] course = solution(tickets);

        for(int i = 0; i<course.length; i++){
            System.out.print(course[i]+" ");
        }
    }

    static String[] solution(String[][] tickets) {
        String[] answer = new String[tickets.length+1];

        city = new String[tickets.length+1];
        arr = new String[tickets.length+1];
        visit = new boolean[tickets.length];

        arr[0] = "ICN";
        dfs("ICN", 1, tickets);

        List<String> temp = new ArrayList<>();

        for(String s : city){
            temp.add(s);
        }

        for(int i = 0; i<answer.length; i++){
            answer[i] = temp.get(i);
        }

        return answer;
    }

    static void dfs(String start, int depth, String[][] tickets){
        if (depth > tickets.length) {
            if (city[0] == null) {
                city = arr.clone();
            }else{

                String[] temp = new String[2];

                for(int i = 1; i<arr.length; i++){
                    temp[0] = city[i];
                    temp[1] = arr[i];
                    Arrays.sort(temp);

                    if (temp[0] == arr[i]) {
                        city = arr.clone();
                        break;
                    }
                }
            }
            return;
        }

        for(int i = 0; i<tickets.length; i++){
            if (!visit[i] && tickets[i][0] == start) {
                visit[i] = true;
                arr[depth] = tickets[i][1];
                dfs(tickets[i][1], depth+1, tickets);
                visit[i] = false;
            }
        }

    }
}
