package ikm;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class JavaClass {
    public static void main(String arg[]) {

        Long l = new Long(1234);
        Long l1 = l;
        if(l==l1)
            System.out.println("Equal Objects");
        else
            System.out.println("Not Equal Objects");
        l++;
        if(l==l1)
            System.out.println("Equal Objects");
        else
            System.out.println("Not Equal Objects");


        System.out.println();    }
    public void meth(String[] arg) {
        System.out.println(arg);
        System.out.println(arg[1]);
    }
}
