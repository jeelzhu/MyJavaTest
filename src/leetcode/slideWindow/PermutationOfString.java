package leetcode.slideWindow;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class PermutationOfString {
    
    public static boolean checkInclusion(String s1, String s2) {
        int s1Length = s1.length();
        int s2Length = s2.length();
        if (s1Length > s2Length)
            return false;
        Map<Character, Integer> s1Map = new HashMap<>();
        Map<Character, Integer> s2Map = new HashMap<>();
        for (int i=0; i < s1Length; i++){
            s1Map.put(s1.charAt(i), s1Map.getOrDefault(s1.charAt(i), 0)+1);
            s2Map.put(s2.charAt(i), s2Map.getOrDefault(s2.charAt(i), 0)+1);
        }
        if (s1Map.equals(s2Map))
            return true;
        for (int i=0; i < s2Length - s1Length; i++){
            Character out = s2.charAt(i);
            Character in = s2.charAt(i+s1Length);
            s2Map.put(out, s2Map.get(out)-1);
            s2Map.put(in, s2Map.getOrDefault(in,0)+1);
            if (s2Map.get(out)==0){
                s2Map.remove(out);
            }
            if (s1Map.equals(s2Map))
                return true;
        }
        return false;
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
