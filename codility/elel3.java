import java.util.HashMap;

public class elel3 {
    public static void main(String[] args) {
        int[] X = {1,2,3,4};
        int[] Y = {1,2,3,4};

        System.out.println(solution(X, Y));

    }

    static int solution(int[] X, int[] Y) {
        int answer = 1;

        HashMap<String, Integer> hash = new HashMap<>();
        for(int i = 0; i<X.length; i++){
            int d = maxD(X[i], Y[i]);
            X[i] /= d;
            Y[i] /= d;

            String s = X[i]+"/"+Y[i];
            hash.put(s, hash.getOrDefault(s, 0)+1);
        }

        for(String h : hash.keySet()){
            answer = Math.max(hash.get(h), answer);
        }

        return answer;
    }

    static int maxD (int a, int b){
        while (b != 0) {
			int r = a % b; 

			a = b;
			b = r;
		}
		return a;
    }
}
