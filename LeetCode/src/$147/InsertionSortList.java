package $147;

public class InsertionSortList {
	public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = new ListNode(-1);
        newHead.next = head;
        while (head.next != null) {
            if (head.next.val >= head.val) {
                head = head.next;
            } else {
                ListNode cursor = newHead;
                ListNode next = head.next;
                head.next = next.next;
                while (next.val > cursor.next.val) {
                    cursor = cursor.next;
                }
                next.next = cursor.next;
                cursor.next = next;
            }
        }
        return newHead.next;
    }
}

class ListNode {
	int val;
	ListNode next;
	ListNode (int x) {
		val = x;
	}
}