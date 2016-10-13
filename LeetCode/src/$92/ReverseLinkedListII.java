package $92;

public class ReverseLinkedListII {
	public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode newHead = new ListNode(-1), cursor = newHead;
        newHead.next = head;
        int reverseLength = n - m + 1;
        while (m > 1) {
            cursor = cursor.next;
            head = head.next;
            m--;
        }
        ListNode dummy = new ListNode(-1), tail = null;
        while (reverseLength > 0) {
            ListNode next = head.next;
            head.next = dummy.next;
            if (dummy.next == null) {
                tail = head;
            }
            dummy.next = head;
            head = next;
            reverseLength--;
        }
        cursor.next = dummy.next;
        tail.next = head;
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