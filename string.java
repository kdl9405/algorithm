
import java.util.*;

public class string {

    public static void main(String[] args) {

        int textLength = 5;

        List<Integer> starting = new ArrayList<>();
        starting.add(3);
        starting.add(4);
        starting.add(5);
        starting.add(6);
        starting.add(8);

        List<Integer> ending = new ArrayList<>();
        ending.add(4);
        ending.add(5);
        ending.add(6);
        ending.add(7);
        ending.add(8);

        System.out.println(paperCuttings(textLength, starting, ending));

    }

    public static long paperCuttings(int textLength, List<Integer> starting, List<Integer> ending) {

        HashSet<String> set = new HashSet<>();

        for (int i = 0; i < starting.size(); i++) {
            set.add(starting.get(i) + " " + ending.get(i));
        }

        int[][] portions = new int[set.size()][2];
        int i = 0;
        for(String s : set){
            String[] str = s.split(" ");
            portions[i][0] = Integer.parseInt(str[0]);
            portions[i][1] = Integer.parseInt(str[1]);

            i++;
        }

        Arrays.sort(portions, (a, b) -> {

            if (a[0] == b[0]) {
                return a[1] - b[1];
            }

            return a[0] - b[0];
        });

        for (i = 0; i < portions.length; i++) {
            System.out.println(portions[i][0] + " " + portions[i][1]);
        }

        ending.sort((a, b) -> {
            return a - b;
        });

        long answer = 0;

        for (i = 0; i < portions.length; i++) {

            System.out.println(portions[i][0] + " ~ " + portions[i][1]);

            if (i < portions.length - 1) {
                // 이분탐색

                int min = i;
                int max = portions.length - 1;

                int index = portions.length;

                while (min <= max) {
                    int mid = (min + max) / 2;

                    if (portions[mid][0] > portions[i][1]) {
                        index = mid;
                        max = mid - 1;
                    } else {
                        min = mid + 1;
                    }
                }

                answer += (portions.length - index);

                System.out.println(portions.length - index);

            }
        }

        return answer;

    }

}
