package $328;

public class OddEvenLinkedList {
	public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return head;
        }
        ListNode oddHead = head, evenHead = head.next;
        ListNode oddCursor = oddHead, evenCursor = evenHead;
        while (evenCursor != null) {
            ListNode oddNext = evenCursor.next;
            if (oddNext == null) {
                oddCursor.next = null;
                break;
            }
            ListNode evenNext = oddNext.next;
            oddCursor.next = oddNext;
            evenCursor.next = evenNext;
            oddCursor = oddNext;
            evenCursor = evenNext;
        }
        oddCursor.next = evenHead;
        return oddHead;
    }
}

class ListNode {
	int val;
	ListNode next;
	ListNode(int x) {
		val = x;
	}
}