package leetcode.dfs;
/*
 * Given the root of a binary tree and an integer targetSum, return true if the tree has a root-to-leaf path such that adding up all the numbers along the path equals targetSum.
 * 
General Steps for DFS:
Start from a node (usually the root for tree problems).
Check for the base case or a stopping condition.
Visit the node and mark it as visited.
Go to an unvisited adjacent node and start a new DFS.
 */

import java.util.Stack;

import leetcode.TreeNode;



public class TestTreeNode {
    public static void main(String[] args) {
        System.out.println("TestTreeNode");
        TreeNode root = new TreeNode(5);
        TreeNode left = new TreeNode(4);
        TreeNode right = new TreeNode(8);
        root.left = left;
        root.right = right;
        TreeNode leftLeft = new TreeNode(11);
        left.left = leftLeft;
        TreeNode leftLeftLeft = new TreeNode(7);
        TreeNode leftLeftRight = new TreeNode(2);
        leftLeft.left = leftLeftLeft;
        leftLeft.right = leftLeftRight;
        TreeNode rightLeft = new TreeNode(13);
        TreeNode rightRight = new TreeNode(4);
        right.left = rightLeft;
        right.right = rightRight;
        TreeNode rightRightRight = new TreeNode(1);
        rightRight.right = rightRightRight;
        TestTreeNode testTreeNode = new TestTreeNode();
        System.out.println(testTreeNode.hasPathSum(root, 9));
    }
    public boolean hasPathSum(TreeNode root, int targetSum) {
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while(!stack.isEmpty()){
            TreeNode node = stack.pop();
            System.out.print( node.val+"  ");
            if (node.right != null){
                stack.push(node.right);
            }
            if (node.left != null){
                stack.push(node.left);
            }
        }

        return false;
    }
}



