package codility;

import java.util.HashSet;
import java.util.Set;

public class ChocolatesByNumbers {

    //not efficient
    public int solution(int N, int M) {
        Set<Integer> chocolates = new HashSet<>();
        int position =0;
        while(position < N){
            if(!chocolates.add(position))
                break;
            position = (position+M)%N;
        }
        return chocolates.size();
    }

    public int gcd(int a, int b){
        if (b == 0) return a;
        else return gcd(b, a % b);
    }

    public static void main(String[] args) {
        System.out.println(12/10);
        //System.out.println(new ChocolatesByNumbers().solution(947853, 4453));
        System.out.println(new ChocolatesByNumbers().gcd(50,60));
    }
}
