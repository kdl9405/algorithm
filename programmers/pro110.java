import java.util.HashSet;

/**
 * 불량 사용자
 * 
 */
public class pro110 {

    public static void main(String[] args) {
        String[] user_id = { "frodo", "fradi", "crodo", "abc123", "frodoc" };
        String[] banned_id = { "fr.d.", "abc1**" };

        System.out.println(solution(user_id, banned_id));
    }

    static int solution(String[] user_id, String[] banned_id) {
        int answer = 0;
        visit = new boolean[user_id.length];
        arr = new String[banned_id.length]; 

        for(int i = 0; i<banned_id.length; i++){
            banned_id[i] = banned_id[i].replace('*', '.');
        }

        set = new HashSet<>();
        dfs(0, banned_id.length, user_id, banned_id);

        answer = set.size();
        return answer;
    }

    static boolean[] visit;
    static String[] arr;
    static HashSet<HashSet<String>> set;

    static void dfs(int depth, int n, String[] user_id, String[] banned_id) {
        if (depth == n) {
            HashSet<String> temp = new HashSet<>();
            for(String s : arr){
                temp.add(s);
            }
            if (!set.contains(temp)) {
                set.add(temp);
            }
            return;
        }

        for (int i = 0; i < user_id.length; i++) {
            if (!visit[i] && user_id[i].matches(banned_id[depth])) {
                visit[i] = true;
                arr[depth] = user_id[i];
                dfs(depth + 1, n, user_id, banned_id);
                visit[i] = false;
            }
        }

    }
}