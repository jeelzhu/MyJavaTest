package leetCode;

import java.math.BigInteger;

class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }

public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return createListNode(getValue(l1).add(getValue(l2)));
    }

    public BigInteger getValue(ListNode l){
        BigInteger value = BigInteger.valueOf(l.val);
        BigInteger base = BigInteger.ONE;
        ListNode next = l.next;
        while(next != null){
            base = base.multiply(BigInteger.valueOf(10));
            value = value.add(base.multiply(BigInteger.valueOf(next.val)));
            next = next.next;
        }
        return value;
    }

    public ListNode createListNode(BigInteger value){
        BigInteger base ;
        ListNode l = null;
        ListNode current = null;
        if (value.equals(BigInteger.ZERO))
            return new ListNode(0);


        while (value.compareTo(BigInteger.ZERO) ==1 ){
            base = value.remainder(BigInteger.valueOf(10));
            value = value.divide(BigInteger.valueOf(10));
            if (l == null) {
                l = new ListNode(base.intValue());
                current = l;
            }
            else{
                current.next = new ListNode(base.intValue());
                current = current.next;
            }
        }
        return l;

    }

    public static void main(String[] args) {
        //System.out.println(3 /10);

        /*
        ListNode three = new ListNode(3);
        ListNode four = new ListNode(4);
        four.next = three;
        ListNode two = new ListNode(2);
        two.next = four;*/

        int test =  999999991;
        //int test2 = 9000000000;
        //long test3 = test + test2;
        //System.out.println(test + test2);

        ListNode n1 = new ListNode(9);
        ListNode n2 = new ListNode(9);
        n2.next = n1;
        ListNode n3 = new ListNode(9);
        n3.next = n2;
        ListNode n4 = new ListNode(9);
        n4.next = n3;
        ListNode n5 = new ListNode(9);
        n5.next = n4;
        ListNode n6 = new ListNode(9);
        n6.next = n5;
        ListNode n7 = new ListNode(9);
        n7.next = n6;
        ListNode n8 = new ListNode(9);
        n8.next = n7;
        ListNode n9 = new ListNode(9);
        n9.next = n8;
        ListNode one = new ListNode(1);
        one.next = n9;


        new AddTwoNumbers().getValue(one);
    }


}
