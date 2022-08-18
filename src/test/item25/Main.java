package other.effective_java.item25;

import java.util.*;

public class Main {
    private final Collections strings;

    public Main() {
        //strings = new ArrayList<String>();
        strings = null;

    }

    public void test(){

    }

    public static void main(String[] args) {
        //Collections strings = new Collections();
        //strings.add()
        List names = new ArrayList(); // warning: raw type!
        names.add("John");
        names.add("Mary");
        names.add(Boolean.FALSE); // not a compilation error!
        for (Object o : names) {
            String name = (String) o;
            System.out.println(name);
        }
        Set<String> set = new HashSet<>();



    }
    public <T> T[] toArray(T[] a){
        int size = 1;
        if (a.length < size){
            //return (T[])Arrays.copyOf(ele)

        }
        return a;
    }


}
