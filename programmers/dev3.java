import java.util.Arrays;

public class dev3 {

    public static void main(String[] args) {
        int[][] groups = { {1,6 }, { 1, 4 }, { 2, 5 },{4,8} };
        int n = 10;

        System.out.println(solution(n, groups));
    }

    static int solution(int n, int[][] groups) {
        int answer = 0;

        Arrays.sort(groups, (g1, g2) -> {
            if (g1[0] == g2[0]) {
                return g2[1] - g1[1];
            }
            return g1[0] - g2[0];
        });

        int light = 0;
       
        for(int i = 0; i<groups.length; i++){
            int from = groups[i][0];
            int to = groups[i][1];
            answer++;

            if (i+1 < groups.length) {
                int temp = 0;
                for(int j = i+1; j<groups.length; j++){
                    if (groups[j][0] == from) {
                        continue;
                    }
                    if (groups[j][0] < to) {
                        temp = Math.max(temp, groups[j][1]);
                        i = j;
                    }
                }

                if (temp != 0) {
                    to = temp;
                    answer ++;
                }
            }
            light += (to -from +1);
        }

        System.out.println(light + " " + answer);

        answer += (n - light);

        return answer;
    }
}
