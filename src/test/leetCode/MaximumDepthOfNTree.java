package leetCode;

import java.util.*;

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

public class MaximumDepthOfNTree {
    public int maxDepth(Node root) {
        if (root == null)
            return 0;

        Stack<Node> stack = new Stack<>();
        Stack<Integer> depthStack = new Stack<>();

        stack.add(root);
        int depth =1;
        depthStack.add(depth);

        while (!stack.isEmpty()){
            Node currentNode = stack.pop();
            final int currentDepth = depthStack.pop();
            if (currentNode!= null){
                depth = Math.max(depth,currentDepth);
                if (currentNode.children != null){
                    currentNode.children.forEach(node -> {
                        stack.add(node);
                        depthStack.add(currentDepth+1);
                    });

                }
            }

        }

        return depth;

        /*
        if (root == null)
            return 0;

        if (root.children == null || root.children.isEmpty())
            return 1;

        return Collections.max(root.children)*/

    }

    public static void main(String[] args) {
        Node five = new Node(5);
        Node six = new Node(6);
        List<Node> list1 = new ArrayList<>();
        list1.add(five);
        list1.add(six);

        Node three = new Node(3, list1);

        Node two = new Node(2);
        Node four = new Node(4);

        List<Node> list2 = new ArrayList<>();
        list2.add(two);
        list2.add(three);
        list2.add(four);





        Node one = new Node(1,list2);
        System.out.println(new MaximumDepthOfNTree().maxDepth(one));

    }
}
