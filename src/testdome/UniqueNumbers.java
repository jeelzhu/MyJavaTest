package testdome;

import java.util.*;

public class UniqueNumbers {

    public static Collection<Integer> findUniqueNumbers(Collection<Integer> numbers) {
        Map<Integer, Integer> uniqueNumbersMap = new HashMap<>();
        numbers.forEach(integer -> {
            Integer value = uniqueNumbersMap.get(integer);
            if ( value == null){
                uniqueNumbersMap.put(integer, 1);
            }
            else{
                uniqueNumbersMap.put(integer, value+1);
            }
        });
        Set<Integer> uniqueNumbers = new HashSet<>();
        uniqueNumbersMap.forEach((key, value) ->{
            if (value ==1)
                uniqueNumbers.add(key);

        } );

        return uniqueNumbers;
    }

    public static void main(String[] args) {
        Collection<Integer> numbers = Arrays.asList(1, 2, 1, 3,1);
        for (int number : findUniqueNumbers(numbers))
            System.out.println(number);
    }
}
