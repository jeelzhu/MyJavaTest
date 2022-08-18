package codility;

import java.util.HashSet;
import java.util.Set;

public class AbsDistinct {
    public int solution(int[] A) {
        // write your code in Java SE 8
        Set<Integer> distincts = new HashSet<>();
        for (int value: A){
            distincts.add(Math.abs(value));
        }
        return distincts.size();
    }
}
