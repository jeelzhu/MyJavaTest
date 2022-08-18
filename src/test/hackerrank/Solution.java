package hackerrank;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;



class Result {

    /*
     * Complete the 'maxMin' function below.
     *
     * The function is expected to return a LONG_INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. STRING_ARRAY operations
     *  2. INTEGER_ARRAY x
     */

    public static List<Long> maxMin(List<String> operations, List<Integer> x) {
        // Write your code here
        List<Integer> list = new ArrayList<>();
        List<Long> result = new ArrayList<>();

        for (int i=0; i< operations.size(); i++){

            if(operations.get(i).equalsIgnoreCase("push")){
                list.add(x.get(i));
                Integer max = list.stream().max(Integer::compare).get();
                Integer min = list.stream().min(Integer::compare).get();
                result.add((long) (max * min));

            }
            else if(operations.get(i).equalsIgnoreCase("pop")){
                list.remove(x.get(i));

                Integer max = list.stream().max(Integer::compare).get();
                Integer min = list.stream().min(Integer::compare).get();
                result.add((long) (max * min));

            }
        }
        return result;
    }

    public static List<Integer> minimalOperations(List<String> words) {
        // Write your code here
        List<Integer> result = new ArrayList<>();
        words.forEach(word->{
            try {
                Double.parseDouble(word);
                result.add(0);
            } catch(NumberFormatException e){
                int count =0;
                for (char c :word.toCharArray()) {
                    char current = 0;
                    if (count == 0) {
                        current = c;
                        count++;
                    }
                    if (count > 0 && current == c) {
                        count++;
                    }
                    if (count > 0 && current != c){
                        current = c;
                        count=0;
                    }
                    if (count >1)
                        break;
                }
                if (count>1)
                    result.add(1);
                else
                    result.add(0);            }


        });
        return result;


    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        System.out.println(calculateLargest(100));
    }

    static String findNumber(List<Integer> arr, int k) {/*
        Set<Integer> result = arr.stream().filter(value -> value == k).collect(Collectors.toSet());
        if (result.isEmpty())
            return "Yes";
        return "No";*/

        boolean result = false;

        for (int value: arr){
            if (value == 5)
                result= true;
        }
        if (result)
            return "Yes";
        return "No";


    }

    static List<Integer> oddNumbers(int l, int r) {
        List<Integer> results = new ArrayList<>();
        for (int i=l; i<=r; i++){
            if (i%2 !=0)
                results.add(i);
        }
        return results;
    }

    static int calculateLargest(int max) {
        int largest =0;
        int maxAbsoluteValue = 0;

        for (int i =max; i>0; i--){

            if (isPrime((i))){
                int curentAbsoluteValue =getSumOfAbsoluteValue(i);
                if (curentAbsoluteValue > maxAbsoluteValue) {
                    maxAbsoluteValue = curentAbsoluteValue;
                    largest = i;
                }
            }
        }
        return largest;
    }

    static int getSumOfAbsoluteValue(int i){
        return i == 0 ? 0 : i % 10 + getSumOfAbsoluteValue(i / 10);

    }

    static boolean isPrime(int value) {
        if (value < 2)
            return false;
        else if (value == 2)
            return true;
        else if (value % 2 == 0)
            return false;

        int sqrt = (int) Math.sqrt(value);
        for (int i = 3; i <= sqrt; i += 2) {
            if (value % i == 0) {
                return false;
            }
        }
        return true;
    }


}
