package codility;

public class NumberSolitaire {
    public static void main(String[] args) {
        int[] A = {-4, -10, -7};
        //int[] A ={-1, -2, -3, -4, -3, -8, -5, -2, -3, -4, -5, -6, -1};
        //int[] A ={10,10,10,10,10,10};
        NumberSolitaire numberSolitaire = new NumberSolitaire();
        int result = numberSolitaire.solution(A);
        System.out.println(result);
    }

    public int solution(int[] A) {
        int length = A.length;
        int dp[] = new int[length];
        dp[0]=A[0];

        for (int i=1; i< length; i++){
            int max = Integer.MIN_VALUE;
            for (int die=1; die<=6; die++){
                if( i-die >= 0){
                    max = Math.max(dp[i-die]+A[i], max);
                }
            }
            dp[i]= max;

        }
        return dp[length-1];

    }


    public int solution222(int[] A) {

        // main idea:
        // using "dynamic programming" to build up the solution
        // (bottom up)

        int[] dp = new int[A.length];
        dp[0] = A[0];

        // build up from "dp[1], dp[2], ..., dp[A.length-1]"
        for(int i=1; i<A.length; i++){

            // keep the biggest one
            // be very careful: could be negtive (so use Integer.MIN_VALUE)
            int max = Integer.MIN_VALUE;

            // a die could be "1 to 6"
            for(int die=1; die<=6; die++){
                if( i-die >= 0){
                    // very important: not "A[i-die]+A[i]"
                    // instead, have to use "dp[i-die]+A[i]"
                    max = Math.max( dp[i-die]+A[i], max );
                    // dynamic programming:
                    // take the best:
                    // takeBest( dp[i-j] + value[j], curBest )
                }
            }
            dp[i] = max; // keep the best one as the dp value
        }

        return dp[A.length-1];
    }
}
