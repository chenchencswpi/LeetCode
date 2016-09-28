package $116;

public class PopulatingNextRightPointersInEachNode {
	public void connect(TreeLinkNode root) {
        if (root == null) {
            return;
        }
        process(root.left, root.right);
    }
    
    void process(TreeLinkNode left, TreeLinkNode right) {
        if (left != null) {
            left.next = right;
            process(left.left, left.right);
            process(left.right, right.left);
            process(right.left, right.right);
        }
    }
}

class TreeLinkNode {
	int val;
	TreeLinkNode left, right, next;
	TreeLinkNode(int x) {
		val = x;
	}
}