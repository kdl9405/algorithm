package programmers.dev;

import java.util.*;

public class dev3 {

    public static void main(String[] args) {

    }

    static HashMap<String, Integer> id;
    static ArrayList<Integer>[] children;
    static long[] money;

    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {

        id = new HashMap<>();
        children = new ArrayList[enroll.length];
        money = new long[enroll.length];
        ArrayList<Integer> roots = new ArrayList<>();

        for (int i = 0; i < enroll.length; i++) {
            id.put(enroll[i], i);
            children[i] = new ArrayList<>();
        }

        for (int i = 0; i < referral.length; i++) {
            if (referral[i].equals("-")) {
                roots.add(i);
                continue;
            }

            children[id.get(referral[i])].add(i);
        }

        for (int i = 0; i < seller.length; i++) {
            money[id.get(seller[i])] += (amount[i] * 100);
        }

        for (int r : roots) {
            findMoney(r);
        }

        int[] answer = new int[money.length];

        for (int i = 0; i < money.length; i++) {
            answer[i] = (int)(money[i]-(money[i] / 10));
        }

        return answer;
    }

    static long findMoney(int e_id) {

        for (int child : children[e_id]) {
            money[e_id] += (findMoney(child) / 10);
        }

        return money[e_id];
    }
}