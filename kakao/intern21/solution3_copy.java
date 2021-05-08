package kakao.intern21;

import java.util.*;

public class solution3_copy {

    public static void main(String[] args) {

        int n = 8;
        int k = 2;
        
        String[] cmd ={"D 2","C","U 3","C","D 4","C","U 2","Z","Z"};

        System.out.println(solution(n, k, cmd));
        
    }

    public static String solution(int n, int k, String[] cmd) {
        boolean[] state = new boolean[n];

        Stack<Integer> zList = new Stack<>();

        for(String c : cmd){
            if (c.equals("C")) {

                state[k] = true;
                zList.add(k);
                boolean last = true;
                
                for(int i = k+1; i<n; i++){
                    if (!state[i]) {
                        last = false;
                        k = i;
                        break;
                    }
                }
                if (last) {
                    for(int i = k-1; i>0; i--){
                        if (!state[i]) {
                            last = false;
                            k = i;
                            break;
                        }
                    }
                }
                
            }else if (c.equals("Z")) {

                state[zList.pop()] = false;
                
            }else{
                String[] c2 = c.split(" ");
                int cnt = Integer.parseInt(c2[1]);
                int nk;

                if (c2[0].equals("U")) {

                    nk = k-cnt;

                   while (k-- > nk) {
                       if (state[k]) {
                           nk--;
                       }
                   }
                                        
                }else{
                    nk = k+cnt;

                    while (k++ < nk) {
                        if (state[k]) {
                            nk++;
                        }
                    }
                }

                k = nk;
            }
        }

        StringBuilder sb = new StringBuilder();

        for(boolean s : state){
            if (s) {
                sb.append("X");
            }else{
                sb.append("O");
            }
        }

        return sb.toString();
    }
    
}
