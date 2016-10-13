package $234;

public class PalindromeLinkedList {
	public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        ListNode slow = head, fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        fast = slow.next;
        slow.next = null;
        ListNode dummy = new ListNode(-1);
        while (fast != null) {
            ListNode next = fast.next;
            fast.next = dummy.next;
            dummy.next = fast;
            fast = next;
        }
        fast = dummy.next;
        while (fast != null) {
            if (head.val != fast.val) {
                return false;
            }
            head = head.next;
            fast = fast.next;
        }
        return true;
    }
}

class ListNode {
	int val;
	ListNode next;
	ListNode(int x) {
		val = x;
	}
}