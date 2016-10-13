package $61;

public class RotateList {
	public ListNode rotateRight(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        k %= getLength(head);
        if (k == 0) {
            return head;
        }
        ListNode l1 = head, l2 = head;
        while (k > 0) {
            l2 = l2.next;
            k--;
        }
        while (l2.next != null) {
            l1 = l1.next;
            l2 = l2.next;
        }
        ListNode newHead = l1.next;
        l1.next = null;
        l2.next = head;
        return newHead;
    }
    
    int getLength(ListNode head) {
        int count = 0;
        while (head != null) {
            count++;
            head = head.next;
        }
        return count;
    }
}

class ListNode {
	int val;
	ListNode next;
	ListNode(int x) {
		val = x;
	}
}