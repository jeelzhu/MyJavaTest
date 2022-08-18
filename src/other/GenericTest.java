package other;

import java.util.List;
import java.util.Optional;

public class GenericTest {
    public static void main(String[] args) {
        List list;
        Optional o = GenericTest.empty("sdfsa");

    }

    static <T> Optional<T> empty(T t){
        return Optional.empty();
    }
}
