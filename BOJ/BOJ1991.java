package BOJ;

import java.io.*;

/* 
    트리 순회
*/
public class BOJ1991 {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        Tree tree = new Tree();

        while (t-- >0) {
            String input = br.readLine();

            tree.createNode(input.charAt(0), input.charAt(2), input.charAt(4));
            
        }

        // StringBuilder sb = new StringBuilder();
        // tree.preOrder(tree.root, sb);
        // System.out.println(sb.toString());

        // sb = new StringBuilder();
        // tree.inOrder(tree.root, sb);
        // System.out.println(sb.toString());

        // sb = new StringBuilder();
        // tree.postOrder(tree.root, sb);
        // System.out.println(sb.toString());

        tree.preOrder(tree.root);
        System.out.println("");
        tree.inOrder(tree.root);
        System.out.println("");
        tree.postOrder(tree.root);
    }

}

class Node {
    char ch;
    Node left;
    Node right;

    public Node(char ch){
        this.ch =ch;
    }

}

class Tree {

    public Node root;

    
    public void createNode(char ch, char left, char right) {

        if (root == null) {
            root = new Node(ch);
            if (left != '.') {
                root.left = new Node(left);
            }
            if (right !='.') {
                root.right = new Node(right);
            }
        }else {
            updateNode(root, ch, left, right);
        }

    }

    public void updateNode(Node root, char ch, char left, char right){

        if(root == null){
            return;
        }

        if (root.ch == ch) {
            if(left != '.'){
                root.left = new Node(left);
            } 
            if (right !='.') {
                root.right = new Node(right);
            }
        }else{
            updateNode(root.left, ch, left, right);
            updateNode(root.right, ch, left, right);

        }
    } 


    // public void inOrder(Node node, StringBuilder sb){
    //     if(node != null){
    //         inOrder(node.left, sb);
    //         sb.append(node.ch);
    //         inOrder(node.right, sb);
    //     }
    // }
    // public void preOrder(Node node, StringBuilder sb){
    //     if(node != null){
    //         sb.append(node.ch);
    //         inOrder(node.left, sb);
    //         inOrder(node.right, sb);
    //     }
    // }
    // public void postOrder(Node node, StringBuilder sb){
    //     if(node != null){
    //         inOrder(node.left, sb);
    //         inOrder(node.right, sb);
    //         sb.append(node.ch);
    //     }
    // }

    public void inOrder(Node node){
        if(node != null){
            inOrder(node.left);
            System.out.print(node.ch);
            inOrder(node.right);
        }
    }

    public void preOrder(Node node){
        if(node != null){
            System.out.print(node.ch);
            preOrder(node.left);
            preOrder(node.right);
        }
    }

    public void postOrder(Node node){
        if(node != null){
            postOrder(node.left);
            postOrder(node.right);
            System.out.print(node.ch);
        }
    }
}
