package other;

public class KnapsackProblem {
    public static int[] weight ={1,2,4,2,5};
    public static int[] value ={5,3,5,3,2};
    public static void main(String[] args) {

        System.out.println(f(10,4));
    }

    public static int f(int w, int index){
        int result;
        if (w <= 0 || index <0 )
            result =0;
        else if (w >= weight[index]){
            int tmp1 = f(w, index-1);
            int tmp2 = value[index] + f(w - weight[index], index-1);
            result = Math.max(tmp1,tmp2);
        }
        else{
            result = f(w, index-1);
        }
        return result;

    }
}
