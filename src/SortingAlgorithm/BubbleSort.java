package SortingAlgorithm;

public class BubbleSort implements SortingAlgorithm {
    public static void main(String[] args) {

        int[] unsortedArray = {222,2,6,9,10,3, 99,4,1};//{5 ,1 ,4, 2, 8};//
        //int[] sortedArray =
        BubbleSort bubbleSort = new BubbleSort();
        //bubbleSort.sort(unsortedArray);
        bubbleSort.recursionSort(unsortedArray, unsortedArray.length);

        SortingUtil.print(unsortedArray);
    }

    @Override
    public void sort(int[] unsortedArray) {
        int size = unsortedArray.length;
        for(int i=0; i< size-1; i++){
            //System.out.println("i="+i);
            for (int j=0; j< size-i-1; j++){
                //System.out.println("j="+j);

                if (unsortedArray[j] > unsortedArray[j+1]){
                    int temp = unsortedArray[j];
                    unsortedArray[j] = unsortedArray[j+1];
                    unsortedArray[j+1] = temp;
                }
            }
            //System.out.println("=======");
        }
    }

    public void recursionSort(int[] unsortedArray, int n) {
        if (n == 1)
            return ;
        for (int i= 0; i < n-1; i++){
            if (unsortedArray[i] > unsortedArray[i+1]){
                int temp = unsortedArray[i];
                unsortedArray[i] = unsortedArray[i+1];
                unsortedArray[i+1] = temp;
            }
        }
        recursionSort(unsortedArray, n-1);

    }
}
