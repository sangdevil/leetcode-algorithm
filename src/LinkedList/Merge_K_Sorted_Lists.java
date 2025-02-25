package LinkedList;

public class Merge_K_Sorted_Lists {
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

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        if (list1 == null) {
            return list2;
        } else if (list2 == null) {
            return list1;
        }
        ListNode head1 = list1;
        ListNode head2 = list2;
        boolean startFrom1 = head1.val <= head2.val;
        while (list1 != null && list2 != null){
            System.out.printf("list1 : %d, list2 : %d\n", list1.val, list2.val);
            if (list2.val >= list1.val) {
                while (list1.next != null && list2.val >= list1.next.val) {
                    list1 = list1.next;
                }
                ListNode nextList1 = list1.next;
                list1.next = list2;
                list1 = nextList1;
            } else {
                while (list2.next != null && list1.val > list2.next.val) {
                    list2 = list2.next;
                }
                ListNode nextList2 = list2.next;
                list2.next = list1;
                list1 = nextList2;
            }
        }
        if (startFrom1) {
            return head1;
        } else {
            return head2;
        }
    }

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        } else if (lists.length == 1) {
            return lists[0];
        }
        ListNode merged = null;
        for (int i = 0; i < lists.length; i++) {
            merged = mergeTwoLists(merged, lists[i]);
        }
        return merged;
    }
}
