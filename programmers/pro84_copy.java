import java.util.Arrays;
import java.util.HashMap;

/**
 * pro84
 * //시간초과
 */
public class pro84_copy {

    public static void main(String[] args) {

        int[][] results = { { 4, 3 }, { 4, 2 }, { 3, 2 }, { 1, 2 }, { 2, 5 } };

        System.out.println(solution(5, results));

    }

    static int solution(int n, int[][] results) {
        int answer = 0;

        // Arrays.sort(results, (r1, r2) -> {
        //     if (r1[0] == r2[0]) {
        //         return r1[1] - r2[1];
        //     }

        //     return r1[0] - r2[0];
        // });

        visit = new boolean[n];
        arr = new int[n + 1];
        re = results.clone();

        dfs(n, 0);

        answer = map.size();

        return answer;
    }

    static boolean[] visit;
    static int[] arr;
    static int[][] re;
    static HashMap<Integer, Integer> map = new HashMap<>();

    static void dfs(int n, int depth) {

        if (n == depth) {

            int[] rank = arr.clone();

            if (check(rank)) {
                if (map.size() == 0) {
                    for (int i = 1; i < rank.length; i++) {
                        map.put(i, rank[i]);
                    }
                }else{
                    for (int i = 1; i < rank.length; i++) {
                        if (map.containsKey(i) && map.get(i) != rank[i]) {
                            map.remove(i);
                        }
                    }
                }
                
            }

            return;
        }

        for (int i = 0; i < n; i++) {
            if (!visit[i]) {
                visit[i] = true;
                arr[i + 1] = depth + 1;
                dfs(n, depth + 1);
                visit[i] = false;
            }
        }
        return;
    }

    static boolean check(int[] rank) {

        for (int[] r : re) {
            if (rank[r[0]] > rank[r[1]]) {
                return false;
            }
        }

        return true;
    }
}