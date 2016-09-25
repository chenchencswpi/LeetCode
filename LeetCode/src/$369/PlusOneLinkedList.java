package $369;

class ListNode {
	int val;
	ListNode next;
	public ListNode(int val) {
		this.val = val;
	}
}

public class PlusOneLinkedList {
	public ListNode plusOne(ListNode head) {
        int carry = process(head, 1);
        if (carry != 0) {
            ListNode newHead = new ListNode(carry);
            newHead.next = head;
            head = newHead;
        }
        return head;
    }
    
    int process(ListNode node, int carry) {
        if (node.next == null) {
            carry += node.val;
            node.val = carry % 10;
            return carry / 10;
        }
        int newCarry = node.val + process(node.next, carry);
        node.val = newCarry % 10;
        return newCarry / 10;
    }
}
