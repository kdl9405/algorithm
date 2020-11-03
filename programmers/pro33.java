import java.util.ArrayList;
import java.util.List;

public class pro33 {

    // 단어변환

    static int min;
    static List<String> visit = new ArrayList<>();


    public static void main(String[] args) {

        String[] words = { "hot", "dot", "dog", "lot", "log", "cog" };

        System.out.println(solution("dot", "cog", words));

    }

    static int solution(String begin, String target, String[] words) {

        min = words.length-1;

        dfs(begin, target, words, 0);

        if (min == words.length-1) {
            return 0;
        }

        return min;
    }

    static void dfs(String word, String target, String[] words, int count) {

        System.out.println("word = "+word+"  count = "+ count);

        if (word.equals(target)) {
            min = Math.min(min, count);
            return;
        }

        visit.add(word);

        List<String> change = new ArrayList<>();        

        for(String w : words){
            int dif = 0;
            for(int i = 0; i<w.length(); i++){
                if (word.charAt(i) != w.charAt(i)) {
                    dif++;
                }

                if (dif > 1) {
                    dif =0;
                    break;
                }
            }
            if (dif == 1) {
                change.add(w);
            }
        }

        if (change.size() == 0) {
            return;
        }

        for(int i = 0; i<change.size(); i++){
            if (!visit.contains(change.get(i))) {

                visit.add(change.get(i));
                dfs(change.get(i), target, words, count+1);
                visit.remove(change.get(i));

            }
        }
    }
}
