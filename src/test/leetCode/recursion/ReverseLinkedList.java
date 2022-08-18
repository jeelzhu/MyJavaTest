package leetCode.recursion;


class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
}
public class ReverseLinkedList {
    public static void main(String[] args) {
        ListNode one = new ListNode(1);
        ListNode two = new ListNode(2);
        ListNode three = new ListNode(3);
        ListNode four = new ListNode(4);
        ListNode five = new ListNode(5);

        one.next = two;
        two.next = three;
        three.next = four;
        four.next = five;

        new ReverseLinkedList().reverseList(one);
    }

    public ListNode reverseListRecursively(ListNode head) {

        if (head == null || head.next == null)
            return head;

        ListNode p = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return p;

    }

    public ListNode reverseList(ListNode head) {
        ListNode current = head;
        ListNode newNode = null;
        ListNode tmp ;
        while(current!=null){
            tmp = current.next;
            current.next = newNode;
            newNode = current;
            current = tmp;
        }
        return newNode;

    }
}
