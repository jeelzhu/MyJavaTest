package codility;

import java.util.ArrayList;
import java.util.List;

public class Peak {
    public int solution(int[] A) {
        final int N = A.length;
        List<Integer> peaks = new ArrayList<>();
        for(int i = 1; i < N-1; i++){
            if(A[i] > A[i-1] && A[i] > A[i+1]) peaks.add(i);
        }

        for (int size=1; size<= N; size++){
            if (N%size !=0) continue;
            int find =0;
            int groups = N/size;
            boolean ok = true;
            for (int peakIdx: peaks){
                if (peakIdx/ size > find ) {
                    ok = false;
                    break;
                }
                if (peakIdx/ size == find )  find++;
            }
            if (find != groups ) ok = false;
            if (ok)  return groups;
        }
        return 0;
    }

    public static void main(String[] args) {
        //System.out.println(3/4);

        //int[] A = {1, 2, 3, 4, 3, 4, 1, 2, 3, 4, 6, 2};
        int[] A = {1, 2, 4, 5, 3, 4, 6, 2, 5, 4, 6, 2};
        //int[] A = {1, 2, 4, 4, 5, 4, 1, 2, 3, 4, 6,5};
        //int[] A = {1, 3, 2};
        System.out.println(new Peak().solution(A));
    }
}
