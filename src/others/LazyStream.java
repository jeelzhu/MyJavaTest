package others;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LazyStream {
    public static void main(String[] args) {
        // Initialize a List of integers
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 9, 10, 15, 20);
        
        // Use the Stream API to filter and transform the list
        // List<Integer> filteredAndTransformedNumbers = numbers.stream()
        //     .filter(n -> n >= 10) // Filter numbers that are greater or equal to 10
        //     .map(n -> n * 2)      // Double the filtered numbers
        //     .collect(Collectors.toList()); // Collect the result into a new List

        Stream<Integer> stream = numbers.stream()
            .filter(n -> {
                System.out.println("filtering");
                return n >= 10;
            }) 
            .map(n -> n * 2);      
        
        // Print the original and transformed lists
        System.out.println("Original List: " + numbers);
        //System.out.println("Filtered and Transformed List: " + filteredAndTransformedNumbers);
        System.out.println("-------------------------------------");
        test(stream);
    }

    private static void test(Stream<Integer> stream){
        List<Integer> list = stream.collect(Collectors.toList());
        System.out.println(list);
    }
}
