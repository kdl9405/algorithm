package basic;

public class SingleLinkedList {

    public static void main(String[] args) {
        
        singleLinkedList LL = new singleLinkedList();

        LL.addToHead(1);

        
    }

    public static class Node {
        int data;
        Node next;
    }

    private static class singleLinkedList {
        private Node head;

        public void addToHead(int n){
            Node newNode = new Node();
            newNode.data = n;
            head.next = newNode;
            head = newNode;
        }

        public void removeFirst(){
            if (head == null) {
                throw new RuntimeException("not found");
            }

            Node temp = head;
            head = null;
            head = temp.next;
        }

        
        
    }


    
}
