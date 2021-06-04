package programmers;

/* 
    2개 이하로 다른 비트


*/
public class pro185 {

    public static void main(String[] args) {

        long n = 20;
        System.out.println(Long.toBinaryString(n));
        long a = n + 1;
        System.out.println(Long.toBinaryString(a));
        System.out.println(Long.toBinaryString(a ^ n));
        System.out.println(Long.toBinaryString((a ^ n) >>> 2));
        a += ((a ^ n) >>> 2);
        System.out.println(Long.toBinaryString(a));

        // System.out.println(n & (long) (1 << 0));
        // System.out.println(n & (long) (1 << 1));
        // System.out.println(n & (long) (1 << 2));
        // System.out.println(n & (long) (1 << 3));

        // System.out.println(nextN(7));

    }

    public long[] solution(long[] numbers) {
        long[] answer = numbers.clone();
        for (int i = 0; i < answer.length; i++) {
            answer[i]++;
            answer[i] += (answer[i] ^ numbers[i]) >>> 2;
        }
        return answer;
    }

}
