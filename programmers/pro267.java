package programmers;

/*
 * 코딩테스트 연습 연습문제 마법의 엘리베이터
 * 
 * https://school.programmers.co.kr/learn/courses/30/lessons/148653
 */

public class pro267 {
    public int solution(int storey) {
        int answer = 0;

        while (storey > 0) {

            int a = storey / 10;
            int b = storey % 10;

            if (b > 5) {
                answer += (10 - b);
                a += 1;
            } else if (b < 5) {
                answer += b;
            } else {
                answer += b;
                if (a % 10 >= 5)
                    a++;
            }

            storey = a;
        }


        return answer;
    }
}
