package BJ;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

/**
 * BJ10718
 */
class BJ10718 {

    public static void main(String[] args) throws IOException {

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = "강한친구 대한육군";

        bw.write(s);
        bw.newLine();
        bw.write(s);
        
        bw.flush();
        bw.close();

    }
    
}