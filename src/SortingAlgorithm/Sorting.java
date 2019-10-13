package SortingAlgorithm;

public class Sorting {
    public static void main(String[] args) {
        int[] unsortedArray = {49, 14, 7, 222, 2, 6, 9, 10, 3, 99, 4, 1};//{5 ,1 ,4, 2, 8};//
        Sorting sorting = new Sorting();
        sorting.iterativeMergeSort(unsortedArray);
        //sorting.recursionMergeSort(unsortedArray, 0, unsortedArray.length - 1);
        SortingUtil.print(unsortedArray);

    }

    public void iterativeMergeSort(int[] array) {
        //int left = 0;
        int size = array.length;
        //int right = size-1;
        System.out.println("size=" + size);

        for (int i = 1; i < size; i = i * 2) {
            System.out.println(" i="+i);
            for (int j = 0; j < size; j +=  i*2) {
                //System.out.print(" j ="+j+" j+(2*i)="+(j+(2*i))+" ,");
                int left = j;
                int middle = i+j-1;
                int right = j + 2 * i-1;
                if (right>= size)
                    right = size - 1;
                System.out.print(" left =" + left + " right = " + right + " ,");
                merge(array, left,middle, right);

            }
            System.out.print("\n----------------------------------------\n");

        }

    }

    public void merge(int[] array, int left, int right) {
        int middle = (left + right)/2;
        merge(array, left, middle, right);
    }




    public void merge(int[] array, int left, int middle, int right) {
        int n1 = middle - left + 1;
        int n2 = right - middle;

        int[] leftArray = new int[n1];
        int[] rightArray = new int[n2];

        for (int i = 0; i < n1; i++) {
            leftArray[i] = array[left + i];
        }
        for (int j = 0; j < n2; j++) {
            rightArray[j] = array[j + middle + 1];
        }

        int i = 0;
        int j = 0;
        int k = left;
        while (i < n1 && j < n2) {
            if (leftArray[i] > rightArray[j]) {
                array[k] = rightArray[j];
                j++;
            } else {
                array[k] = leftArray[i];
                i++;
            }
            k++;
        }

        while (i < n1) {
            array[k] = leftArray[i];
            i++;
            k++;
        }

        while (j < n2) {
            array[k] = rightArray[j];
            j++;
            k++;
        }
    }
}
