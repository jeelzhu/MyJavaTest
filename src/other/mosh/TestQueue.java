package other.mosh;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class TestQueue {
    public static void main(String[] args) {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(10);
        queue.add(20);
        queue.add(30);
        System.out.println(queue);
        reverse(queue);
        //queue = new ArrayDeque<>();
        System.out.println(queue);

        List<Integer> list = new ArrayList<>();
        list.add(10);
        test(list);
        System.out.println(list);

        Integer i = 10;
        test2(i);
        System.out.println(i);

        Integer bar = new Integer(99);
        Integer a = bar;
        Integer b = bar;
        bar = null;

        System.out.println(a);
        System.out.println(b);

    }

    public static void test2(Integer i) {
        i = new Integer(99);
    }


    public static void test(List<Integer> list) {
        list = null;
    }

    public static void reverse(Queue<Integer> queue){
        //add()
        //remove()
        //isEmpty()
        /*
        if (queue.isEmpty())
            throw new IllegalStateException();

        Queue<Integer> newQueue = new ArrayDeque<>();
        while(!queue.isEmpty()) {
            newQueue.add(queue.remove());
        }
        queue = newQueue;
        */

        queue.add(40);
        queue = null;
        System.out.println();

    }
}
