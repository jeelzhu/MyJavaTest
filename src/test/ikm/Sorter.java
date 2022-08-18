package ikm;

import java.util.*;
import java.util.function.*;
class Namer {
    final private String firstName,lastName;
    public Namer(String fn,String ln) { firstName=fn; lastName=ln;}
    public String getFirstName() { return firstName; }
    public String getLastName()  { return lastName;  }
}
class Sorter {
    public static void main(String[] args) {
        Consumer<Namer> printit = e -> System.out.println(e.getFirstName() + " " + e.getLastName());
        List<Namer> names = new ArrayList(Arrays.asList(
                new Namer("Harry","Smith"),new Namer("Joe","Smith"),new Namer("Jane","Doe"),
                new Namer("Mary","Jane"),new Namer("Harry","Homeowner")));

        Comparator<Namer> groupBy = Comparator.comparing(e -> e.getFirstName());
        groupBy = groupBy.thenComparing(e -> e.getLastName());
        names.removeIf(e -> e.getFirstName().equals("Mary"));
        names.sort(groupBy);
        names.forEach(printit);

    }
}

