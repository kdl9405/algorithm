package programmers;


/* 
    x만큼 간격이 있는 n개의 숫자

*/
public class pro160 {
    class Solution {
        public long[] solution(int x, int n) {
            long[] answer = new long[n];
            long y = x;
            for(int i = 0; i<n; i++){
                answer[i] = y;
                y+=x;
            }
            return answer;
        }
    }
}
