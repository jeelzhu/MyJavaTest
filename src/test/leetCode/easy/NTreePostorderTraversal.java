package leetCode.easy;

import java.util.LinkedList;
import java.util.List;

class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
}

public class NTreePostorderTraversal {
    public List<Integer> postorder(Node root) {
        LinkedList<Node> stack = new LinkedList<>();
        LinkedList<Integer> output = new LinkedList<>();

        if (root == null)
            return output;

        stack.add(root);
        while(!stack.isEmpty()){
            Node n = stack.pollLast();
            output.addFirst(n.val);
            stack.addAll(n.children);

        }
        return output;




    }
}
