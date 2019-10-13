package codility;

public class MaxProfit {
    public static int solution(int[] A) {
        // write your code in Java SE 8
        int length = A.length;
        if (length ==0)
            return 0;
        int min =A[0];
        int result =-1;

        for (int i=1; i< length;i++){
            if (min > A[i])
                min = A[i];
            if (A[i] - min > result)
                result = A[i] - min;
        }
        return result >0 ?result:0;
    }

    public static void main(String[] args) {
        int[] A = new int[6];
        A[0] = 23171;
        A[1] = 21011;
        A[2] = 21123;
        A[3] = 21366;
        A[4] = 21013;
        A[5] = 21367;
        System.out.println(solution(A));
    }
}
