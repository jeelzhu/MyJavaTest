package other;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CE {
    public static void main(String[] args) {
        // NOTE: The following input values are used for testing your solution.

        int[] array1A = {1, 3, 4, 6, 7, 9};
        int[] array2A = {1, 2, 4, 5, 9, 10};
        // commonElements(array1A, array2A) should return [1, 4, 9] (an array).

        int[] array1B = {1, 2, 9, 10, 11, 12};
        int[] array2B = {0, 1, 2, 3, 4, 5, 8, 9, 10, 12, 14, 15};
        // commonElements(array1B, array2B) should return [1, 2, 9, 10, 12] (an array).

        int[] array1C = {0, 1, 2, 3, 4, 5};
        int[] array2C = {6, 7, 8, 9, 10, 11};
        // common_elements(array1C, array2C) should return [] (an empty array).
        commonElements(array1A, array2A);
        System.out.println();
        commonElements(array1B, array2B);
        System.out.println();

        commonElements(array1C, array2C);
    }

    // Implement your solution below.
    // NOTE: Remember to return an Integer array, not an int array.
    public static Integer[] commonElements(int[] array1, int[] array2) {
        Set<Integer> tempSet = new HashSet<>();
        List<Integer> integerList = new ArrayList<>();
        Integer[] results;
        for (int i =0; i< array1.length; i++){
            tempSet.add(array1[i]);
        }
        int size =0;
        for (int i =0; i< array2.length; i++) {
            if(tempSet.contains(array2[i])){
                integerList.add(array2[i]);
                //System.out.print(array2[i]+"  ");
                size++;
            }
        }
        results = new Integer[size];
        return integerList.toArray(results);
    }
}
