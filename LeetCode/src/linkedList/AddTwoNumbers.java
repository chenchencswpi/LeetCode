package linkedList;

/**
 * <a href="https://leetcode.com/problems/add-two-numbers/">原文链接</a>
 * You are given two linked lists representing two non-negative numbers. The digits are stored in reverse order and
 * each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
 * For example, (1 -> 2 -> 3) + (4 -> 5 -> 6) = (5 -> 7 -> 9).
 */

/**
 * 我们可以建立一个新的链表用来存储结果。同时需要维护一个carry variable，存的是两个链表对应位置（例如个位对个位，十位对十位）的相加的和。
 * 未完待续。。。
 */

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        int res = 0;
        ListNode head = new ListNode(-1);   //helper node
        ListNode runner = head;

        while (l1 != null || l2 != null) {
            if (l1 != null) {
                res += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                res += l2.val;
                l2 = l2.next;
            }

            runner.next = new ListNode(res % 10);
            res /= 10;
            runner = runner.next;
        }

        if (res != 0) {
            runner.next = new ListNode(res);
        }

        return head.next;
    }
}
