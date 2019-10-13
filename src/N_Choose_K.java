import java.lang.reflect.Array;
import java.math.BigInteger;
import java.util.Arrays;

public class N_Choose_K {
    public static void main(String[] args) {
        N_Choose_K n_choose_k = new N_Choose_K(BigInteger.valueOf(20),BigInteger.valueOf(8));
        System.out.println(n_choose_k.getResult());

    }

    //N! / (K! * (N-K)!)
    private BigInteger N;
    private BigInteger K;

    public N_Choose_K(BigInteger N, BigInteger K) {
        String str;
        char[] cha1;
        if (N.compareTo(K) > 0  && K.compareTo(BigInteger.ZERO) > 0) {
            this.N = N;
            this.K = K;
        }
        else{
            throw new RuntimeException("Wrong format");
        }
    }

    BigInteger getResult() {
        //System.out.println(factorial(N));
        //System.out.println();

        return factorial(N).divide(factorial(K).multiply(factorial(N.subtract(K))));
    }

    private BigInteger factorial(BigInteger number){
        if (number.compareTo(BigInteger.ONE) ==0)
            return BigInteger.ONE;
        else
            return factorial(number.subtract(BigInteger.ONE)).multiply(number);
    }


}
