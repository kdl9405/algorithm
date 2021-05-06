package programmers;

import java.util.*;

/**
 * 불량 사용자
 * 
 */
public class pro110_copy {

    public static void main(String[] args) {
        String[] user_id = { "frodo", "fradi", "crodo", "abc123", "frodoc" };
        String[] banned_id = { "fr.d.", "abc1**" };

        System.out.println(solution(user_id, banned_id));
    }

    static boolean[] visit;
    static HashSet<String> set;
    static int size;
    static String[] arr;

    public static int solution(String[] user_id, String[] banned_id) {

        size = banned_id.length;

        for (int i = 0; i < size; i++) {
            banned_id[i] = banned_id[i].replaceAll("*", "\\.");    
        }

        visit = new boolean[user_id.length];

        set = new HashSet<>();

        arr = new String[size];

     //   dfs(0, user_id, banned_id);

        System.out.println(set);

        return set.size();
    }

    static void dfs(int depth, String[] user_id, String[] banned_id) {
        if (depth == size) {

            String[] temp = arr.clone();
            Arrays.sort(temp);
            StringBuilder sb = new StringBuilder();
            for (String a : temp) {
                sb.append(a + " ");
            }

            set.add(sb.toString());
            return;
        }

        for (int i = 0; i < user_id.length; i++) {
            if (!visit[i] && user_id[i].matches(banned_id[depth])) {
                visit[i] = true;
                arr[depth] = user_id[i];
                dfs(depth + 1, user_id, banned_id);
                visit[i] = false;
            }
        }
    }

}