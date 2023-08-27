package others;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MyTest {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        List<Integer> result = new ArrayList<>();
        for (int i=0; i<m; i++){
            result.add(nums1[i]);
        }
        for (int i=0; i<n; i++){
            result.add(nums2[i]);
        }
        int[] resultArr = result.stream().mapToInt(Integer::intValue).toArray();

        Arrays.sort(resultArr);
        Arrays.stream(resultArr).forEach(System.out::print);

    }

    public static void main(String[] args) {
        MyTest myTest = new MyTest();
        int[] nums1 = {1,2,3,0,0,0}
        ;
        int m =3;
        int[] nums2 ={2,5,6};
        int n=3;
        myTest.merge(nums1, m, nums2, n);
    }
}
