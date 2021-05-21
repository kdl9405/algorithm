package gooorm;

import java.io.*;
import java.util.*;

/* 
    근묵자흑
*/

public class g1 {

    public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		int[] num = new int[n];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i<n; i++){
			num[i] = Integer.parseInt(st.nextToken());
		}
		
		int count = ((n-1)/(k-1));
		if((n-1)%(k-1)!= 0){
			count++;
		}
		
		System.out.println(count);
		
		
	}
}