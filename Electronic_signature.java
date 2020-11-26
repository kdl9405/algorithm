public class Electronic_signature {

    public static void main(String[] args) {

        String M = "Twinkle twinkle little star How I wonder what you are Up above the world so high Like a diamond in the sky Twinkle twinkle little star How I wonder what you are";

        String hash = hashFunc(M);

        String s = publickeyCipher(hash);

        System.out.println("전자 서명 값 s : " +s);

    }

    static String publickeyCipher(String h){
        int p = 521;
        int q = 613;
        int n = p*q;

        int nn = (p-1) * (q-1);
        int e = 11;       
        
        int d = findD(e, nn);
        
        int s = (int)encrypt(Integer.parseInt(h,16), d, n);
        
        return Integer.toString(s);
    }

    static int findD(int e, int nn){
        int d = 0;

		for (int i = 0; i < nn; i++) {
			int mul = e * i;
			d = mul % nn;
			if (d == 1) {
				d = i;
				break;
			}
		}

        return d;
    }

    static long encrypt(int m, int e, int n){
        long c = 1;

        int i = 0;
        while (i++ < e) {
            c = (c*(m%n))%n;
        }

        return c;
    }  
 

    static String hashFunc(String M) {

        String mdS = mdStrengthing(M);

        String[] str = new String[mdS.length() / 32];

        for (int i = 0; i < str.length; i++) {
            String temp = mdS.substring(i * 32, (i + 1) * 32);
            str[i] = Long.toHexString(Long.parseLong(temp, 2));
        }

        int IV = 0xa5c8f1ee;

        String x1 = Integer.toHexString(IV);

        for (int i = 0; i < str.length; i++) {

            long x = Long.parseLong(x1, 16);
            long m = Long.parseLong(str[i], 16);

            long y = Long.parseLong(BlockCipherEncrypt(m, x), 16) ^ x;

            x1 = Long.toHexString(y);

        }

        return x1;
    }

    static String mdStrengthing(String M) {

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M.length(); i++) {
            int n = (int) M.charAt(i);
            String s = Integer.toBinaryString(n);

            if (s.length() < 8) {
                while (s.length() < 8) {
                    s = "0" + s;
                }
            }

            sb.append(s);
        }

        String extra = "1";

        String len = Integer.toBinaryString(M.length());

        int c = sb.length() + extra.length() + len.length();

        if ((c % 32) != 0) {
            int t = 32-(c%32);
            for(int i = 0; i< t; i++){
                extra+="0";
            }           
        }

        sb.append(extra).append(len);

        return sb.toString();
    }

    static String BlockCipherEncrypt(long k, long p) {

        setS();

        long n = (p & 0xffffffff) ^ k;

        for (int r = 0; r < 8; r++) {
            String nS = Long.toHexString(n);

            if (nS.length() < 8) {
                while (nS.length() < 8) {
                    nS = "0" + nS;
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

            n = (z & 0xffffffff) ^ k;

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
