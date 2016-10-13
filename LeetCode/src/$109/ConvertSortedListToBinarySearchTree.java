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

class Solution {
	ListNode curr;
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null;
        }
        curr = head;
        int length = getLength(head);
        return dfs(1, length);
    }
    
    TreeNode dfs(int start, int end) {
        if (start > end) {
            return null;
        }
        int middle = start + (end - start) / 2;
        TreeNode left = dfs(start, middle - 1);
        TreeNode root = new TreeNode(curr.val);
        curr = curr.next;
        root.left = left;
        root.right = dfs(middle + 1, end);
        return root;
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