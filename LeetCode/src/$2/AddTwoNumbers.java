package $2;

public class AddTwoNumbers {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode newHead = new ListNode(-1);
        ListNode cursor = newHead;
        while (l1 != null || l2 != null) {
            if (l1 != null) {
                carry += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                carry += l2.val;
                l2 = l2.next;
            }
            cursor.next = new ListNode(carry % 10);
            cursor = cursor.next;
            carry /= 10;
        }
        if (carry != 0) {
            cursor.next = new ListNode(carry);
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
