package geeks;

class Node{
    public int data;
    public Node left;
    public Node right;


}

public class BST {
    public static void main(String[] args) {

        Node minusTen = new Node();
        minusTen.data = -10;

        Node zero = new Node();
        zero.data =0;

        Node two = new Node();
        two.data = 2;
        Node ten = new Node();
        ten.data  =10;
        ten.left = null;
        ten.right = two;

        System.out.println(isBST(ten));

    }

    public static boolean isBST(Node node){

        return isBST(node, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public static boolean isBST(Node node, Integer min, Integer max){
        if (node == null)
            return true;
        if (node.data > min && node.data< max)
            return isBST(node.left, Integer.MIN_VALUE, node.data) && isBST(node.right, node.data, Integer.MAX_VALUE);
        else
            return false;
    }





    /*

















    public static boolean isBST(Node root){
        return isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private static boolean isBST(Node root, int min, int max){
        if(root == null){
            return true;
        }
        if(root.data <= min || root.data > max){
            return false;
        }
        return isBST(root.left, min, root.data) && isBST(root.right, root.data, max);
    }

*/
    /*

    public int minValue(Node node){
        if (node.left == null && node.right == null)
            return node.key;
        else if (node.left != null && node.right == null)
            return node.left.key;

    }*/

    /*
    public int getRightNodeKey(Node node){
        int left, right;
        if (node.left == null && node.right == null)
            return node.key;
        else if (node.left != null && node.right != null){
            left =getLeftNodeKey(node.left);
            right = getRightNodeKey(node.right);
            if (left != -1 && right != -1
                    && left < node.key  && node.key < right)
                return left;
        }
        else if (node.left == null){
            right = getRightNodeKey(node.right);
            if (node.key < right )
                return node.key;
        }
        else {
            left =getLeftNodeKey(node.left);
            if (left < node.key)
                return left;

        }
        return -1;
    }

    public int getLeftNodeKey(Node node){
        int left, right;

        if (node.left == null && node.right == null)
            return node.key;
        else if (node.left != null && node.right != null){

            left =getLeftNodeKey(node.left);
            right = getRightNodeKey(node.right);
            if (left != -1 && right != -1
                    && left < node.key  && node.key < right)
                return right;

        }
        else if (node.left == null){
            right = getRightNodeKey(node.right);
            if (node.key < right )
                return right;

        }
        else {
            left =getLeftNodeKey(node.left);
            if (left < node.key)
                return node.key;
        }

        return -1;
    }
    */
}
