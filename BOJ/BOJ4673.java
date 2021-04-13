/**
 * BOJ4673
 */
public class BOJ4673 {

    public static void main(String[] args) {

        int[] selfN;
        selfN = new int[10001];

        for(int i = 1; i < 10000; i++){
            
            if(numberD(i) <= 10000)
            selfN[numberD(i)] = 1; 
        }

        for(int j = 1; j<10001; j++){
            if(selfN[j] == 0){
                System.out.println(j);
            }
        }
        

    }

    public static int numberD(int n) {

        String number = String.valueOf(n);
        String[] num = number.split("");
        int sum = 0;

        for (int i = 0; i<num.length; i++){

            sum += Integer.parseInt(num[i]);

        }

        int nD = n+sum;

        return nD;
    }

}