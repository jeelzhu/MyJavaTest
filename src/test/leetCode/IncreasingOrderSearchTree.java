package leetCode;

public class IncreasingOrderSearchTree {
    private TreeNode currentNode;
    private TreeNode newRootNode;

    public TreeNode increasingBST(TreeNode root) {
        reorder(root);
        return newRootNode;


    }

    public void reorder(TreeNode node){
        if (node == null)
            return;
        reorder(node.left);

        if (newRootNode == null){
            currentNode = new TreeNode(node.val);
            newRootNode = currentNode;
        }
        else{
            TreeNode newNode = new TreeNode(node.val);
            currentNode.right = newNode;
            currentNode = currentNode.right;
        }

        reorder(node.right);

    }
}
