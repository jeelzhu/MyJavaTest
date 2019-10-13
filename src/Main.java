import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Set;

public class Main {
    public static void main(String[] args) {

        LinkedHashMap<Integer, String> map = new LinkedHashMap<>();
        map.put(1, null);
        map.put(5, null);

        map.put(2, null);
        map.put(3, null);
        map.put(4, null);

        Set<Integer> keys = map.keySet();
        Integer[] arr = keys.toArray(new Integer[0]);

        for (int i = 0; i < arr.length; i++) {
            System.out.println(new Integer(i + 1)+   "    "+ arr[i]);
        }

    }
}

class Outer_Demo {
    int num;

    // inner class
    public class Inner_Demo {
         Inner_Demo(String string) {

        }
        private void print() {
            System.out.println("This is an inner class");
        }
    }

    // Accessing he inner class from the method within
    void display_Inner() {
        Inner_Demo inner = new Inner_Demo("");
        inner.print();
    }
}

class DFS {


    class Graphy{

        class Node {

        }
    }
}