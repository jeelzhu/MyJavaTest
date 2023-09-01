package leetcode.slideWindow;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class PermutationOfString {
    
    public static boolean checkInclusion(String s1, String s2) {
        int permutationLength = s1.length();
        for (int i=0; i <s2.length()-permutationLength+1; i++){
            String tempString = s2.substring(i, i+permutationLength);
            if (compareStrings(s1, tempString)){
                return true;
            }
        }
        return false;
    }

    public static boolean compareStrings(String str1, String str2) {
        // Check for null strings
        if (str1 == null || str2 == null) {
            return false;
        }

        // Quick check on lengths
        if (str1.length() != str2.length()) {
            return false;
        }

        int[] charCount = new int[256];  // Assuming extended ASCII characters

        // Count frequency of each character in str1
        for (char c : str1.toCharArray()) {
            charCount[c]++;
        }

        // Verify frequencies in str2
        for (char c : str2.toCharArray()) {
            if (charCount[c] == 0) {
                return false;
            }
            charCount[c]--;
        }

        return true;
    }



    public static void main(String[] args) {
        String s1 =
        "adc",
        s2 =
        "dcda";
        System.out.println(" s1 ="+s1+" s2 ="+s2+"    "+   checkInclusion(s1,s2));

        s1 = "ab"; s2 = "eidbaooo";
        System.out.println(" s1 ="+s1+" s2 ="+s2+"    "+   checkInclusion(s1,s2));
        s1 = "ab";
        s2 = "eidboaoo";
        System.out.println(" s1 ="+s1+" s2 ="+s2+"    "+   checkInclusion(s1,s2));
        s1 = "hello";
        s2 = "ooolleoooleh";
        System.out.println(" s1 ="+s1+" s2 ="+s2+"    "+   checkInclusion(s1,s2));

    }
}
