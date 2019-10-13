package leetCode;

public class MaximumDepthofBinaryTree {
    public static void main(String[] args) {
        TreeNode three = new TreeNode(3);
        TreeNode nine = new TreeNode(9);
        TreeNode twenty = new TreeNode(20);
        three.left = nine;
        three.right = twenty;
        TreeNode fifteen = new TreeNode(15);
        TreeNode seven = new TreeNode(7);

        twenty.left = fifteen;
        twenty.right = seven;

        System.out.println(maxDepth(three));


    }

    public static int maxDepth(TreeNode root) {
        return maxDepth(root, 0);

        /*

	if (root == null)
		return 0;
	return Math.max(1 + maxDepth(root.left), 1 + maxDepth(root.right));




	if (root == null)
		return 0;
	int maxDepthLeft = 1 + maxDepth(root.left);
        int maxDepthRight = 1 + maxDepth(root.right);

        if (maxDepthLeft > maxDepthRight)
            return maxDepthLeft;
        return maxDepthRight;


         */

    }

    public static int maxDepth(TreeNode node, int depth){
        if (node == null)
            return depth;

        return Math.max(maxDepth(node.left, depth+1), maxDepth(node.right, depth+1));



    }
}
