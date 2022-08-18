package interview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static List<List<Integer>> findSequences(List<Integer> input) {
        List<List<Integer>> result = new ArrayList<>();
        int min =input.get(0);
        int max =input.get(0);
        for (Integer value : input) {
            if (value > max)
                max = value;
            if (value < min)
                min = value;
        }

        for (int N = 2; N< input.size() && min*N*N < max; N++) {
            List<Integer> sequence = new ArrayList<>();
            int count = 0;
            for (Integer value : input) {
                if ((count == 0 && value == N) || (count > 0 && value == N * sequence.get(sequence.size() - 1))) {
                    count++;
                    sequence.add(value);
                }
            }
            if (count >= 3)
                result.add(sequence);

        }
        return result;
    }

    public static void main(String[] args) {

        Integer[] input = {2, 10, 4, 3, 8, 6, 9, 9, 18, 27, 1, 52, 81, 10, 1, 0, 2, 0, 4, 0, 8, 0, 16,
                0, 32, 0, 64, 0, 128, 2, 10, 4, 3, 8, 6, 9, 9, 18, 27, 1, 52, 81, 10, 100, 50, 0, 0, 0, 0, 0, 0};
        List<Integer> inputList = Arrays.asList(input);

        int sum =0;

        List<List<Integer>> result = findSequences(inputList);
        for (List<Integer> list: result){
            for (Integer value : list){
                System.out.print(value + " ");
                sum += value;
            }
            System.out.println();

        }
        System.out.println("sum = "+sum);

    }
}
