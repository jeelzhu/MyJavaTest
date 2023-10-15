package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;
    public TreeNode(int x) { val = x; }

    public List<Integer> retrieveLeaves(TreeNode root){
        if (root == null)
            return List.of();
           
        List<Integer> list = new ArrayList<>();    
        Stack<TreeNode> queue = new Stack<>();
        queue.add(root);

        while (!queue.isEmpty()){
            TreeNode node = queue.pop();
            if (node.left == null && node.right == null){
                list.add(node.val);
            } else if (node.left == null ){
                queue.add(node.right);
            } else {
                queue.add(node.left);
            }
        }
        return list;
    }
}
