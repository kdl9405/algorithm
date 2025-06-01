package programmers;

// 2021 Dev-Matching: 웹 백엔드 개발자(상반기)
// 다단계 칫솔 판매

import java.util.*;

public class pro237 {

    public static void main(String[] args) {

        String[] enroll = {"john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young"};
        String[] referral = {"-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward"};
        String[] seller = {"young", "john", "tod", "emily", "mary"};
        int[] amount = {12, 4, 2, 5, 10};

        int[] answer = solution(enroll, referral, seller, amount);

        for (int ans : answer) {
            System.out.println(ans);
        }

    }

    // 이름과 순서(노드번호?)를 매핑시킬수 있는 테이블 필요.

    static Map<String, String> parents;
    static Map<String, Integer> total;

    public static int[] solution(String[] enroll, String[] referral, String[] seller,
            int[] amount) {

        parents = new HashMap<>();

        for (int i = 0; i < enroll.length; i++) {
            parents.put(enroll[i], referral[i]);
        }

        total = new HashMap<>();

        for (int i = 0; i < seller.length; i++) {
            distribute(seller[i], amount[i] * 100);
        }

        int[] answer = new int[enroll.length];

        for (int i = 0; i < answer.length; i++) {
            answer[i] = total.getOrDefault(enroll[i], 0);
        }

        return answer;
    }

    private static void distribute(String child, int amount) {

        int distributedMoney = amount / 10;
        amount -= distributedMoney;

        total.put(child, total.getOrDefault(child, 0) + amount);

        if (amount < 1 || "-".equals(parents.get(child)))
            return;

        distribute(parents.get(child), distributedMoney);
    }

}
