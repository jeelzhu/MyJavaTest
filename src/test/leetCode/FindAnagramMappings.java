package leetCode;

public class FindAnagramMappings {
    public int[] anagramMappings(int[] A, int[] B) {

        int[] result = new int[A.length];


        int pos =0;
        for (int a :A){
            int index =0;
            for (int b:B){
                if (a == b)
                    break;
                index ++;
            }
            result[pos] = index;
            pos++;
        }

        return result;
    }

    public static void main(String[] args) {

        for (int i=0; i<10; i++){
            for (int j=100; j<110; j++) {
                if (j==102)
                    break;
                System.out.println("   "+j);
            }

            System.out.println(i);
        }

    }
}
