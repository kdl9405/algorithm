/**
 * blockcipher
 */
public class blockcipher {

    public static void main(String[] args) {
        int p = 0x12345678;
        int k = 0xC58FA10B;
        String c = "0";

        // Long temp = Long.parseLong(Long.toString(p^k));
        // String st = temp.toHexString(temp);

        // String temp1 = Integer.toHexString(k);
        // System.out.println("int16 To String16 !!!!"+temp1);
        // long tp = Long.parseLong(temp1, 16);
        // System.out.println("String16 To Long10 !!!!"+tp);
        // String temp2 = Long.toHexString(tp);
        // System.out.println("Long10 To String16 !!!!"+temp2);

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
        long n = p ^ k;

        for(int r = 0; r<8; r++){
            String nS = Long.toHexString(n);
            System.out.println("라운드 "+(r+1) + " : " + nS);

            if (nS.length()<8) {
                while (nS.length()<8) {
                    nS+= "0"+nS;
                }
            }
            String[] x = nS.split("");
            int[] y = new int[8];
    
            for (int i = 0; i < 8; i++) {
                int num = Integer.parseInt(x[i], 16);
                y[i] = S[num];
            }
    
            String zS = metrix(y);
            Long z = Long.parseLong(zS, 16);
    
            n = z ^ k;    
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
        z[0] = (y[0] ^ y[2] ^ y[3] ^ y[5] ^ y[6] ^ y[7])&0xffffffff;
        z[1] = (y[0] ^ y[1] ^ y[3] ^ y[4] ^ y[6] ^ y[7])&0xffffffff;
        z[2] = (y[0] ^ y[1] ^ y[2] ^ y[4] ^ y[5] ^ y[7])&0xffffffff;
        z[3] = (y[1] ^ y[2] ^ y[3] ^ y[4] ^ y[5] ^ y[6])&0xffffffff;
        z[4] = (y[0] ^ y[1] ^ y[5] ^ y[6] ^ y[7])&0xffffffff;
        z[5] = (y[1] ^ y[2] ^ y[4] ^ y[6] ^ y[7])&0xffffffff;
        z[6] = (y[2] ^ y[3] ^ y[4] ^ y[5] ^ y[7])&0xffffffff;
        z[7] = (y[0] ^ y[3] ^ y[4] ^ y[5] ^ y[6])&0xffffffff;

        String zS = "";
        for (int n : z) {
            zS += Integer.toHexString(n);
        }

        return zS;
    }
}