
import java.util.ArrayList;
import java.util.HashSet;

//소수 찾기
public class pro19_copy {

    static String[] str;
    static boolean[] visit;
    static StringBuilder sb = new StringBuilder();
    static ArrayList<Integer> arr = new ArrayList<>();
    static int[] arr2;
    static HashSet<Integer> hash = new HashSet<>(); 

    public static void main(String[] args) {

        String numbers = "7843";

        System.out.println("result = " + solution(numbers));
    }

    static int solution(String numbers) {
        int answer = 0;

        str = numbers.split("");

        visit = new boolean[str.length];

        arr2 = new int[2]; 
        dfs(0, 0, 2);

        // answer = hash.size();

        // System.out.println(sb);

        return answer;
    }

    public static void dfs(int x, int depth, int size) {

        if (depth == size) {
            for (int val : arr2) {
                sb.append(val);
            }
            System.out.println(sb);
            sb = new StringBuilder();
            // arr = new ArrayList<>();
            return;
        }

        for(int i=0; i<str.length; i++){

            if(!visit[i]){
                visit[i] = true;
                // arr.add(Integer.parseInt(str[i]));
                arr2[depth] = Integer.parseInt(str[i]);
                System.out.println(i +","+(depth+1)+","+size);
                dfs(i, depth + 1, size);
                visit[i] = false;
            }
        }
    }

}
