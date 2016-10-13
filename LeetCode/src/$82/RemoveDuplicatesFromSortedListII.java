package $82;

public class RemoveDuplicatesFromSortedListII {
	public ListNode deleteDuplicates(ListNode head) {
        ListNode newHead = new ListNode(-1);
        newHead.next = head;
        ListNode cursor = newHead;
        while (cursor.next != null && cursor.next.next != null) {
            if (cursor.next.val == cursor.next.next.val) {
                ListNode node = cursor.next.next;
                ListNode move = node.next;
                while (move != null && node.val == move.val) {
                    move = move.next;
                    node = node.next;
                }
                cursor.next = move;
            } else {
                cursor = cursor.next;
            }
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