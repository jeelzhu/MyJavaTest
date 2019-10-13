package SortingAlgorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SelectionSort {
    public static void main(String[] args) {
        Integer[] unsortedArray = {222,2,6,9,10,3, 99,4,1};
        SelectionSort s = new SelectionSort();
        s.sort(unsortedArray).forEach(integer -> System.out.printf(integer + ","));
    }

    public List<Integer> sort(Integer[] unsortedArray){
        List<Integer> unsortedList = new ArrayList<>(Arrays.asList(unsortedArray));
        int sizeOfUnsortedList = unsortedList.size();
        for(int i=0;i< sizeOfUnsortedList;i++) {

            int currentMin = i;
            int min = unsortedList.get(currentMin);
            for(int j=i;j< sizeOfUnsortedList;j++) {
                if (unsortedList.get(j) < min) {
                    min = unsortedList.get(j);
                    unsortedList.set(j, unsortedList.get(currentMin));
                    unsortedList.set(currentMin, min);

                }
            }
        }

        return unsortedList;
    }

    public List<Integer> sort222(Integer[] unsortedArray){
        List<Integer> sortedList = new ArrayList<>();
        int sizeOfArray = unsortedArray.length;
        List<Integer> unsortedList = new ArrayList<>(Arrays.asList(unsortedArray));
        while (sortedList.size() < sizeOfArray) {
            int currentMin = unsortedList.get(0);
            int position = 0;
            for(int i=1;i< unsortedList.size();i++) {
                if (unsortedList.get(i) < currentMin) {
                    currentMin = unsortedList.get(i);
                    position = i;
                }
            }
            sortedList.add(currentMin);
            unsortedList.remove(position);
        }

        return sortedList;
    }
}
