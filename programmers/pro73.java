import java.util.*;

/**
 * 후보키
 */
public class pro73 {

    public static void main(String[] args) {
        String[][] relation = { { "100", "ryan", "music", "2" }, { "200", "apeach", "math", "2" },
                { "300", "tube", "computer", "3" }, { "400", "con", "computer", "4" }, { "500", "muzi", "music", "3" },
                { "600", "apeach", "music", "2" } };
        System.out.println(solution(relation));
    }

    static int solution(String[][] relation) {
        int answer = 0;

        int col = relation[0].length;
        int low = relation.length;
        List<Integer> list = new LinkedList<>();
        r = relation.clone();

        for (int i = 0; i < col; i++) {
            HashSet<String> temp = new HashSet<>();
            boolean dup = false;
            for (int j = 0; j < low; j++) {
                if (temp.contains(relation[j][i])) {
                    dup = true;
                    break;
                }
                temp.add(relation[j][i]);
            }
            if (dup) {
                list.add(i);
            }
        }

        answer += col - list.size();

        for (int i = 2; i <= list.size(); i++) {
            visit = new boolean[list.size()];
            int[] arr = new int[i];

            dfs(0, 0, arr, list);

        }

        answer += hash.size();
        return answer;
    }

    static boolean[] visit;
    static HashSet<HashSet<Integer>> hash = new HashSet<>();
    static String[][] r;

    static void dfs(int x, int depth, int[] arr, List<Integer> list) {
        if (depth == arr.length) {
            HashSet<Integer> temp = new HashSet<>();
            for (int a : arr) {
                temp.add(a);
            }

            for (HashSet<Integer> h : hash) {
                if (temp.containsAll(h)) {
                    return;
                }
            }

            if (check(temp)) {
                hash.add(temp);
            }

            return;
        }

        for (int j = x; j < list.size(); j++) {
            if (!visit[j]) {
                visit[j] = true;
                arr[depth] = list.get(j);
                dfs(j + 1, depth + 1, arr, list);
                visit[j] = false;
            }
        }
    }

    static boolean check(HashSet<Integer> h) {

        HashSet<String> total = new HashSet<>();

        for (int i = 0; i < r.length; i++) {
            String temp = "";
            for (int j : h) {
                temp += r[i][j] + " ";
            }
            if (total.contains(temp)) {
                return false;
            } else {
                total.add(temp);
            }

        }
        return true;
    }
}