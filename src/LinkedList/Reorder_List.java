package LinkedList;

public class Reorder_List {
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

    public void reorderList(ListNode head) {
        if (head.next == null || head.next.next == null) {
            return;
        }

        ListNode tmp = head;
        ListNode reverse = null;
        int size = 0;
        while (head != null) {
            ListNode newNode = new ListNode(head.val, reverse);
            reverse = newNode;
            size++;
            head = head.next;
        }
        int i = 0;
        head = tmp;
        while (i < size - 1) {
            System.out.printf("head, reverse : %d, %d", head.val, reverse.val);
            if (i % 2 == 0) {
                tmp = head;
                head.next = reverse;
                head = tmp.next;
            } else {
                tmp = reverse;
                reverse.next = head;
                reverse = tmp.next;
            }
            i++;
        }
        if (i % 2 == 0) {
            reverse.next = null;
        } else {
            head.next = null;
        }
    }
}
