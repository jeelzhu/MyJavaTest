package other.mosh;

import java.util.Arrays;
import java.util.NoSuchElementException;

public class LinkedList {
    private class Node {
        private int value;
        private Node next;
        private Node(int value){
            this.value = value;
        }
    }
    private Node first;
    private Node last;
    private int size=0;

    private void addLast(int item){
        Node node = new Node(item);
        if (first == null )
            first = last = node;
        else{
            last.next = node;
            last = node;
        }
        size++;
    }

    private void addFirst(int item){
        Node node = new Node(item);
        if (first == null )
            first = last = node;
        else{
            node.next = first;
            first = node;
        }
        size++;
    }

    private int indexOf(int item){
        int index =0;
        Node current = first;
        while(current != null){
            if (current.value == item)
                return index;
            index++;
            current = current.next;
        }
        return -1;
    }

    public boolean contains(int item){
        return indexOf(item)!= -1;
    }

    public void removeFirst(){
        if (first == null)
            throw new NoSuchElementException("");
        if (first == last){
            first = last = null;
            size =0;
            return;
        }
        Node current = first.next;
        first.next = null;
        first = current;
        size--;
    }

    public void removeLast() {
        if (first == null)
            throw new NoSuchElementException("");
        if (first == last){
            first = last = null;
            size =0;
            return;
        }
        Node current = first;
        while(current!= null){
            if(current.next == last)
                break;
            current = current.next;
        }

        last = current;
        last.next = null;
        size--;
    }

    public int size(){
        return size;
    }

    public int[] toArray(){
        int[] arr = new int[size];
        int count =0;
        Node current = first;
        while(current!= null){
            arr[count++] = current.value;
            current = current.next;
        }
        return arr;
    }

    public void reverse2(){
        LinkedList newList = new LinkedList();
        int[] arr = this.toArray();
        for (int i= 0; i<arr.length; i++){
            newList.addFirst(arr[i]);
        }
        first = newList.first;
        last = newList.last;
    }

    public void reverse() {
        if (first == null) return;
        Node previous = first;
        Node current = previous.next;
        while(current != null){
            Node next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }

        last = first;
        last.next = null;
        first = previous;
    }

    public static void main(String[] args) {
        int[] arr = new int[0];

        LinkedList linkedList = new LinkedList();
        /*linkedList.addLast(10);
        linkedList.addLast(20);
        linkedList.addLast(30);
        linkedList.addLast(40);
        linkedList.addLast(50);
        linkedList.addLast(60);*/
        System.out.println(linkedList.indexOf(300));
        System.out.println(Arrays.toString(linkedList.toArray()));

        linkedList.reverse();

        System.out.println(Arrays.toString(linkedList.toArray()));
    }
}
