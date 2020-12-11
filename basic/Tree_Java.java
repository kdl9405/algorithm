package basic;

public class Tree_Java {

    public static void main(String[] args) {
        
    }
    
}

class Node{
    int data;
    Node left;
    Node right;
}

class Tree{
    public Node root;

    public void setRoot(Node node){
        this.root = node;
    }

    public Node getRoot(){
        return root;
    }

    public Node createNode(int data, Node left, Node right){
        Node node = new Node();
        node.data = data;
        node.left = left;
        node.right = right;

        return node;
    }

    public void inOrder(Node node){
        if(node != null){
            inOrder(node.left);
            System.out.println(node.data);
            inOrder(node.right);
        }
    }

    public void preOrder(Node node){
        if(node != null){
            System.out.println(node.data);
            preOrder(node.left);
            preOrder(node.right);
        }
    }

    public void postOrder(Node node){
        if(node != null){
            postOrder(node.left);
            postOrder(node.right);
            System.out.println(node.data);
        }
    }


}
