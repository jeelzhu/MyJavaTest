package other;

public class BinarySearch {

    public boolean search(int[] array, int target)  {
        if (array == null || array.length ==0){
            return false;
        }
        int start =0;
        int end = array.length-1;
        int mid;

        while(start < end){
            mid = (end+start)/2;
            if (array[mid]> target)
                end = mid;
            else if (array[mid] < target)
                start = mid+1;
            else
                return true;
            System.out.println("start = "+start +" end = "+end);
        }

        return false;

    }

    public static void main(String[] args) {
        //int[] array = {1,3,4,6,7};
        int[] array = {1,3,4,6,7,8,10,15,16,19,22,43,56,66,88,123};

        System.out.println(new BinarySearch().search(array, 88
        ));

    }
}
