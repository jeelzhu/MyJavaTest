package SortingAlgorithm;

public class InsertionSort {
    public static void main(String[] args) {
        int[] unsortedArray = {222,2,6,9,10,3, 99,4,1};
        //int[] sortedArray =
        InsertionSort insertionSort = new InsertionSort();
        insertionSort.recursionSort(unsortedArray, unsortedArray.length);
        SortingUtil.print(unsortedArray);
    }

    public void recursionSort(int[] unsortedArray, int n)  {
        if (n == 1)
            return;

        recursionSort(unsortedArray, n-1);

        int key = unsortedArray[n-1];
        int j= n-2;


        while (j>=0 && unsortedArray[j] > key){
            unsortedArray[j+1] = unsortedArray[j];
            j = j-1;
        }
        unsortedArray[j+1] = key;
    }

    public void sort(int[] unsortedArray)  {
        for (int i=1 ; i< unsortedArray.length; i++) {
            int key = unsortedArray[i];
            int j = i -1;

            while (j>=0 && unsortedArray[j] > key){
                unsortedArray[j+1] = unsortedArray[j];
                j = j-1;
            }
            unsortedArray[j+1] = key;
        }

        /*
        // My first implementation
        for (int i=1 ; i< unsortedArray.length; i++) {

            for (int j=0; j< i; j++) {
                if (unsortedArray[j] > unsortedArray[i]){
                    int temp =  unsortedArray[j];
                    unsortedArray[j] = unsortedArray[i];
                    unsortedArray[i] = temp;

                }
            }

        }*/

    }
}
