package geeks;

public class Ternary {

    public int count1(int n){

        int count =0;
        int remaining;
        do{
            remaining = n%3;
            n = n/3;
            if (n == 1)
                count ++;

            if (remaining ==1)
                count ++;

        }while(n >=3);
        return count;

    }

    public static void main(String[] args) {

        System.out.println(new Ternary().count1(1));
        System.out.println(new Ternary().count1(2));
        System.out.println(new Ternary().count1(3));
        System.out.println(new Ternary().count1(4));
        System.out.println(new Ternary().count1(5));
        System.out.println(new Ternary().count1(6));
        System.out.println(new Ternary().count1(7));
        System.out.println(new Ternary().count1(8));
        System.out.println(new Ternary().count1(9));
        System.out.println(new Ternary().count1(10));
        System.out.println(new Ternary().count1(13));

    }
}
