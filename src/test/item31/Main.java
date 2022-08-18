package other.effective_java.item31;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Stack<Number> numberStack = new Stack<>();
        Iterable<Integer> integers = new HashSet<>();
        //numberStack.addAll(integers);

    }

    public static Set union(Set s1, Set s2){
        Set result = new HashSet(s1);
        result.addAll(s2);
        return result;
    }
}
