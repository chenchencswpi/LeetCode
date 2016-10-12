package $19;

public class RemoveNthNodeFromEndOfList {
	public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode newHead = new ListNode(-1);
        newHead.next = head;
        ListNode slow = newHead, fast = newHead;
        while (n > 0) {
            fast = fast.next;
            n--;
        }
        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next;
        return newHead.next;
    }
}

class ListNode {
	int val;
	ListNode next;
	ListNode(int x) {
		val = x;
	}
}