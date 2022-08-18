package other;

import java.util.HashMap;
import java.util.Map;

public class MF {
    public static void main(String[] args) {
        // NOTE: The following input values are used for testing your solution.

        // mostFrequent(array1) should return 1.
        int[] array1 = {1, 3, 1, 3, 2, 1};
        // mostFrequent(array2) should return 3.
        int[] array2 = {3, 3, 1, 3, 2, 1};
        // mostFrequent(array3) should return null.
        int[] array3 = {};
        // mostFrequent(array4) should return 0.
        int[] array4 = {0};
        // mostFrequent(array5) should return -1.
        int[] array5 = {0, -1, 10, 10, -1, 10, -1, -1, -1, 1};
        System.out.println(mostFreqent(array1));
        System.out.println(mostFreqent(array2));
        System.out.println(mostFreqent(array3));
        System.out.println(mostFreqent(array4));
        System.out.println(mostFreqent(array5));
    }

    // Implement your solution below.
    public static Integer mostFreqent(int[] givenArray) {
        Integer maxItem = null;
        Integer max = null;
        int length = givenArray.length;
        if ( length > 0){
            if (length == 1){
                maxItem = givenArray[0];
            }
            else {
                Map<Integer, Integer> map = new HashMap<>();
                for (int i=0; i< length; i++){
                    if (map.get(givenArray[i]) == null)
                    {
                        map.put(givenArray[i], 1);

                    }
                    else {
                        map.put(givenArray[i], map.get(givenArray[i])+1);

                    }
                    if (maxItem == null) {
                        maxItem = givenArray[i];
                        max = map.get(maxItem);
                    }
                    else if (map.get(givenArray[i]) > max){
                        maxItem = givenArray[i];
                        max =map.get(givenArray[i]);
                    }



                }


            }

        }


        return maxItem;
    }
}
