import java.util.*;

/**
 * [1차] 뉴스 클러스터링
 * 
 */
public class pro70 {

    public static void main(String[] args) {

        String str1 = "aa1+Aa2";
        String str2 = "AAAA12";

        System.out.println(solution(str1, str2));

    }

    static int solution(String str1, String str2) {
        int answer = 0;

        HashMap<String, Integer> hash1 = new HashMap<>();
        HashMap<String, Integer> hash2 = new HashMap<>();

        str1 = str1.replaceAll("[^a-zA-Z]", "*").toLowerCase();
        str2 = str2.replaceAll("[^a-zA-Z]", "*").toLowerCase();

        for (int i = 0; i < str1.length() - 1; i++) {
            String temp = str1.substring(i, i + 2);
            if (!temp.contains("*")) {
                hash1.put(temp, hash1.getOrDefault(temp, 0) + 1);
            }
        }
        for (int i = 0; i < str2.length() - 1; i++) {
            String temp = str2.substring(i, i + 2);
            if (!temp.contains("*")) {
                hash2.put(temp, hash2.getOrDefault(temp, 0) + 1);
            }
        }

        if (hash1.size() == 0 && hash2.size() == 0) {
            return 65536;
        }

        HashMap<String, Integer> dup = new HashMap<>();
        HashMap<String, Integer> sum = new HashMap<>();

        for (String key : hash1.keySet()) {
            if (hash2.containsKey(key)) {
                dup.put(key, Math.min(hash1.get(key), hash2.get(key)));
                sum.put(key, Math.max(hash1.get(key), hash2.get(key)));
                hash2.remove(key);
            } else {
                sum.put(key, hash1.get(key));
            }
        }
        for (String key : hash2.keySet()) {
            sum.put(key, hash2.get(key));
        }

        int num1 = 0;
        int num2 = 0;

        for(String key : dup.keySet()){
            num1 += dup.get(key);
        }
        
        for(String key : sum.keySet()){
            num2 += sum.get(key);
        }
        
        double x = (double)num1 / (double)num2;

        answer = (int) (x * 65536);

        return answer;
    }
}