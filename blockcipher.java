/**
 * blockcipher
 */
public class blockcipher {

    public static void main(String[] args) {
        int p = 0x12345678;
        int k = 0xC58FA10B;
        String c = "0";
       
        String pp = Integer.toHexString(p);
        String kk = Integer.toHexString(k);
        long PL = Long.parseLong(pp, 16);
        long KL = Long.parseLong(kk, 16);

        System.out.println("\n"+"평문 블록 : "+pp);
        System.out.println("비밀키 : "+kk+"\n");

        setS();

        c = BlockCipherEncrypt(KL, PL);

        System.out.println("\n"+"암호문 블록 : "+c);

    }

    static String BlockCipherEncrypt(long k, long p) {
        long n = (p&0xffffffff) ^ k;

        for(int r = 0; r<8; r++){
            String nS = Long.toHexString(n);

            if (nS.length()<8) {
                while (nS.length()<8) {
                    nS = "0"+nS;
                }
            }
            System.out.println("라운드 "+(r+1) + "시작  : " + nS);

            String[] x = nS.split("");
            int[] y = new int[8];
    
            for (int i = 0; i < 8; i++) {
                int num = Integer.parseInt(x[i], 16);
                y[i] = S[num];
            }
    
            String zS = metrix(y);
            Long z = Long.parseLong(zS, 16);

            n = (z&0xffffffff) ^ k;   
            
            System.out.println("라운드 "+(r+1) + "xor후 : " + Long.toHexString(n));

        }       

        String result = Long.toHexString(n);
        
        return result;
    }

    static int[] S;

    static void setS() {
        S = new int[16];

        S[0] = 14;
        S[1] = 4;
        S[2] = 13;
        S[3] = 1;
        S[4] = 2;
        S[5] = 15;
        S[6] = 11;
        S[7] = 8;
        S[8] = 3;
        S[9] = 10;
        S[10] = 6;
        S[11] = 12;
        S[12] = 5;
        S[13] = 9;
        S[14] = 0;
        S[15] = 7;
        return;
    }

    static String metrix(int[] y) {

        int[] z = new int[8];
        z[7] = (y[7] ^ y[5] ^ y[4] ^ y[2] ^ y[1] ^ y[0]);
        z[6] = (y[7] ^ y[6] ^ y[4] ^ y[3] ^ y[1] ^ y[0]);
        z[5] = (y[7] ^ y[6] ^ y[5] ^ y[3] ^ y[2] ^ y[0]);
        z[4] = (y[6] ^ y[5] ^ y[4] ^ y[3] ^ y[2] ^ y[1]);
        z[3] = (y[7] ^ y[6] ^ y[2] ^ y[1] ^ y[0]);
        z[2] = (y[6] ^ y[5] ^ y[3] ^ y[1] ^ y[0]);
        z[1] = (y[5] ^ y[4] ^ y[3] ^ y[2] ^ y[0]);
        z[0] = (y[7] ^ y[4] ^ y[3] ^ y[2] ^ y[1]);

        String zS = "";
        for (int n : z) {
            zS += Integer.toHexString(n);
        }

        return zS;
    }
}