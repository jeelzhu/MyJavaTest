package codility;

public class FrogJmp {
    public static void main(String[] args) {
        System.out.println(solution(10, 85, 30));

    }
    public static int solution(int X, int Y, int D){
        //System.out.println((float)(Y -X)/D);
        //System.out.println((int) Math.ceil(2.0001));

        //return (int) Math.ceil((float)(Y -X)/D);

        int value = Y -X;
        int v1 = 0;
        int count =0;

        while(v1 < value){
            v1 +=D;
            count ++;
        }
        return count;
        //int remindar = (Y - X) /D;


    }
}
