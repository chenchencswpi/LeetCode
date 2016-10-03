package $99;

public class RecoverBinarySearchTree {
	TreeNode first, second, pre;
    public void recoverTree(TreeNode root) {
        inorder(root);
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }
    
    void inorder(TreeNode node) {
        if (node == null) {
            return;
        }
        inorder(node.left);
        if (pre == null) {
            pre = node;
        } else {
            if (node.val < pre.val) {
                if (first == null) {
                    first = pre;
                }
                second = node;
            }
            pre = node;
        }
        inorder(node.right);
    }
}

class TreeNode {
	int val;
	TreeNode left, right;
	TreeNode(int x) {
		val = x;
	}
}