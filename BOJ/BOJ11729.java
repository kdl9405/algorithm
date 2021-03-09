import java.io.*;

public class BJ11729 {
    
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws NumberFormatException, IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        bw.write((int)(Math.pow(2, n)-1) +"\n");

        hanoi(n, 1, 2, 3);

        bw.flush();
        bw.close();

    }

    public static void hanoi(int n, int start, int mid, int dest) throws IOException {

        if(n == 1){
            bw.write(start +" " + dest +"\n");
            return;
        }

        hanoi(n-1, start, dest, mid);

        bw.write(start +" " + dest +"\n");

        hanoi(n-1, mid, start, dest);
    }
}