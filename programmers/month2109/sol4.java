package programmers.month2109;

import java.util.*;

/* 

*/

public class sol4 {
    public static void main(String[] args) {

        int[] a = {1,1,1,1,1,1,2,5,8,2,1,1,4,8,8,8,12,6,6};
        int[] s = {4,3,1,5,6};

        int[] result = solution(a, s);
        for(int r : result){
            System.out.println(r);
        }


        // cSet = new HashSet<>();
        // findC(new int[]{8,2,1,1,4}, 5, 0, new StringBuilder());
        // System.out.println(cSet);
    }

    public static int[] solution(int[] a, int[] s) {
        int[] answer = new int[s.length];

        int start = 0;
        for(int i = 0; i<s.length; i++){
            cSet = new HashSet<>();
            long[] b = new long[s[i]];
            for(int j = 0; j<s[i]; j++){
                b[j] = a[start+j];
            }
            findC(b, s[i], 0, new StringBuilder());
            answer[i] = cSet.size();

            start += s[i];

        }

        return answer;
    }

    static HashSet<String> cSet;

    static void findC(long[] b, int n, int i, StringBuilder c) {

        if (i == n) {
            cSet.add(c.toString());
            return;
        }

        StringBuilder sb = new StringBuilder(c);

        findC(b, n, i + 1, sb);

        if (i != 0) {

            for(int j = i-1; j>=0; j--){
                if (b[j] == -1) {
                    continue;
                }

                if (b[j] != b[i]) {
                    break;
                }
                long[] d = b.clone();
                d[i] += d[j];
                d[j] = -1;
                findC(d, n, i, sb.append(i+" "));
                break;
                
            }
        }

    }
}
