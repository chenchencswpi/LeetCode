package $109;

import java.util.HashMap;

public class ConvertSortedListToBinarySearchTree {
	public TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null;
        }
        HashMap<Integer, ListNode> map = new HashMap<>();
        int counter = 0;
        while (head != null) {
            map.put(counter++, head);
            head = head.next;
        }
        return process(map, 0, counter - 1);
    }
    
    TreeNode process(HashMap<Integer, ListNode> map, int left, int right) {
        if (left > right) {
            return null;
        }
        int middle = left + (right - left) / 2;
        TreeNode node = new TreeNode(map.get(middle).val);
        node.left = process(map, left, middle - 1);
        node.right = process(map, middle + 1, right);
        return node;
    }
}

class TreeNode {
	int val;
	TreeNode left, right;
	TreeNode(int x) {
		val = x;
	}
}

class ListNode {
	int val;
	ListNode next;
	ListNode(int x) {
		val = x;
	}
}