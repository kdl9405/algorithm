import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

/**
 * pro84
 * //
 */
public class pro84 {

    public static void main(String[] args) {

        int[][] results = { { 4, 3 }, { 4, 2 }, { 3, 2 }, { 1, 2 }, { 2, 5 } };

        System.out.println(solution(5, results));

    }

    static int solution(int n, int[][] results) {
        int answer = 0;

        check(results);
        check(results);
        check(results);
        check(results);

        System.out.println(better);
        System.out.println(worse);

        for(int i =1;i<=n; i++){
            int count = 0;
            if (better.containsKey(i)) {
                count += better.get(i).size();
            }
            if (worse.containsKey(i)) {
                count += worse.get(i).size();
            }

            if (count == n-1) {
                answer++;
            }

        }               

        return answer;
    }

    static HashMap<Integer, HashSet<Integer>> better = new HashMap<>();
    static HashMap<Integer, HashSet<Integer>> worse = new HashMap<>();

    static void check (int[][] results){
        for(int[] r : results){
            if (better.containsKey(r[1])) {
                better.get(r[1]).add(r[0]);                
            }else{
               HashSet<Integer> temp = new HashSet<>();
               temp.add(r[0]);
               better.put(r[1], temp);
            }
            if (better.containsKey(r[0])) {
                better.get(r[1]).addAll(better.get(r[0]));
            }

            if (worse.containsKey(r[0])) {
                worse.get(r[0]).add(r[1]);
            }else{
                HashSet<Integer> temp = new HashSet<>();
                temp.add(r[1]);
                worse.put(r[0], temp);
            }
            if (worse.containsKey(r[1])) {
                worse.get(r[0]).addAll(worse.get(r[1]));
            }
        }
    }

   
    
}