package leetCode.binarySearch;

public class BinarySearch {

    public static void main(String[] args) {
        System.out.println(9/2);

        //new other.BinarySearch().search(new int[]{-1, 0, 3, 5, 9, 12}, 9);
    }



    public int searchRecursion(int[] nums, int target) {
        if (nums == null || nums.length ==0)
            return -1;


        return -1;

    }

    public static int recursiveBinarySearch(int[] sortedArray, int start, int end, int key) {

        if (start < end) {
            int mid = start + (end - start) / 2;
            if (key < sortedArray[mid]) {
                return recursiveBinarySearch(sortedArray, start, mid, key);

            } else if (key > sortedArray[mid]) {
                return recursiveBinarySearch(sortedArray, mid+1, end , key);

            } else {
                return mid;
            }
        }
        return -(start + 1);
    }



    public int search(int[] nums, int target) {
        int startindex = 0;
        int endindex = nums.length - 1;
        while (startindex <= endindex) {
            int midindex = startindex + (endindex - startindex)/2;
            System.out.println(midindex);

            if (target == nums[midindex]){
                return midindex;
            }

            else if (target > nums[midindex]) {
                startindex = midindex + 1;
            }

            else {
                endindex = midindex - 1;
            }
        }
        return -1;


        /*
        int length = nums.length;
        int count =0;
        int index;
        while(count < length){
            index = length/2;
            if (nums[index] == target)
                return index;
            else if (nums[index] > target){
                count ++;
                index = index/2;
            }
            else{
                count ++;
                index = (index + length)/2;
            }

        }
        return -1;*/

    }
}
