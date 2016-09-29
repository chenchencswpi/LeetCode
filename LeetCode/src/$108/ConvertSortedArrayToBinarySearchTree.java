package $108;

public class ConvertSortedArrayToBinarySearchTree {
	public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0) {
        	return null;
        }
        return process(nums, 0, nums.length - 1);
    }
	
	TreeNode process(int[] nums, int left, int right) {
		if (left > right) {
			return null;
		}
		int middle = left + (right - left) / 2;
		TreeNode node = new TreeNode(nums[middle]);
		node.left = process(nums, left, middle - 1);
		node.right = process(nums, middle + 1, right);
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