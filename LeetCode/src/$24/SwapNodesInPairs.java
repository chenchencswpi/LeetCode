package $24;

public class SwapNodesInPairs {
	public ListNode swapPairs(ListNode head) {
        ListNode newHead = new ListNode(-1);
        newHead.next = head;
        ListNode cursor = newHead;
        while (cursor.next != null && cursor.next.next != null) {
            ListNode first = cursor.next;
            ListNode second = first.next;
            ListNode next = second.next;
            cursor.next = second;
            second.next = first;
            first.next = next;
            cursor = first;
        }
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