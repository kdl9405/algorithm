import java.util.HashMap;

public class ele1 {
    public static void main(String[] args) {
        
                // 최대값은 1개만 나머진 2개까지 가능!!

                int[] A = {2,2,2,2};
                System.out.println(solution(A));
    }
    static int solution(int[] A) {
        int answer = 1;

        HashMap<Integer, Integer> hash = new HashMap<>();

        int max = 0;
        for(int a : A){
            hash.put(a, hash.getOrDefault(a, 0)+1);
            max = Math.max(a, max);
        }

        hash.remove(max);
        // answer++;

        for(int h : hash.keySet()){
            int n = hash.get(h);
            if (n > 2) {
                n = 2;
            }
            answer+=n;
        }      


        return answer;
    }
}

