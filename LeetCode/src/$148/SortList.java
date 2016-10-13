package $148;

public class SortList {
	public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode middle = getMiddle(head);
        ListNode newHead = middle.next;
        middle.next = null;
        return merge(sortList(head), sortList(newHead));
    }
    
    //here we assume the 2 lists are always valid
    ListNode merge(ListNode l1, ListNode l2) {
        ListNode newHead = new ListNode(-1), head = newHead;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                head.next = l1;
                l1 = l1.next;
            } else {
                head.next = l2;
                l2 = l2.next;
            }
            head = head.next;
        }
        if (l1 == null) {
            head.next = l2;
        }
        if (l2 == null) {
            head.next = l1;
        }
        return newHead.next;
    }
    
    //here we assume the list's length is always greater than 1
    ListNode getMiddle(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}

class ListNode {
	int val;
	ListNode next;
	ListNode (int x) {
		val = x;
	}
}