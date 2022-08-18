package leetCode.easy;

public class AddDigits {
    public int addDigits(int num) {

        int result = num;
        while(result >= 10){
            result = result/10 + result%10;
        }
        return result;

        /*
        if (num < 10)
            return num;
        return addDigits(num/10 + num%10);
        */

    }

    public static void main(String[] args) {
        System.out.println(new AddDigits().addDigits(38));
    }
}
