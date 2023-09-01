package leetcode.bfs;

import java.util.LinkedList;
import java.util.Queue;

import leetcode.TreeNode;



public class TestBfs {
    public static void main(String[] args) {
        System.out.println("TestBfs");
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
        test(root);
    }

    private static void test(TreeNode root){
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            System.out.print( node.val+"  ");
            if (node.left != null){
                queue.add(node.left);
            }
            if (node.right != null){
                queue.add(node.right);
            }
        }
    }
}
