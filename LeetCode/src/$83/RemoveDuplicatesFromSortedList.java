package $83;

public class RemoveDuplicatesFromSortedList {
	public ListNode deleteDuplicates(ListNode head) {
        ListNode newHead = new ListNode(-1);
        newHead.next = head;
        ListNode cursor = newHead;
        while (cursor.next != null && cursor.next.next != null) {
            if (cursor.next.val == cursor.next.next.val) {
                ListNode node = cursor.next.next;
                ListNode move = node.next;
                while (move != null && node.val == move.val) {
                    node = node.next;
                    move = move.next;
                }
                cursor.next = node;
            }
            cursor = cursor.next;
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