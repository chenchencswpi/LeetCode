package $160;

public class IntersectionOfTwoLinkedLists {
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lenA = getLength(headA), lenB = getLength(headB);
        if (lenA > lenB) {
            int diff = lenA - lenB;
            while (diff > 0) {
                headA = headA.next;
                diff--;
            }
        }
        if (lenB > lenA) {
            int diff = lenB - lenA;
            while (diff > 0) {
                headB = headB.next;
                diff--;
            }
        }
        while (headA != null) {
            if (headA == headB) {
                return headA;
            }
            headA = headA.next;
            headB = headB.next;
        }
        return null;
    }
    
    int getLength(ListNode head) {
        int length = 0;
        while (head != null) {
            length++;
            head = head.next;
        }
        return length;
    }
}

class ListNode {
	int val;
	ListNode next;
	ListNode(int x) {
		val = x;
	}
}