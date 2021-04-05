package programmers.dev;

import java.util.*;

public class dev4 {

    public static void main(String[] args) {
        String[] enroll = { "john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young" };
        String[] referral = { "-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward" };
        String[] seller = { "young", "john", "tod", "emily", "mary" };
        int[] amount = { 12, 4, 2, 5, 10 };

        int[] answer = solution(enroll, referral, seller, amount);

        for (int a : answer) {
            System.out.println(a);
        }

    }

    static HashMap<String, Integer> id;
    static int[] money;

    public static int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {

        money = new int[enroll.length];

        id = new HashMap<>();

        for (int i = 0; i < enroll.length; i++) { // name->id
            id.put(enroll[i], i);
        }

        for (int i = 0; i < seller.length; i++) {

            int charge = (amount[i] * 100) / 10;
            int earn = (amount[i] * 100);
            int s_id = id.get(seller[i]);

            while (true) {

                money[s_id] += (earn-charge);


                if (referral[s_id].equals("-")) {
                    break;
                }

                s_id = id.get(referral[s_id]);

                earn = charge;
                charge = earn / 10;                
            }
        }

        return money;
    }

}
