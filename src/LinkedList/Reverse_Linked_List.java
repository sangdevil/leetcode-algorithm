package LinkedList;

import java.util.ArrayList;

public class Reverse_Linked_List {
    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode reverseList(ListNode head) {
        ListNode prev = new ListNode(head.val);
        ListNode curr = head;
        while (curr.next != null) {
            curr = curr.next;
            ListNode newNode = new ListNode(curr.val, prev);
            prev = newNode;
        }
        return prev;
    }
}
