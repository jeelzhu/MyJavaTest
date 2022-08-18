package codility;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        int[] A =  {-1, 3, 6, 4, -1, 2};
        Integer[] list = Arrays.stream( A ).boxed().toArray( Integer[]::new );

        Set<Integer> set = new HashSet<>(Arrays.asList(list));

        int size = set.size();
        for (int i=1; i<=size+1;i++){
            if(!set.contains(i)){
                System.out.println(i);
                break;
            }
            else {
                set.remove(i);
            }
        }

    }

    public int solution(int[] A) {
        Set<Integer> set = new HashSet<>();

        for (int i=0; i< A.length; i++){
            if (A[i] >0 )
                set.add(A[i]);
        }

        int size = set.size();
        if (size ==0)
            return 1;
        for (int i=1; i<=size+1;i++){
            if(!set.contains(i)){
                return i;
            }
        }
        return 1;
    }
}
