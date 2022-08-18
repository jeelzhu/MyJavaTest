package codility;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class PermCheck {
    public static void main(String[] args) {

        int[] A = new int[4];

        /*
        A[0] = 4;
        A[1] = 9;
        A[2] = 3;
        A[3] = 2; */

        A[0] = 2;
        A[1] = 5;
        A[2] = 1;
        A[3]=3;


        System.out.println(solution(A));
        //System.out.println(solution2(A));

    }


    public static int solution(int[] A) {
        //Arrays.sort(A);

        int n = A.length;

        double sum =  ((Math.pow(n, 2) + 3 * n + 2) / 2);
        System.out.println(sum);

        for (int i=0; i< A.length;i++){
            sum -= A[i];

        }
        return (int) sum;

   /*
        int n = A.length;
        double sum = (Math.pow(n, 2) + 3 * n + 2) / 2;
        System.out.println(sum);
        double total = 0;
        for (double a : A) total += a;

        return (int) (sum - total);*/
    }
}
