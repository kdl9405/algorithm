public class hashMAC {

    public static void main(String[] args) {

        String M = "Twinkle twinkle little star How I wonder what you are Up above the world so high Like a diamond in the sky Twinkle twinkle little star How I wonder what you are";

        String hashValue = hashFunc(M);
        System.out.println("해시 값 = " + hashValue);

        int k = 0xcf36e59a;

        String macValue = hmac(k, M);
        System.out.println("MAC 값 = " + macValue);

    }

    static String hmac(int k, String m) {
        int C1 = 0xabcdeff;
        int C2 = 0x12345678;

        long c = Long.parseLong(Integer.toHexString(C1), 16);
        long K = Long.parseLong(Integer.toHexString(k), 16);
        long n = c ^ K;

        String h = hashFunc(Long.toHexString(n) + m);

        c = Long.parseLong(Integer.toHexString(C2), 16);
        n = c ^ K;

        String result = hashFunc(Long.toHexString(n) + h);

        return result;
    }

    static String hashFunc(String M) {

        String mdS = mdStrengthing(M);

        String[] str = new String[mdS.length() / 32];

        for (int i = 0; i < str.length; i++) {
            str[i] = mdS.substring(i * 8, (i + 1) * 8);
        }

        int IV = 0xa5c8f1ee;
        String x = Integer.toHexString(IV);
        for (int i = 0; i < str.length; i++) {
            x = blockCipherDaviesMeyer(x, str[i]);
        }

        return x;
    }

    static String mdStrengthing(String M) {

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M.length(); i++) {
            int n = (int) M.charAt(i);
            String s = Integer.toHexString(n);
            if (s.length() == 1) {
                s = "0" + s;
            }
            sb.append(s);
        }
        sb.append(1);

        String len = Integer.toHexString(M.length());

        if ((sb.length() + len.length()) % 8 != 0) {
            int c = 8 - ((sb.length() + len.length()) % 8);
            for (int i = 0; i < c; i++) {
                sb.append(0);
            }
        }

        sb.append(len);
        return sb.toString();
    }

    static String blockCipherDaviesMeyer(String x, String m) {

        long P = Long.parseLong(x, 16);
        long K = Long.parseLong(m, 16);

        long n = (P & 0xffffffff) ^ K;

        int S[] = { 14, 4, 13, 1, 2, 15, 11, 8, 3, 10, 6, 12, 5, 9, 0, 7 };

        for (int r = 0; r < 8; r++) {
            String nS = Long.toHexString(n);

            if (nS.length() < 8) {
                while (nS.length() < 8) {
                    nS = "0" + nS;
                }
            }

            String[] str = nS.split("");
            int[] y = new int[8];

            for (int i = 0; i < 8; i++) {
                int num = Integer.parseInt(str[i], 16);
                y[i] = S[num];
            }

            String zS = metrix(y);
            long z = Long.parseLong(zS, 16);

            n = (z & 0xffffffff) ^ K;
        }
        n = (n & 0xffffffff) ^ (P & 0xffffffff);
        return Long.toHexString(n);
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
