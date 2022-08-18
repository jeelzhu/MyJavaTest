package other;

public class IR {
    public static void main(String[] args) {
        // NOTE: The following input values will be used for testing your solution.
        int[] array1 = {1, 2, 3, 4, 5, 6, 7};
        int[] array2a = {4, 5, 6, 7, 8, 1, 2, 3};
        System.out.println(isRotation(array1, array2a)); //should return false.
        int[] array2b = {4, 5, 6, 7, 1, 2, 3};
        System.out.println( isRotation(array1, array2b));// should return true.
        int[] array2c = {4, 5, 6, 9, 1, 2, 3};
        System.out.println( isRotation(array1, array2c));// should return false.
        int[] array2d = {4, 6, 5, 7, 1, 2, 3};
        System.out.println( isRotation(array1, array2d));// should return false.
        int[] array2e = {4, 5, 6, 7, 0, 2, 3};
        System.out.println(isRotation(array1, array2e));// should return false.
        int[] array2f = {1, 2, 3, 4, 5, 6, 7};
        System.out.println(isRotation(array1, array2f));// should return true.
    }

    // Implement your solution below.
    public static Boolean isRotation(int[] array1, int[] array2) {
        int length1= array1.length;
        int length2 = array2.length;
        if (length1 != length2)
            return false;
        int offset  =0;
        boolean offsetFound = false;

        while(offset < length1){
            if (array1[0] == array2[offset]){
                offsetFound = true;
                break;
            }
            offset++;
        }

        if (!offsetFound)
            return false;

        int j;

        for (int i=0 ; i< length1; i++){
            j = i+offset;
            if (j >= length1 ){
                j = j-length1 ;
            }
            if (array1[i] != array2[j]){
                return false;
            }
        }
        return true;
    }
}
