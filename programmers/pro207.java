package programmers;

import java.util.*;

/*  
    브라이언의 고민

    1. 소문자 개수 체크
    2. 특정 소문자의 개수가 2개면 2번 / 1번 규칙
    3. 1개 or 3개 이상이면 1번 규칙
    4. 한번 사용된 소문자가 다음에 또 사용되면 Fail

*/

public class pro207 {

    public static void main(String[] args) {

        String sentence = "xAaAbAaAx";
        System.out.println(solution(sentence));

    }

    public static String solution(String sentence) {

        String answer = "invalid";

        sen = sentence.toCharArray();

        alphabet = new HashMap<>();

        for (int i = 0; i < sen.length; i++) {
            if (Character.isLowerCase(sen[i])) {
                if (!alphabet.containsKey(sen[i])) {
                    alphabet.put(sen[i], new HashSet<>());
                }

                alphabet.get(sen[i]).add(i);
            }
        }

        visit = new boolean[26];
        result = new StringBuilder();

        for (int i = 0; i < sen.length; i++) {


            System.out.println("!!!! "+ sen[i]);

            if (Character.isLowerCase(sen[i])) {

                System.out.println("소문자  "+ sen[i]);


                if (visit[sen[i] - 'a']) {
                    return answer;
                }

                if (alphabet.get(sen[i]).size() == 2) {

                    int[] a = Arrays.stream( alphabet.get(sen[i]).toArray()).mapToInt(x-> (int)x).toArray();
                    Arrays.sort(a);

                    int end = a[1];

                    System.out.println("end " + end);

                    if (!ruleTwo(i, end)) {
                        System.out.println("22222");

                        return answer;
                    }

                    i = end;
                }

            } else {

                System.out.println("대문자  "+ sen[i]);


                result.append(sen[i]);

                if (i < sen.length - 1 && Character.isLowerCase(sen[i + 1])) {
                    i++;
                    if (!ruleOne(i)) {

                        System.out.println(sen[i]);
                        System.out.println("1111");

                        return answer;
                    }
                    i = (int) alphabet.get(sen[i]).toArray()[alphabet.get(sen[i]).size() - 1] + 1;

                }

            }
        }

        String r = result.toString().trim();

        if (r.replaceAll("[^a-z]", "").length() == 0) {
            answer = r;
        }

        return answer;
    }

    static HashMap<Character, HashSet<Integer>> alphabet;
    static boolean[] visit;
    static char[] sen;
    static StringBuilder result;

    static boolean ruleOne(int s) {

        if (visit[sen[s] - 'a']) {
            return false;
        }
        visit[sen[s] - 'a'] = true;

        int count = alphabet.get(sen[s]).size();

        StringBuilder word = new StringBuilder();

        int i = 0;
        for (; s + i < sen.length; i++) {

            if (i % 2 == 0) {

                if (sen[s] == sen[s + i]) {
                    count--;

                    if (count == 0) {
                        break;
                    }

                    continue;
                } else {
                    return false;
                }

            }

            if (Character.isLowerCase(sen[s + i])) {
                return false;
            }

            word.append(sen[s + i]);

        }

        if (s+i+1 >= sen.length) {
            return false;
        }
        word.append(sen[s + i + 1]);

        result.append(word + " ");

        return true;
    }

    static boolean ruleTwo(int s, int e) {

        if (visit[sen[s] - 'a']) {
            return false;
        }
        visit[sen[s] - 'a'] = true;

        if (sen[s+1] == sen[s]) {
            return false;
        }

        if (Character.isLowerCase(sen[s + 2]) && sen[s] != sen[s+2]) {
            result.append(sen[s + 1]);
            ruleOne(s + 2);
        } else {

            StringBuilder word = new StringBuilder();
            for (int i = s + 1; i < e; i++) {
                if (Character.isLowerCase(sen[i])) {
                    return false;
                }
                word.append(sen[i]);
            }

            result.append(word + " ");

        }

        return true;
    }
}
