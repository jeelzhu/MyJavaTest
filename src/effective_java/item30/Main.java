package effective_java.item30;

import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {


    }

    public static Set union(Set s1, Set s2){
        Set result = new HashSet(s1);
        result.addAll(s2);
        return result;
    }
}
