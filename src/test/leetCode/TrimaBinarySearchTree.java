package leetCode;

public class TrimaBinarySearchTree {
    public TreeNode trimBST(TreeNode root, int L, int R) {
        if (root == null)
            return null;
        TreeNode head = root;

        if (root.val >= L && root.val <= R){
            head.right = trimBST(root.right, L, R);
            head.left = trimBST(root.left, L, R);
        }
        else{
            if (root.val < L){
                head = trimBST(head.right, L, R);
            }
            else {
                head = trimBST(head.left, L, R);
            }
        }

        return head;












        /*
        if (root == null)
            return null;

        if (root.val >= L && root.val <= R){
            trimBST(root.left, L, R);
            trimBST(root.right, L, R);
        }
        else{
            if (root.val < L){

            }


        }*/
        /*

        if(root==null){
            return null;
        }
        TreeNode head = root;
        if(root.val>=L && root.val<=R){
            head.left = trimBST(head.left,L,R);
            head.right = trimBST(head.right,L,R);
        }else{
            if(root.val<L){
                head = root.right;
            }else{
                head = root.left;
            }
            root=null;
            return trimBST(head,L,R);
        }
        return head;*/

    }
}
