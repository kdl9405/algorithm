package programmers;

import java.util.*;

/* 
    다단계 칫솔 판매

*/
public class pro210 {

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

                money[s_id] += (earn - charge);

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
