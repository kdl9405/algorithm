import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class BOJ10171 {

    public static void main(String[] args) throws IOException {

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        bw.write("|\\_/|");
        bw.newLine();
        bw.write("|q p|   /}");
        bw.newLine();
        bw.write("( 0 )\"\"\"\\");
                bw.newLine();
        bw.write("|\"^\"`    |");
        bw.newLine();
        bw.write("||_/=\\\\__|");
        bw.newLine();

        
        bw.flush();
        bw.close();
        
    }

}