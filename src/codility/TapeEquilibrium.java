package codility;

/*
A non-empty zero-indexed array A consisting of N integers is given. Array A represents numbers on a tape.
Any integer P, such that 0 < P < N, splits this tape into two non−empty parts: A[0], A[1], …, A[P − 1] and A[P], A[P + 1], …, A[N − 1].
The difference between the two parts is the value of: |(A[0] + A[1] + … + A[P − 1]) − (A[P] + A[P + 1] + … + A[N − 1])|
In other words, it is the absolute difference between the sum of the first part and the sum of the second part.

Write a function that, given a non-empty zero-indexed array A of N integers, returns the minimal difference that can be achieved.

Example:
      A[0] = 3
      A[1] = 1
      A[2] = 2
      A[3] = 4
      A[4] = 3
We can split this tape in four places:
P = 1, difference = |3 − 10| = 7
P = 2, difference = |4 − 9| = 5
P = 3, difference = |6 − 7| = 1
P = 4, difference = |10 − 3| = 7
In this case I would return 1 as it is the smallest difference.

N is an int, range [2..100,000]; each element of A is an int, range [−1,000..1,000]. It needs to be O(n) time complexity,
 */

public class TapeEquilibrium {
    public static void main(String[] args) {
        int[] A = new int[5];
        A[0] = 3;
        A[1] = 1;
        A[2] = 2;
        A[3] = 4;
        A[4] = 3;
        System.out.println("result:"+solution(A));

    }

    public static long solution(int[] A) {

        long sumright = 0;
        long sumleft = 0;
        long ans = -1;

        for (int i = 0; i < A.length; i++)
            sumright += A[i];

        ans = sumright;
        for (int i = 0; i < A.length-1; i++){
            sumleft += A[i];
            sumright -= A[i];
            //System.out.print("i="+i+",A[i]="+A[i]+" left:"+sumleft);
            //System.out.print(" , right:"+sumright+"\n");
            if (sumright - sumleft >0 && sumright - sumleft < ans)
                ans = sumright - sumleft;
            System.out.println(ans);

        }

        return ans;



    }
}
