package leetCode;

public class BinarySearch {

    public static void main(String[] args) {
        new BinarySearch().search(new int[]{-1, 0, 3, 5, 9, 12}, 9);
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
