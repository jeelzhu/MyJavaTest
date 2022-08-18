package codility;

public class Dominator {
    public int solution(int[] A) {

        int dominator = 0;
        int count =0;
        for (int i=0; i< A.length; i++){
            if ( count ==0){
                dominator = i;
            }

            if (A[dominator] == A[i])
                count++;
            else
                count --;
        }

        count =0;
        for (int i=0; i< A.length; i++) {
            if (A[i] == A[dominator])
                count++;
        }

        if (count >  A.length/2 ){
            return dominator;
        }
        return -1;

    }

    public static void main(String[] args) {
        Dominator dominator = new Dominator();
        int[] A =  {1,2, 1, 1,1, 3, 4};
        System.out.println(dominator.solution(A));
    }
}
