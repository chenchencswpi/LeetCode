package linkedList;

/**
 * <a href="https://leetcode.com/problems/add-two-numbers/">原文链接</a>
 * You are given two linked lists representing two non-negative numbers. The digits are stored in reverse order and
 * each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
 * For example, (1 -> 2 -> 3) + (4 -> 5 -> 6) = (5 -> 7 -> 9).
 */

/**
 * 题目问的是给两个链表代表两个数字，数字是反向存储的，每个链表的node都是一个single digit。 求两个链表的和（还是以链表形式返回）。
 * 啥叫反向存储？说白了就是最不重要的位放在最开始的地方，也就是第一位是个位，第二位是十位，以此类推。
 */

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

public class AddTwoNumbers {
	/**
	 * 我们可以建立一个新的链表用来存储结果。同时需要维护一个carry variable，存的是两个链表对应位置（例如个位对个位，十位对十位）的相加的和。加完后，创立一个node，
	 * 将carry variable除以10得到的商放进去，然后将variable的十位的数字取出，参与下一轮的计算。为啥？想想咱小学时候学的两个数相加，比如5加7等于12，那咱就取2
	 * 进1。就是这么个理。
	 */

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

        if (res != 0) {	  //<--这个题的陷阱就在这儿。 如果carry varible还不是0，创建一个node给放进去。例如40 + 80 = 120, 这里的res就是那个１.
            runner.next = new ListNode(res);
        }

        return head.next;
    }
}
