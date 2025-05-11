package leetcode;

public class leet141 {

    public static void main(String[] args) {

    }

    public boolean hasCycle(ListNode head) {

        if (head == null || head.next == null)
            return false;
        if (head == head.next)
            return true;

        ListNode nextNode = head.next;
        head.next = head;

        return hasCycle(nextNode);
    }

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
