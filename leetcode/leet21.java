package leetcode;

public class leet21 {

    public static void main(String[] args) {

    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        ListNode mergedList;
        ListNode startNode;

        if (list1 == null && list2 == null)
            return list1;

        int startList1 = (list1 != null) ? list1.val : 101;
        int startList2 = (list2 != null) ? list2.val : 101;

        if (startList1 <= startList2) {
            startNode = new ListNode(startList1);
            list1 = list1.next;
        } else {
            startNode = new ListNode(startList2);
            list2 = list2.next;
        }

        mergedList = startNode;

        while (list1 != null && list2 != null) {
            ListNode nextNode;
            if (list1.val <= list2.val) {
                nextNode = new ListNode(list1.val);
                list1 = list1.next;
            } else {
                nextNode = new ListNode(list2.val);
                list2 = list2.next;
            }

            mergedList.next = nextNode;
            mergedList = nextNode;

        }

        ListNode remain;
        if (list1 != null) {
            remain = list1;
        } else {
            remain = list2;
        }


        while (remain != null) {
            ListNode nextNode = remain;
            remain = remain.next;
            mergedList.next = nextNode;
            mergedList = nextNode;
        }

        return startNode;
    }



    public class ListNode {
        int val;
        ListNode next;

        ListNode() {}

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

}


