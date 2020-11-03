import java.util.HashSet;

/**
 * Solution
 */
class bannedUser {

    // 모든 케이스를 담는다.
    static HashSet<HashSet> hashSet = new HashSet<>();

    // 해당하는 케이스를 담는다.
    static HashSet<String> resultPool = new HashSet<>();

    static int userIdSize;
    static int bannedIdSize;

    public static void main(String[] args) {
        String[] user_id = { "frodo", "fradi", "crodo", "abc123", "frodoc" };
        String[] banned_id = { "*rodo", "*rodo", "******" };
        solution(user_id, banned_id);
    }

    static int solution(String[] user_id, String[] banned_id) {
        int answer = 0;
        boolean[] visited = new boolean[user_id.length];

        userIdSize = user_id.length;
        bannedIdSize = banned_id.length;

        for (int i = 0; i < bannedIdSize; i++) {
            banned_id[i] = banned_id[i].replaceAll("\\*", ".");
        }
        dfs(user_id, banned_id, visited, 0);

        answer = hashSet.size();
        return answer;
    }

    static void dfs(String[] user_id, String[] banned_id, boolean[] visited, int index) {
        if (resultPool.size() == bannedIdSize) {
            
            hashSet.add(resultPool);
            resultPool.clear();
            return;
        }

        for (int i = index; i < bannedIdSize; i++) {
            for (int j = 0; j < userIdSize; j++) {
                if (user_id[j].length() == banned_id[i].length()) {
                    for (int k = 0; k < user_id[j].length(); k++) {
                        if (!user_id[j].matches(banned_id[i])) {
                            return;
                        }
                    }
                    if (!visited[j]) {
                        visited[j] = true;
                        resultPool.add(user_id[j]);
                        System.out.println(user_id[j]);
                        dfs(user_id, banned_id, visited, index + 1);
                        resultPool.remove(user_id[j]);
                        visited[j] = false;
                    }
                }
            }
        }
        return;
    }
}