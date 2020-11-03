package BJ;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ1427_copy {

    public static void main(String[] args) throws IOException {
 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 
		int[] counting = new int[10];
		String s = br.readLine();
 
		for (int i = 0; i < s.length(); i++) {
			counting[s.charAt(i) - '0']++;
		}
 
		for (int i = 9; i >= 0; i--) {
			while (counting[i]-- > 0) {
				System.out.print(i);
			}
		}
	}
}