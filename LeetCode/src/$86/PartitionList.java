package $86;

public class PartitionList {
	public ListNode partition(ListNode head, int x) {
        ListNode smallHead = new ListNode(-1), largeHead = new ListNode(-1);
        ListNode small = smallHead, large = largeHead;
        while (head != null) {
            if (head.val < x) {
                small.next = head;
                small = small.next;
            } else {
                large.next = head;
                large = large.next;
            }
            head = head.next;
        }
        large.next = null;
        small.next = largeHead.next;
        return smallHead.next;
    }
}

class ListNode {
	int val;
	ListNode next;
	ListNode(int x) {
		val = x;
	}
}