package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ2263 {

    public static void main(String[] args) throws NumberFormatException, IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        inOrder = new int[n];
        for(int i = 0; i<n; i++){
            inOrder[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());

        postOrder = new int[n];
        for(int i = 0; i<n; i++){
            postOrder[i] = Integer.parseInt(st.nextToken());
        }

        preOrder = new int[1000001];
        for(int i = 0; i<n; i++){
            preOrder[inOrder[i]] = i;
        }

        sb = new StringBuilder();

        toPreOrder(0, n-1, 0, n-1);
    
        System.out.println(sb.toString());


    }

    static int[] inOrder;
    static int[] postOrder;
    static int[] preOrder;
    static StringBuilder sb;

    static void toPreOrder(int inS, int inE, int poS, int poE){
        if (inS > inE || poS > poE) {
            return;
        }

        int root = postOrder[poE];
        int index = preOrder[root];
        int left = index-inS;
        
        sb.append(root+" ");

        toPreOrder(inS, index-1, poS, poS+left-1);
        toPreOrder(index+1, inE, poS+left, poE-1);



    }
}
