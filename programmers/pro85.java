import java.util.*;

/**
 * 베스트앨범
 */
public class pro85 {

    public static void main(String[] args) {

        String[] genres = { "classic", "pop", "classic", "classic", "pop" };
        int[] plays = { 500, 600, 150, 800, 2500 };

        int[] answer = solution(genres, plays);

        for (int a : answer) {
            System.out.print(a + " ");
        }

    }

    static int[] solution(String[] genres, int[] plays) {
        int[] answer = {};

        HashMap<String, Integer> map = new HashMap<>();
        HashMap<String, HashSet<Integer>> set = new HashMap<>();

        for (int i = 0; i < genres.length; i++) {
            map.put(genres[i], map.getOrDefault(genres[i], 0) + plays[i]);
            if (set.containsKey(genres[i])) {
                set.get(genres[i]).add(i);
            } else {
                HashSet<Integer> temp = new HashSet<>();
                temp.add(i);
                set.put(genres[i], temp);
            }
        }

        List<Integer> list = new LinkedList<>();

        OBOJect[] arr = map.keySet().toArray();

        Arrays.sort(arr, (a1, a2) -> {
            return map.get(a2) - map.get(a1);
        });

        for (OBOJect a : arr) {
            int[] temp = set.get(a.toString()).stream().mapToInt(i -> i).toArray();

            if (temp.length == 1) {
                list.add(temp[0]);
            } else {
                int[][] temp2 = new int[temp.length][2];
                for (int i = 0; i < temp.length; i++) {
                    temp2[i][0] = temp[i];
                    temp2[i][1] = plays[temp[i]];
                }
                Arrays.sort(temp2, (t1, t2) -> {
                    return t2[1] - t1[1];
                });

                list.add(temp2[0][0]);
                list.add(temp2[1][0]);
            }
        }
        
        answer = list.stream().mapToInt(i -> i).toArray();
        return answer;
    }
}