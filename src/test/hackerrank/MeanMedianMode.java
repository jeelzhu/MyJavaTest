package hackerrank;

import java.math.BigDecimal;
import java.math.BigInteger;

public class MeanMedianMode {
    public static void main(String[] args) {
        int[] values ={64630 ,11735, 14216, 99233, 14470, 4978, 73429 ,38120 ,51135, 67060};
        BigDecimal total = BigDecimal.ZERO;

        for (int i=0 ; i< values.length; i++){
            total =total.add(BigDecimal.valueOf(values[i]));
        }

        BigDecimal mean = total.divide(BigDecimal.valueOf(values.length));
        System.out.println(mean);
    }
}
