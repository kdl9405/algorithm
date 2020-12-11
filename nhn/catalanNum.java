package nhn;

public class catalanNum {

    public static void main(String[] args) {

        int n = 1000;

        arr = new int[n+1];

        System.out.println(DP(n));

    }

    static int[] arr;

    static int DP(int n) {

        if (n <= 1) {
            return 1;
        }

        if (arr[n] != 0) {
            return arr[n];
        }

        for(int i = n-1; i>=0; i--){
            arr[n] +=(DP(i)*DP(n-1-i));
        }

        return arr[n];
    
    }

}
