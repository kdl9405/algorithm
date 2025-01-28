package boj;

import java.io.*;

/**
 * InnerBOJ8394
 * 
 * 
 */
public class BOJ2439 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= T; i++) {

			for (int j = 1; j <= T - i; j++) {
				sb.append(" ");
			}

			for (int n = 1; n <= i; n++) {
				sb.append("*");
			}

			sb.append('\n');
		}
		System.out.println(sb);
	}
}
