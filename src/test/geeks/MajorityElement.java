package geeks;

public class MajorityElement
{
    // Function to return majority element present in given array
    public static int majorityElement(int[] A)
    {
        int candidate = A[0];
        int counter = 1;
        int size = A.length;

        for (int i=1; i<size; i++){

            if (counter ==0){
                candidate =A[i];
                counter = 1;
            }

            if (candidate == A[i]){
                counter ++;
            }
            else {
                counter --;

            }

        }

        return candidate;

    }

    // main function
    public static void main (String[] args)
    {
        // Assumption - valid input (majority element is present)
        int[] arr = { 1, 8,1, 7, 4, 1, 2};

        System.out.println("Majority element is " + majorityElement(arr));
    }
}
