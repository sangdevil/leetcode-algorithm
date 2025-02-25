package LinkedList;

public class Remove_Nth_Node_From_End_Of_List {
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

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head.next == null) {
            return null;
        }
        ListNode target = null;
        ListNode fast = head;
        int i = 0;
        while (fast.next != null) {
            fast = fast.next;
            if (i >= n) {
                if (target == null) {
                    target = head;
                } else {
                    target = target.next;
                }
            }
            i++;
        }
        if (target == null) {
            head = head.next;
        }
        if (target.next != null) {
            System.out.printf("target = %d\n", target.next.val);
            target.next = target.next.next;
        }
        return head;

    }
}
