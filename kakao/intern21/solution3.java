package kakao.intern21;

import java.util.*;

public class solution3 {

    public static void main(String[] args) {

        int n = 8;
        int k = 2;
        
        String[] cmd ={"D 2","C","U 3","C","D 4","C","U 2","Z","Z"};

       System.out.println(solution(n, k, cmd));

        // int t = 0;
        // t = t | (1 << 3);
        // System.out.println(t +" "+ Integer.toBinaryString(t));
        // t = t & ~(1 << 3);
        // System.out.println(t +" "+ Integer.toBinaryString(t));

    }

    public static String solution(int n, int k, String[] cmd) {

        int state_bit = 1 << 10;

        System.out.println("!" + Integer.toBinaryString(state_bit));

        Stack<Integer> zList = new Stack<>();

        for(String c : cmd){
            if (c.equals("C")) {

                state_bit |= 1 << k;                
                zList.add(k);
                boolean last = true;

                String sbit = Integer.toBinaryString(state_bit);
                
                System.out.println(sbit);
                for(int i = k+1; i<sbit.length(); i++){
                   
                }
                if (last) {
                    
                }
                
            }else if (c.equals("Z")) {

                state_bit &= ~(1 << zList.pop());    
                
            }else{
                String[] c2 = c.split(" ");
                int cnt = Integer.parseInt(c2[1]);
                int nk;

                if (c2[0].equals("U")) {

                    nk = k-cnt;

                 
                                        
                }else{
                    nk = k+cnt;

                  
                }

                k = nk;
            }
        }

        StringBuilder sb = new StringBuilder();

        

        return sb.toString();
    }
    
}
