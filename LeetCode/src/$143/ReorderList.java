package $143;

public class ReorderList {
	public void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }
        ListNode slow = head, fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode newHead = slow.next;
        slow.next = null;
        ListNode dummy = new ListNode(-1);
        while (newHead != null) {
            ListNode next = newHead.next;
            newHead.next = dummy.next;
            dummy.next = newHead;
            newHead = next;
        }
        newHead = dummy.next;
        while (newHead != null) {
            ListNode next1 = head.next, next2 = newHead.next;
            head.next = newHead;
            newHead.next = next1;
            head = next1;
            newHead = next2;
        }
    }
}

class ListNode {
	int val;
	ListNode next;
	ListNode (int x) {
		val = x;
	}
}