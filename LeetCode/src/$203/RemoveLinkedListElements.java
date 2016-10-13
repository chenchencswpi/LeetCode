package $203;

public class RemoveLinkedListElements {
	public ListNode removeElements(ListNode head, int val) {
        ListNode newHead = new ListNode(-1), cursor = newHead;
        newHead.next = head;
        while (head != null) {
            if (head.val != val) {
                cursor = cursor.next;
                head = head.next;
            } else {
                head = head.next;
                cursor.next = head;
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