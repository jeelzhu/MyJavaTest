package leetcode.slideWindow;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class TestSlideWindow {
    public static void main(String[] args) {
        String s = "abcb";
        System.out.println(s+" "+lengthOfLongestSubstring(s));
        s = "au";
        System.out.println(s+" "+lengthOfLongestSubstring(s));
        s = "abcabcbb";
        System.out.println(s+" "+lengthOfLongestSubstring(s));
        s = "bbbbb";
        System.out.println(s+" "+lengthOfLongestSubstring(s));
        s = "pwwkew";
        System.out.println(s+" "+lengthOfLongestSubstring(s));
        s = " ";
        System.out.println(s+" "+lengthOfLongestSubstring(s));
         s = "dvdf";
        System.out.println(s+" "+lengthOfLongestSubstring(s));
    }
//"pwwkew"
//abcb
    private static int lengthOfLongestSubstring(String s) {
        int maxLength =0;
        for (int left=0, right =0; right<s.length(); right++){
            Character currentCharacter = s.charAt(right);
            int leftPositionOfCharacter = s.indexOf(currentCharacter.toString(), left);
            if (leftPositionOfCharacter < right){
                left = leftPositionOfCharacter +1;
            }
            maxLength = Math.max(maxLength, right - left +1);
        }
        return maxLength;
    }

    private static int lengthOfLongestSubstringUsingSet(String s) {
        Set<Character> set = new HashSet<>();
        int maxLength =0;
        for (int left=0, right =0; right<s.length(); right++){
            Character currentCharacter = s.charAt(right);
            int leftPositionOfCharacter = s.indexOf(currentCharacter.toString(), left);
            if (set.contains(currentCharacter) && leftPositionOfCharacter < right){
                left = leftPositionOfCharacter +1;
            }
            maxLength = Math.max(maxLength, right - left +1);
            set.add(currentCharacter);
        }
        return maxLength;
    }

    private static int lengthOfLongestSubstringUsingMap(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int maxLength =0;
        for (int left=0, right =0; right<s.length(); right++){
            Character currentCharacter = s.charAt(right);
            if (map.containsKey(currentCharacter) && map.get(currentCharacter) >= left ){
                left = map.get(currentCharacter)+1;
            }
            maxLength = Math.max(maxLength, right - left +1);
            map.put(currentCharacter, right);
        }
        return maxLength;
    }
}
