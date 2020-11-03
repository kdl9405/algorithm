/**
 * publickeyCipher
 */
public class publickeyCipher {

    public static void main(String[] args) {

        int p = 521;
        int q = 613;
        int n = p*q;

        int nn = (p-1) * (q-1);
        int e = 11;       
        
        int d = findD(e, nn);

        int m1 = 150000;
        int c1 = (int)encrypt(m1, e, n);
        
        int c2 = 272301;
        int m2 = (int)encrypt(c2, d, n);
        

        System.out.println("개인키 d = " +d);
        System.out.println("평문 m1 = " +m1+"의 암호문 c1 = "+ c1);
        System.out.println("암호문 c2 = " +c2+"의 평문문 m2 = "+ m2);
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
}